package com.codehunter.khonggiantruyen.adapter.web.controller;

import com.codehunter.khonggiantruyen.WebAdapter;
import com.codehunter.khonggiantruyen.adapter.web.api.deletecategory.DeleteCategoryResponse;
import com.codehunter.khonggiantruyen.adapter.web.api.deletecategory.IDeleteCategoryApi;
import com.codehunter.khonggiantruyen.core.exception.EntityNotFoundException;
import com.codehunter.khonggiantruyen.core.port.in.IDeleteCategoryUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@WebAdapter
@RestController
@RequiredArgsConstructor
@Slf4j
public class DeleteCategoryController implements IDeleteCategoryApi {
    private static final String DELETE_CATEGORY_SUCCESS = "Category with id %d deleted successfully";
    private static final String DELETE_CATEGORY_FAIL = "Category not exist";
    private final IDeleteCategoryUseCase deleteCategoryUseCase;

    @Override
    public DeleteCategoryResponse deleteCategory(Long id) {
        log.info("Delete category");
        try {
            deleteCategoryUseCase.deleteCategory(new IDeleteCategoryUseCase.DeleteCategoryDataIn(id));
            return new DeleteCategoryResponse(String.format(DELETE_CATEGORY_SUCCESS, id));
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, DELETE_CATEGORY_FAIL);
        }
    }
}
