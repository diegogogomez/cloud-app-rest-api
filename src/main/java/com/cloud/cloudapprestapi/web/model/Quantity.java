package com.cloud.cloudapprestapi.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Quantity {

    private int productId;
    private int quantity;
    private double spend;

}
