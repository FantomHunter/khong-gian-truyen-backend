package com.codehunter.khonggiantruyen.adapter.web.api.updateproduct;

import com.codehunter.khonggiantruyen.adapter.web.api.common.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author codehunter
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductRequest {
    private ProductDto product;
}