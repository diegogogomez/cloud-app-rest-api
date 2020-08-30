package com.cloud.cloudapprestapi.dao;

import com.cloud.cloudapprestapi.web.model.BillDto;
import com.cloud.cloudapprestapi.web.model.PreventDto;
import com.cloud.cloudapprestapi.web.model.ProductDto;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepositoryCustom {

    private EntityManager entityManager;

    @Autowired
    public ProductRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<BillDto> getProductList() {
        // Query theQuery = entityManager.createQuery("SELECT b.billId FROM ProductDto p INNER JOIN p.billings b");
        Query theQuery = entityManager.createQuery("FROM BillDto b INNER JOIN b.product p");

        List<BillDto> bills = theQuery.getResultList();


        return bills;
    }
}












