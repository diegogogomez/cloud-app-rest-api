package com.cloud.cloudapprestapi.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {

    private int billId;
    private boolean billStatus;
    private double billDesc;
    private String billDispatch;

}
