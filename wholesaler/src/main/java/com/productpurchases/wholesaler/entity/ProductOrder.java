package com.productpurchases.wholesaler.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * Created by lucascmarques on 04/06/17.
 */
@Data
@Entity(name = "product_orders")
public class ProductOrder {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String productCode;

    @NotNull
    private BigDecimal quantity;

    private String notes;

}
