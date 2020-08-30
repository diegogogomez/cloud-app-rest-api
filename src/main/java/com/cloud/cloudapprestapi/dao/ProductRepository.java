package com.cloud.cloudapprestapi.dao;

import com.cloud.cloudapprestapi.web.model.ProductDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(collectionResourceRel = "product", path = "product")
@CrossOrigin
public interface ProductRepository extends JpaRepository<ProductDto, Integer>, ProductRepositoryCustom {
}
