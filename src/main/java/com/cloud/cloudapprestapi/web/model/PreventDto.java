package com.cloud.cloudapprestapi.web.model;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "prevents")
@Data
public class PreventDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    @Min(value = 1)
    @NotNull
    private int productId;

    @Min(value = 1)
    @NotNull
    @Column(name = "quantity")
    private int quantity;


    @Min(value = 1)
    @NotNull
    @Column(name = "prevent_id")
    private int preventId;
}
