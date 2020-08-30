package com.cloud.cloudapprestapi.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "bills")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillDto implements Serializable {

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
    @JoinColumn(name = "bill_product")
    private ProductDto product;


}
