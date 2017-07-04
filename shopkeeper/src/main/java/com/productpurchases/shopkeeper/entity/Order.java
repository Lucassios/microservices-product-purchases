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
        REQUESTED, PROGRESS, FINISHED, DISPATCHED, REJECTED
    }

    @Id
    @GeneratedValue
    private Long orderId;
    
    private Long wholesalerOrderCode;

    @Temporal(TemporalType.DATE)
    private Date deliveryDate;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ProductOrder> productOrders;

    @Enumerated(EnumType.ORDINAL)
    private OrderRequestStatus status;

}
