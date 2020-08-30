package com.cloud.cloudapprestapi.dao;

import com.cloud.cloudapprestapi.web.model.BillDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin
public interface BillRepository extends JpaRepository<BillDto, Integer>, BillRepositoryCustom {

}
