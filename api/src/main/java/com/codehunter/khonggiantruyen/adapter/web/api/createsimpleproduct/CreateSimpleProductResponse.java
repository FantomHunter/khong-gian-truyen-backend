package com.codehunter.khonggiantruyen.adapter.web.api.createsimpleproduct;

import com.codehunter.khonggiantruyen.adapter.web.api.common.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateSimpleProductResponse {
    private ProductDto product;
}
