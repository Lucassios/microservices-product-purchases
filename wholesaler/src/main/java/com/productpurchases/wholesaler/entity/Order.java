package com.productpurchases.wholesaler.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
    private Long orderCode;
    
    @Temporal(TemporalType.DATE)
    private Date deliveryDate;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<ProductOrder> productOrders;

    @NotNull
    @Enumerated(EnumType.ORDINAL)
    private OrderRequestStatus status;

}
