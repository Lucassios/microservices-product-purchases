package com.productpurchases.shopkeeper.controller;

import com.productpurchases.shopkeeper.controller.com.productpurchases.builder.OrderBuilder;
import com.productpurchases.shopkeeper.dto.ResponseDTO;
import com.productpurchases.shopkeeper.entity.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by lucascmarques on 04/06/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrderControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void createOrderSuccess() {
        Order order = new OrderBuilder().productId(1L).quantity(new BigDecimal(10)).build();
        ResponseEntity<ResponseDTO<Order>> responseEntity = this.restTemplate.exchange(
                "/order",
                HttpMethod.POST,
                new HttpEntity<>(order),
                new ParameterizedTypeReference<ResponseDTO<Order>>() {});
        ResponseDTO responseDTO = responseEntity.getBody();
        Order orderResponse = (Order) responseDTO.getContent();
        assertThat(responseEntity.getStatusCode(), is(equalTo(HttpStatus.OK)));
        assertThat(orderResponse.getProductId(), is(equalTo(order.getProductId())));
        assertThat(orderResponse.getQuantity(), is(equalTo(order.getQuantity())));
        assertThat(orderResponse.getId(), is(greaterThan(0L)));
    }

}
