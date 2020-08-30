package com.cloud.cloudapprestapi.dao;

import com.cloud.cloudapprestapi.web.model.ProductDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "product", path = "product")
public interface ProductRepository extends JpaRepository<ProductDto, Integer>, ProductRepositoryCustom {
}
