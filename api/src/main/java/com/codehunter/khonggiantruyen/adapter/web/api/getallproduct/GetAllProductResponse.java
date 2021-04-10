package com.codehunter.khonggiantruyen.adapter.web.api.getallproduct;

import com.codehunter.khonggiantruyen.adapter.web.api.common.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProductResponse {
    private List<ProductDto> productList = new ArrayList<>();
}
