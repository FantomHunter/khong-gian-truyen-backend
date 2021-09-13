package com.codehunter.khonggiantruyen.adapter.web.api.updatecategory;

import com.codehunter.khonggiantruyen.adapter.web.api.common.CategoryDto;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateCategoryRequest {
    private CategoryDto category;
}
