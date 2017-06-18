package com.productpurchases.shopkeeper.controller.com.productpurchases.builder;

import com.productpurchases.shopkeeper.entity.ProductOrder;

import java.math.BigDecimal;

/**
 * Created by lucascmarques on 04/06/17.
 */
public class OrderBuilder {

    private ProductOrder order = new ProductOrder();

    public OrderBuilder id(Long id) {
        order.setId(id);
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

    public ProductOrder build() {
        ProductOrder order = this.order;
        this.order = new ProductOrder();
        return order;
    }

}
