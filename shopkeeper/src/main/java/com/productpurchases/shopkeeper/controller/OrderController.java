package com.productpurchases.shopkeeper.controller;

import com.productpurchases.shopkeeper.dto.ResponseDTO;
import com.productpurchases.shopkeeper.entity.Order;
import com.productpurchases.shopkeeper.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by lucascmarques on 04/06/17.
 */
@RestController
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @RequestMapping(value = "/order", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDTO<Order> createOrder(@RequestBody Order order) {
        Order orderSaved = orderRepository.save(order);
        ResponseDTO<Order> response = new ResponseDTO<Order>(orderSaved);
        response.add(linkTo(methodOn(OrderController.class).createOrder(order)).withSelfRel());
        return response;
    }

    @RequestMapping(value = "/orders", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Order> listAllOrders() {
        return (List<Order>) orderRepository.findAll();
    }

}
