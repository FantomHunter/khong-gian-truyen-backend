package com.codehunter.khonggiantruyen.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class User {
    @Getter
    private final String id;
    @Getter
    private final String name;
}
