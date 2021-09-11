package com.codehunter.khonggiantruyen.adapter.web.api.createcategory;

import com.codehunter.khonggiantruyen.adapter.web.api.common.CategoryDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCategoryResponse {
    private CategoryDto newCategory;
}
