package com.cloud.cloudapprestapi.service;

import com.cloud.cloudapprestapi.dao.ProductRepository;
import com.cloud.cloudapprestapi.web.model.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository theProductRepository) {
        this.productRepository = theProductRepository;
    }

    @Override
    public List<ProductDto> findAll() {
        return productRepository.findAll();
    }

    @Override
    public ProductDto findById(int theId) {
        Optional<ProductDto> result = productRepository.findById(theId);
        ProductDto theProduct = null;
        if(result.isPresent()){
            theProduct = result.get();
        }else{
            throw new RuntimeException("No se encontro el producto con id: " + theId);
        }
        return theProduct;
    }

    @Override
    public void save(ProductDto theProduct) {
        productRepository.save(theProduct);
    }

    @Override
    public void deleteById(int theId) {
        productRepository.deleteById(theId);
    }
}
