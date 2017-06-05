package com.productpurchases.entity;

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
@Entity(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private Long productId;

    @NotNull
    private BigDecimal quantity;

    private String notes;

}
