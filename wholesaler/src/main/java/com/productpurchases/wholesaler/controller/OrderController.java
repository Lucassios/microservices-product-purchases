package com.productpurchases.wholesaler.controller;

import com.productpurchases.wholesaler.dto.ResponseDTO;
import com.productpurchases.wholesaler.entity.Order;
import com.productpurchases.wholesaler.entity.Order.OrderRequestStatus;
import com.productpurchases.wholesaler.repository.OrderRepository;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

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
@EnableSwagger2
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @RequestMapping(value = "/order", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDTO<Order> requestOrder(@RequestBody Order order) {
        order.setStatus(Order.OrderRequestStatus.REQUESTED);
        Order orderSaved = orderRepository.save(order);
        ResponseDTO<Order> response = new ResponseDTO<Order>(orderSaved);
        response.add(linkTo(methodOn(OrderController.class).requestOrder(orderSaved)).withSelfRel());
        return response;
    }

    @RequestMapping(value = "/confirmOrder", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDTO<Order> confirmOrder(@RequestBody String orderCode) {
        Order orderRequired = orderRepository.findByOrderCode(orderCode);
        orderRequired.setStatus(OrderRequestStatus.PROGRESS);
        orderRepository.save(orderRequired);
        ResponseDTO<Order> response = new ResponseDTO<Order>(orderRequired);
        response.add(linkTo(methodOn(OrderController.class).requestOrder(orderRequired)).withSelfRel());
        return response;
    }
    
    @RequestMapping(value = "/rejectOrder", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDTO<Order> rejectOrder(@RequestBody String orderCode) {
        Order orderRequired = orderRepository.findByOrderCode(orderCode);
        orderRequired.setStatus(OrderRequestStatus.REJECTED);
        orderRepository.save(orderRequired);
        ResponseDTO<Order> response = new ResponseDTO<Order>(orderRequired);
        response.add(linkTo(methodOn(OrderController.class).requestOrder(orderRequired)).withSelfRel());
        return response;
    }    
    
}
