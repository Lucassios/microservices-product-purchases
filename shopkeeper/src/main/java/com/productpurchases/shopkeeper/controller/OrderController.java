package com.productpurchases.shopkeeper.controller;

import com.productpurchases.shopkeeper.entity.Order;
import com.productpurchases.shopkeeper.entity.Order.OrderRequestStatus;
import com.productpurchases.shopkeeper.repository.OrderRepository;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

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
@EnableSwagger2
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @RequestMapping(value = "/order", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateOrder(@RequestBody String orderCode, Date deliveryDate) {
        Order order = orderRepository.findByOrderCode(orderCode);
        order.setDeliveryDate(deliveryDate);
        orderRepository.save(order);
    }
    
    @RequestMapping(value = "/orderStatus", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateOrderStatus(@RequestBody String orderCode, OrderRequestStatus status) {
        Order order = orderRepository.findByOrderCode(orderCode);
        order.setStatus(status);
        orderRepository.save(order);
    }    

}
