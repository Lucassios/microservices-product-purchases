package com.productpurchases.wholesaler.repository;

import com.productpurchases.wholesaler.entity.Order;
import com.productpurchases.wholesaler.entity.Order.OrderRequestStatus;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by lucascmarques on 04/06/17.
 */
@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

    Order findByOrderCode(String orderCode);
    Order findById(Long orderId);
    List<Order> findByStatus(OrderRequestStatus status);
	
}
