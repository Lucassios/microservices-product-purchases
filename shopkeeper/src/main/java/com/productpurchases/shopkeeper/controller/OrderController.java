package com.productpurchases.shopkeeper.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.productpurchases.shopkeeper.entity.Order;
import com.productpurchases.shopkeeper.entity.Order.OrderRequestStatus;
import com.productpurchases.shopkeeper.repository.OrderRepository;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by lucascmarques on 04/06/17.
 */
@RestController
@EnableSwagger2
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @RequestMapping(value = "/order", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateOrder(@RequestParam Long orderCode, @RequestBody Date deliveryDate) {
        Order order = orderRepository.findByWholesalerOrderCode(orderCode);
        if (order == null){
        	order = new Order();
        	order.setWholesalerOrderCode(orderCode);
        	order.setStatus(OrderRequestStatus.REQUESTED);
        }
        order.setDeliveryDate(deliveryDate);
        orderRepository.save(order);
    }
    
    @RequestMapping(value = "/order/updateOrderStatus", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateOrderStatus(@RequestParam Long orderCode, @RequestBody OrderRequestStatus status) {
        Order order = orderRepository.findByWholesalerOrderCode(orderCode);
        if (order == null){
        	order = new Order();
        	order.setWholesalerOrderCode(orderCode);
        }
        order.setStatus(status);
        orderRepository.save(order);
    }     
           
}
