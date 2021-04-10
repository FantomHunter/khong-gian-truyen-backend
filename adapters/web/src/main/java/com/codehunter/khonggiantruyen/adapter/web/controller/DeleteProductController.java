package com.codehunter.khonggiantruyen.adapter.web.controller;

import com.codehunter.khonggiantruyen.WebAdapter;
import com.codehunter.khonggiantruyen.adapter.web.api.deleteproduct.DeleteProductResponse;
import com.codehunter.khonggiantruyen.adapter.web.api.deleteproduct.IDeleteProductApi;
import com.codehunter.khonggiantruyen.core.exception.EntityNotFoundException;
import com.codehunter.khonggiantruyen.core.port.in.IDeleteProductUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@WebAdapter
@RestController
@RequiredArgsConstructor
@Slf4j
public class DeleteProductController implements IDeleteProductApi {
    private static final String DELETE_PRODUCT_SUCCESS = "Product with id %d deleted successfully";
    private static final String DELETE_PRODUCT_FAIL = "Product not exist";
    private final IDeleteProductUseCase deleteProductUseCase;

    @Override
    public DeleteProductResponse deleteProduct(Long id) {
        try {
            deleteProductUseCase.deleteProduct(new IDeleteProductUseCase.DeleteProductDataIn(id));
            return new DeleteProductResponse(String.format(DELETE_PRODUCT_SUCCESS, id));
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, DELETE_PRODUCT_FAIL);
        }
    }
}
