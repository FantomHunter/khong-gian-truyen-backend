package com.codehunter.khonggiantruyen.adapter.web.controller;

import com.codehunter.khonggiantruyen.WebAdapter;
import com.codehunter.khonggiantruyen.adapter.web.api.addcategorytoproduct.AddCategoryToProductRequest;
import com.codehunter.khonggiantruyen.adapter.web.api.addcategorytoproduct.AddCategoryToProductResponse;
import com.codehunter.khonggiantruyen.adapter.web.api.addcategorytoproduct.IAddCategoryToProductApi;
import com.codehunter.khonggiantruyen.core.exception.EntityNotFoundException;
import com.codehunter.khonggiantruyen.core.port.in.IAddCategoryToProductUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@WebAdapter
@Slf4j
@RequiredArgsConstructor
public class AddCategoryToProductController implements IAddCategoryToProductApi {
    private static final String ADD_CATEGORY_TO_PRODUCT_FAIL = "Cannot add category to product";
    private final IAddCategoryToProductUseCase addCategoryToProductUseCase;

    @Override
    public AddCategoryToProductResponse addCategoryToProduct(AddCategoryToProductRequest request) {
        try {
            addCategoryToProductUseCase.addCategoryToProduct(
                    new IAddCategoryToProductUseCase.AddCategoryToProductDataIn(request.getProductId(), request.getCategoryId()));
            return AddCategoryToProductResponse.builder().message("Success").build();
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ADD_CATEGORY_TO_PRODUCT_FAIL);
        }
    }
}
