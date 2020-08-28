package com.cloud.cloudapprestapi.dao;

import com.cloud.cloudapprestapi.web.model.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class ProductDaoImplJpa implements ProductDao {

    private EntityManager entityManager;

    @Autowired
    public ProductDaoImplJpa(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<ProductDto> findAll() {
        Query theQuery = entityManager.createQuery("from ProductDto");

        List<ProductDto> products = theQuery.getResultList();

        return products;
    }

    @Override
    public ProductDto findById(int theId) {
        ProductDto theProduct = entityManager.find(ProductDto.class, theId);
        return theProduct;
    }

    @Override
    public void save(ProductDto theProduct) {
        ProductDto product = entityManager.merge(theProduct);
        theProduct.setProductId(product.getProductId());
    }

    @Override
    public void deleteById(int theId) {
        Query theQuery = entityManager.createQuery("delete from ProductDto where id=:productId");
        theQuery.setParameter("productId", theId);
        theQuery.executeUpdate();
    }
}
