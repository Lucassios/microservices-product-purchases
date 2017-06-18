package com.productpurchases.shopkeeper.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by lucascmarques on 05/06/17.
 */
@Data
@Entity(name = "orders")
public class Order {

    public enum OrderRequestStatus {
        REQUESTED, PROGRESS, FINISHED, DISPATCHED
    }

    @Id
    @GeneratedValue
    private Long id;

    private String orderCode;

    @Temporal(TemporalType.DATE)
    private Date deliveryDate;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ProductOrder> productOrders;

    @Enumerated(EnumType.ORDINAL)
    private OrderRequestStatus status;

}
