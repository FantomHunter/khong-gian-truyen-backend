package com.codehunter.khonggiantruyen.adapter.web.api.common;

import lombok.Value;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Value
public class ProductDto {
    @NotEmpty
    Long id;
    String description;
    @NotEmpty
    String imageUrl;
    @NotEmpty
    String name;
    Date publishDate;
    EProductStatus status;
    Integer totalChapter;
    EProductType type;
}
