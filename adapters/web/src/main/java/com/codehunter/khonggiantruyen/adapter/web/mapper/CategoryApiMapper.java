package com.codehunter.khonggiantruyen.adapter.web.mapper;

import com.codehunter.khonggiantruyen.adapter.web.api.common.CategoryDto;
import com.codehunter.khonggiantruyen.core.port.in.ICreateCategoryUseCase;
import com.codehunter.khonggiantruyen.domain.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryApiMapper {

    public CategoryDto mapToCategoryDto(Category category) {
        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
}
