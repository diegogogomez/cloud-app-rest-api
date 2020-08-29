package com.cloud.cloudapprestapi.web.model;

import javax.persistence.*;

public class BillDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bill_id")
    private int billId;

    @Column(name = "bill_quantity")
    private int billQuantity;

    @Column(name = "bill_total")
    private double billTotal;

    @Column(name = "bill_dispatch")
    private String billDispatch;

    @ManyToOne
    @JoinColumn(name = "bill_product", nullable = false)
    private ProductDto product;

}
