package com.cloud.cloudapprestapi.service;

import com.cloud.cloudapprestapi.dao.ProductDao;
import com.cloud.cloudapprestapi.web.model.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductDao productDao;

    @Autowired
    public ProductServiceImpl(@Qualifier("productDaoImplJpa") ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    @Transactional
    public List<ProductDto> findAll() {
        return productDao.findAll();
    }

    @Override
    @Transactional
    public ProductDto findById(int theId) {
        return productDao.findById(theId);
    }

    @Override
    @Transactional
    public void save(ProductDto theProduct) {
        productDao.save(theProduct);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        productDao.deleteById(theId);
    }
}
