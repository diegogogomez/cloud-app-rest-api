package com.cloud.cloudapprestapi.dao;

import com.cloud.cloudapprestapi.web.model.BillDto;
import com.cloud.cloudapprestapi.web.model.PreventDto;
import com.cloud.cloudapprestapi.web.model.ProductDto;
import com.cloud.cloudapprestapi.web.model.ResponseDto;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.validation.Valid;

import org.hibernate.query.Query;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

// @Transactional(readOnly = true)
@Repository
public class BillRepositoryImpl implements BillRepositoryCustom {

    private EntityManager entityManager;

    @Autowired
    public BillRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public String getSaludo() {
        return "hola";
    }

    @Override
    public ResponseDto getResponse(@Valid PreventDto preventDto) {

        ProductDto theProduct = null;
        BillDto bill = null;
        ResponseDto responseDto = null;



        Session currentSession = entityManager.unwrap(Session.class);


        try {
            theProduct = currentSession.get(ProductDto.class, preventDto.getProductId());
        }catch (RuntimeException exception){
            theProduct = null;
        }

        if(theProduct == null){
            System.out.println("error de entrada de id de producto");
            return new ResponseDto(0, false, 0, "Error");
        }else{
            try {
                bill = new BillDto
                        (0,
                                preventDto.getQuantity(),
                                theProduct.getProductPrice() * preventDto.getQuantity(),
                                "pradera",
                                theProduct);
            } catch (RuntimeException exception){
                bill = null;
            }
            if(bill == null){
                System.out.println("error generando factura");
                return new ResponseDto(0, false, 0, "Error");
            }else {
                currentSession.saveOrUpdate(bill);

                responseDto = new ResponseDto(bill.getBillId(), true, bill.getBillTotal(), bill.getBillDispatch());

            }
        }

        return responseDto;
    }
}
