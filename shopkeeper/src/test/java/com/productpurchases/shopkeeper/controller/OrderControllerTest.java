package com.productpurchases.shopkeeper.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

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
//        ProductOrder order = new OrderBuilder().productId(1L).quantity(new BigDecimal(10)).build();
//        ResponseEntity<ResponseDTO<ProductOrder>> responseEntity = this.restTemplate.exchange(
//                "/order",
//                HttpMethod.POST,
//                new HttpEntity<>(order),
//                new ParameterizedTypeReference<ResponseDTO<ProductOrder>>() {});
//        ResponseDTO responseDTO = responseEntity.getBody();
//        ProductOrder orderResponse = (ProductOrder) responseDTO.getContent();
//        assertThat(responseEntity.getStatusCode(), is(equalTo(HttpStatus.OK)));
//        assertThat(orderResponse.getProductId(), is(equalTo(order.getProductId())));
//        assertThat(orderResponse.getQuantity(), is(equalTo(order.getQuantity())));
//        assertThat(orderResponse.getId(), is(greaterThan(0L)));
    }

}
