package com.codehunter.khonggiantruyen.adapter.web.controller;

import com.codehunter.khonggiantruyen.WebAdapter;
import com.codehunter.khonggiantruyen.adapter.web.api.common.CategoryDto;
import com.codehunter.khonggiantruyen.adapter.web.api.createcategory.CreateCategoryRequest;
import com.codehunter.khonggiantruyen.adapter.web.api.createcategory.CreateCategoryResponse;
import com.codehunter.khonggiantruyen.adapter.web.api.createcategory.ICreateCategoryApi;
import com.codehunter.khonggiantruyen.adapter.web.mapper.CategoryApiMapper;
import com.codehunter.khonggiantruyen.core.port.in.ICreateCategoryUseCase;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@Slf4j
@AllArgsConstructor
public class CreateCategoryController implements ICreateCategoryApi {
    private final ICreateCategoryUseCase createCategoryUseCase;
    private final CategoryApiMapper categoryApiMapper;
    @Override
    public CreateCategoryResponse createCategory(CreateCategoryRequest request) {
        log.info("Create new category");
        ICreateCategoryUseCase.CreateCategoryDataOut category = createCategoryUseCase.createCategory(
                new ICreateCategoryUseCase.CreateCategoryDataIn(request.getName()));

        return new CreateCategoryResponse(mapToCategoryDto(category));
    }

    private CategoryDto mapToCategoryDto(ICreateCategoryUseCase.CreateCategoryDataOut category) {
        return categoryApiMapper.mapToCategoryDto(category.getCategory());
    }
}
