package com.cloud.cloudapprestapi.web.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="products")
@Getter
@Setter
public class ProductDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_price")
    private double productPrice;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id_producto")
    private Set<BillDto> billings;

}
