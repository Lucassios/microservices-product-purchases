package com.productpurchases.shopkeeper.controller;

import com.productpurchases.shopkeeper.entity.Order;
import com.productpurchases.shopkeeper.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by lucascmarques on 04/06/17.
 */
@RestController
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @RequestMapping(value = "/order", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateOrder(@RequestBody String orderCode, Date deliveryDate) {
        Order order = orderRepository.findByOrderCode(orderCode);
        order.setDeliveryDate(deliveryDate);
        orderRepository.save(order);
    }

}
