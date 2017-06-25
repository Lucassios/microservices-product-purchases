package com.productpurchases.wholesaler.controller;

import com.productpurchases.wholesaler.dto.ResponseDTO;
import com.productpurchases.wholesaler.entity.Order;
import com.productpurchases.wholesaler.entity.Order.OrderRequestStatus;
import com.productpurchases.wholesaler.repository.OrderRepository;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;

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
        response.add(linkTo(methodOn(OrderController.class).confirmOrder(orderSaved.getOrderCode())).withRel("confirmOrder"));
        response.add(linkTo(methodOn(OrderController.class).rejectOrder(orderSaved.getOrderCode())).withRel("rejectOrder"));
        return response;
    }

    @RequestMapping(value = "/order/{orderId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDTO<Order> getOrderById(@PathVariable Long orderId) {
    	Order orderRequired = orderRepository.findById(orderId);
        ResponseDTO<Order> response = new ResponseDTO<Order>(orderRequired);
        response.add(linkTo(methodOn(OrderController.class).getOrderById(orderRequired.getId())).withSelfRel());
        return response;
    }
    
    
    @RequestMapping(value = "/order/confirmOrder", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDTO<Order> confirmOrder(@RequestParam String orderCode) {
        Order orderRequired = orderRepository.findByOrderCode(orderCode);
        orderRequired.setStatus(OrderRequestStatus.PROGRESS);
        orderRepository.save(orderRequired);
        ResponseDTO<Order> response = new ResponseDTO<Order>(orderRequired);
        response.add(linkTo(methodOn(OrderController.class).confirmOrder(orderRequired.getOrderCode())).withSelfRel());
        return response;
    }
    
    @RequestMapping(value = "/order/rejectOrder", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDTO<Order> rejectOrder(@RequestParam String orderCode) {
        Order orderRequired = orderRepository.findByOrderCode(orderCode);
        orderRequired.setStatus(OrderRequestStatus.REJECTED);
        orderRepository.save(orderRequired);
        ResponseDTO<Order> response = new ResponseDTO<Order>(orderRequired);
        response.add(linkTo(methodOn(OrderController.class).rejectOrder(orderRequired.getOrderCode())).withSelfRel());
        return response;
    }    

    @RequestMapping(value = "/order/findByStatus", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ResponseDTO<Order>> findOrderByStatus(@RequestParam OrderRequestStatus status) {
        List<Order> orderRequired = orderRepository.findByStatus(status);
        
        List<ResponseDTO<Order>> responseArray = new ArrayList<ResponseDTO<Order>>();
           
        for (Order order : orderRequired) {
        	ResponseDTO<Order> response = new ResponseDTO<Order>(order);
        	Link selfLink = linkTo(methodOn(OrderController.class).getOrderById(order.getId())).withSelfRel();
        	response.add(selfLink);
            responseArray.add(response);
        }
        
        return responseArray;
    }    
        
    
}
