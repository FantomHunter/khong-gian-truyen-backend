package com.codehunter.khonggiantruyen.adapter.web.controller;

import com.codehunter.khonggiantruyen.WebAdapter;
import com.codehunter.khonggiantruyen.adapter.web.api.updatecategory.IUpdateCategoryApi;
import com.codehunter.khonggiantruyen.adapter.web.api.updatecategory.UpdateCategoryRequest;
import com.codehunter.khonggiantruyen.adapter.web.api.updatecategory.UpdateCategoryResponse;
import com.codehunter.khonggiantruyen.adapter.web.mapper.CategoryApiMapper;
import com.codehunter.khonggiantruyen.core.exception.EntityNotFoundException;
import com.codehunter.khonggiantruyen.core.port.in.IUpdateCategoryUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@WebAdapter
@RestController
@Slf4j
@RequiredArgsConstructor
public class UpdateCategoryController implements IUpdateCategoryApi {
    private final IUpdateCategoryUseCase updateCategoryUseCase;
    private final CategoryApiMapper categoryApiMapper;

    @Override
    public UpdateCategoryResponse updateCategory(UpdateCategoryRequest in) {
        log.info("Update category: {}", in);
        try {
            IUpdateCategoryUseCase.UpdateCategoryDataOut out = updateCategoryUseCase.updateCategory(
                    new IUpdateCategoryUseCase.UpdateCategoryDataIn(
                            categoryApiMapper.mapToCategory(in.getCategory())));
            return new UpdateCategoryResponse(categoryApiMapper.mapToCategoryDto(
                    out.getCategory()
            ));
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Category not found");
        }
    }
}
