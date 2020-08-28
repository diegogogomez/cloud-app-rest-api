package com.cloud.cloudapprestapi.service;

import com.cloud.cloudapprestapi.web.model.ProductDto;

import java.util.List;

public interface ProductService {

    public List<ProductDto> findAll();
    public ProductDto findById(int theId);
    public void save(ProductDto theProduct);
    public void deleteById(int theId);

}
