package com.codehunter.khonggiantruyen.domain;

import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class Product {
    private final ProductId id;
    private final String description;
    private final String imageUrl;
    private final String name;
    private final Date publishDate;
    private final EProductStatus status;
    private final Integer totalChapter;
    private final EProductType type;
    private final List<Category> categoryList;
    private final Author author;

    @Value
    public static class ProductId {
        Long value;
    }
}
