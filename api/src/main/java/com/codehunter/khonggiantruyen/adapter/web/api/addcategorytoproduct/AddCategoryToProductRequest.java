package com.codehunter.khonggiantruyen.adapter.web.api.addcategorytoproduct;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddCategoryToProductRequest {
    private Long productId;
    private Long categoryId;
}
