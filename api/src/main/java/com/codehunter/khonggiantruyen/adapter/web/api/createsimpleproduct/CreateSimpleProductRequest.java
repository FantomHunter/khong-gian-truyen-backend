package com.codehunter.khonggiantruyen.adapter.web.api.createsimpleproduct;

import com.codehunter.khonggiantruyen.adapter.web.api.common.EProductStatus;
import com.codehunter.khonggiantruyen.adapter.web.api.common.EProductType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateSimpleProductRequest {
    private String description;
    @NotEmpty
    private String imageUrl;
    @NotEmpty
    private String name;
    private Date publishDate;
    private EProductStatus status;
    private Integer totalChapter;
    private EProductType type;
}
