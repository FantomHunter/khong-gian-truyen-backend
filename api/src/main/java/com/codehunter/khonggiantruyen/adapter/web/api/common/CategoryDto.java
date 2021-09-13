package com.codehunter.khonggiantruyen.adapter.web.api.common;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDto {
    @NonNull
    private Long id;
    private String name;
}
