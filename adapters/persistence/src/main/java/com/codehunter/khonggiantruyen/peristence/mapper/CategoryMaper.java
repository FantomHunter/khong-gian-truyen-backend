package com.codehunter.khonggiantruyen.peristence.mapper;

import com.codehunter.khonggiantruyen.domain.Category;
import com.codehunter.khonggiantruyen.peristence.entity.CategoryDao;
import org.springframework.stereotype.Component;

@Component
public class CategoryMaper {
    public Category mapToCategory(CategoryDao categoryDao) {
        return Category.builder()
                .id(categoryDao.getId())
                .name(categoryDao.getName())
                .build();
    }
}
