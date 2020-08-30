package com.cloud.cloudapprestapi.web.rest;

import com.cloud.cloudapprestapi.dao.BillRepository;
import com.cloud.cloudapprestapi.dao.ProductRepository;
import com.cloud.cloudapprestapi.web.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/v2")
public class PruebaController {

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private ProductRepository productRepository;



    @PostMapping("/bills")
    @CrossOrigin
    public ResponseDto pruebaSaludo(@Valid @RequestBody PreventDto preventDto, BindingResult result){

        System.out.println(result.hasErrors());

        ResponseDto response = null;

        if(result.hasErrors()){
            response = new ResponseDto(0, false, 0, "Error");
        }else{
            response = billRepository.getResponse(preventDto);
        }

        System.out.println("" + preventDto.getProductId());
        System.out.println("" + preventDto.getQuantity());
        System.out.println("" + preventDto.getPreventId());

        return response;
    }

    @GetMapping("/obtain_products")
    @CrossOrigin
    public List<Quantity> obtainProducts(){

        List<Quantity> respuesta = new ArrayList<>();

        List<BillDto> listaFacturas = productRepository.getProductList();

        for(BillDto bill: listaFacturas){
            respuesta.add(new Quantity(
                    bill.getProduct().getProductId(),
                    bill.getBillQuantity(),
                    bill.getBillQuantity()*bill.getProduct().getProductPrice()));
        }

        return respuesta;
        //return "total facturas: " + facturas.size() + " - cantidad: " + facturas.get(5).getBillQuantity() +
                //" - id producto: " + facturas.get(5).getProduct().getProductId();
    }

}
