package com.codehunter.khonggiantruyen.adapter.web.api.addauthortoproduct;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AddAuthorToProductRequest {
    @NonNull
    private Long productId;
    @NonNull
    private Long authorId;
}
