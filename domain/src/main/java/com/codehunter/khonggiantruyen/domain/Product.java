package com.codehunter.khonggiantruyen.domain;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@EqualsAndHashCode
public class Product {
    @Getter
    private final ProductId id;
    @Getter
    private final String description;
    @Getter
    private final String imageUrl;
    @Getter
    private final String name;
    @Getter
    private final Date publishDate;
    @Getter
    private final EProductStatus status;
    @Getter
    private final Integer totalChapter;
    @Getter
    private final EProductType type;

    @Value
    public static class ProductId {
        Long value;
    }
}
