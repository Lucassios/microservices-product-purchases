package com.productpurchases.wholesaler.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.hateoas.ResourceSupport;

/**
 * Created by lucascmarques on 04/06/17.
 */
@Data
@AllArgsConstructor
public class ResponseDTO<T> extends ResourceSupport {

    private T content;

}