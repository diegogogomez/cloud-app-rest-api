package com.cloud.cloudapprestapi.dao;

import com.cloud.cloudapprestapi.web.model.BillDto;
import com.cloud.cloudapprestapi.web.model.PreventDto;
import com.cloud.cloudapprestapi.web.model.ProductDto;

import java.util.List;

public interface ProductRepositoryCustom {
    public List<BillDto> getProductList();
}
