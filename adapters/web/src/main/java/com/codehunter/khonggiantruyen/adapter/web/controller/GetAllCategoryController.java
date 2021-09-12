package com.codehunter.khonggiantruyen.adapter.web.controller;

import com.codehunter.khonggiantruyen.WebAdapter;
import com.codehunter.khonggiantruyen.adapter.web.api.common.CategoryDto;
import com.codehunter.khonggiantruyen.adapter.web.api.getallcategory.GetAllCategoryResponse;
import com.codehunter.khonggiantruyen.adapter.web.api.getallcategory.IGetAllCategoryApi;
import com.codehunter.khonggiantruyen.adapter.web.mapper.CategoryApiMapper;
import com.codehunter.khonggiantruyen.core.port.in.IGetAllCategoryUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@WebAdapter
@RestController
@Slf4j
@RequiredArgsConstructor
public class GetAllCategoryController implements IGetAllCategoryApi {
    private final IGetAllCategoryUseCase getAllCategoryUseCase;
    private final CategoryApiMapper categoryApiMapper;

    @Override
    public GetAllCategoryResponse getAllCategory() {
        log.info("Get all category");
        List<CategoryDto> categoryDtoList = getAllCategoryUseCase.getAllCategory()
                .getCategories()
                .stream()
                .map(categoryApiMapper::mapToCategoryDto)
                .collect(toList());
        return new GetAllCategoryResponse(categoryDtoList);
    }
}
