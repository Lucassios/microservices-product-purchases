package com.productpurchases.shopkeeper.repository;

import com.productpurchases.shopkeeper.entity.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by lucascmarques on 04/06/17.
 */
@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

}
