package com.cloud.cloudapprestapi.dao;

import com.cloud.cloudapprestapi.web.model.ProductDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductDto, Integer> {
}
