package com.codehunter.khonggiantruyen.adapter.web.api.common;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {
    @NotEmpty
    private Long id;
    private String description;
    @NotEmpty
    private String imageUrl;
    @NotEmpty
    private String name;
    private Date publishDate;
    private EProductStatus status;
    private Integer totalChapter;
    private EProductType type;
    private List<CategoryDto> categoryList;
    private AuthorDto author;
}
