package com.codehunter.khonggiantruyen.adapter.web.api.common;

import lombok.*;

@Data
@AllArgsConstructor
@Builder
public class CategoryDto {
    @NonNull
    private final Long id;
    private final String name;
}
