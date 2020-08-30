package com.cloud.cloudapprestapi.dao;

import com.cloud.cloudapprestapi.web.model.BillDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<BillDto, Integer>, BillRepositoryCustom {

}
