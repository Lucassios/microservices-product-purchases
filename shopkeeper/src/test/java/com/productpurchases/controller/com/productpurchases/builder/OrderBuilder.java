package com.productpurchases.controller.com.productpurchases.builder;

import com.productpurchases.entity.Order;

import java.math.BigDecimal;

/**
 * Created by lucascmarques on 04/06/17.
 */
public class OrderBuilder {

    private Order order = new Order();

    public OrderBuilder productId(Long productId) {
        order.setProductId(productId);
        return this;
    }

    public OrderBuilder quantity(BigDecimal quantity) {
        order.setQuantity(quantity);
        return this;
    }

    public OrderBuilder notes(String notes) {
        order.setNotes(notes);
        return this;
    }

    public Order build() {
        Order order = this.order;
        this.order = new Order();
        return order;
    }

}
