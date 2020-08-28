package com.cloud.cloudapprestapi.dao;

import com.cloud.cloudapprestapi.web.model.ProductDto;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ProductDaoImplHibernate implements ProductDao {

    private EntityManager entityManager;

    @Autowired
    public ProductDaoImplHibernate(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<ProductDto> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<ProductDto> theQuery = currentSession.createQuery("from ProductDto", ProductDto.class);
        List<ProductDto> products = theQuery.getResultList();
        return products;
    }

    @Override
    public ProductDto findById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        ProductDto theProduct = currentSession.get(ProductDto.class, theId);
        return theProduct;
    }

    @Override
    public void save(ProductDto theProduct) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(theProduct);
    }

    @Override
    public void deleteById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query theQuery = currentSession.createQuery("delete from ProductDto where id=:productId");
        theQuery.setParameter("productId", theId);
        theQuery.executeUpdate();
    }
}
