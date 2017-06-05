package com.productpurchases.wholesaler.controller;

import com.productpurchases.wholesaler.dto.ResponseDTO;
import com.productpurchases.wholesaler.entity.Order;
import com.productpurchases.wholesaler.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseDTO<Order> requestOrder(@RequestBody Order order) {
        order.setStatus(Order.OrderRequestStatus.REQUESTED);
        Order orderSaved = orderRepository.save(order);
        ResponseDTO<Order> response = new ResponseDTO<Order>(orderSaved);
        response.add(linkTo(methodOn(OrderController.class).requestOrder(order)).withSelfRel());
        return response;
    }

}
