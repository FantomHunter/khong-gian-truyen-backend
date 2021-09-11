package com.codehunter.khonggiantruyen.domain;


import lombok.*;

@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class Category {
    @Getter
    private final Long id;
    @Getter
    private final String name;
}
