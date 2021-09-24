package com.codehunter.khonggiantruyen.adapter.web.controller;

import com.codehunter.khonggiantruyen.WebAdapter;
import com.codehunter.khonggiantruyen.adapter.web.api.addauthortoproduct.AddAuthorToProductRequest;
import com.codehunter.khonggiantruyen.adapter.web.api.addauthortoproduct.AddAuthorToProductResponse;
import com.codehunter.khonggiantruyen.adapter.web.api.addauthortoproduct.IAddAuthorToProductApi;
import com.codehunter.khonggiantruyen.core.exception.EntityNotFoundException;
import com.codehunter.khonggiantruyen.core.port.in.IAddAuthorToProductUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@WebAdapter
@RestController
@RequiredArgsConstructor
@Slf4j
public class AddAuthorToProductController implements IAddAuthorToProductApi {
    private static final String ADD_AUTHOR_TO_PRODUCT_FAIL = "Cannot add author to product";
    public static final String ADD_AUTHOR_TO_PRODUCT_SUCCESSFUL = "Add author to product successful";
    private final IAddAuthorToProductUseCase addAuthorToProductUseCase;

    @Override
    public AddAuthorToProductResponse addAuthorToProduct(AddAuthorToProductRequest request) {
        log.info("addAuthorToProduct {} ", request);
        try {
            addAuthorToProductUseCase.addAuthorToProduct(
                    new IAddAuthorToProductUseCase.AddAuthorToProductDataIn(request.getProductId(), request.getAuthorId()));
            return AddAuthorToProductResponse.builder().message(ADD_AUTHOR_TO_PRODUCT_SUCCESSFUL).build();
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ADD_AUTHOR_TO_PRODUCT_FAIL);
        }
    }
}
