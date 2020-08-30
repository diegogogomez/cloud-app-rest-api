package com.cloud.cloudapprestapi.dao;

import com.cloud.cloudapprestapi.web.model.PreventDto;
import com.cloud.cloudapprestapi.web.model.ResponseDto;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.validation.Valid;

public interface BillRepositoryCustom  {
    String getSaludo();
    ResponseDto getResponse(PreventDto preventDto);
}
