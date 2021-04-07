package com.codehunter.khonggiantruyen.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@EqualsAndHashCode
public class Rating {
    @Getter
    private final Long id;
    @Getter
    private final Integer value;

}
