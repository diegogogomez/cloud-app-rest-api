package com.cloud.cloudapprestapi.web.rest;

import com.cloud.cloudapprestapi.service.ProductService;
import com.cloud.cloudapprestapi.web.model.ProductDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductRestController {

    private ProductService productService;

    public ProductRestController(ProductService theProductService) {
        this.productService = theProductService;
    }


    @CrossOrigin
    @GetMapping("/products")
    public List<ProductDto> findAll(){
        return productService.findAll();
    }

    @GetMapping("/products/{productId}")
    public ProductDto getProduct(@PathVariable int productId){
        ProductDto theProduct = productService.findById(productId);
        if(theProduct == null){
            throw new RuntimeException("ID del producto " + productId + " no encontrado.");
        }

        return theProduct;
    }

    @PostMapping("/products")
    public ProductDto addProduct(@RequestBody ProductDto theProduct){
        theProduct.setProductId(0);
        productService.save(theProduct);
        return theProduct;
    }

    @PutMapping("/products")
    public ProductDto updateProduct(@RequestBody ProductDto theProduct){
        productService.save(theProduct);
        return theProduct;
    }

    @DeleteMapping("/products/{productId}")
    public String deleteProdut(@PathVariable int productId){
        ProductDto tempProduct = productService.findById(productId);
        if(tempProduct == null){
            throw new RuntimeException("Producto con ID:" + productId + " no encontrado.");
        }
        productService.deleteById(productId);
        return "Id:" + productId + "- Producto Eliminado.";
    }

}
