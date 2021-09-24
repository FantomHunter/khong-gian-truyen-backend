package com.codehunter.khonggiantruyen.domain;

import lombok.*;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Builder
public class Author {
    private final Long id;
    private final String name;
}
