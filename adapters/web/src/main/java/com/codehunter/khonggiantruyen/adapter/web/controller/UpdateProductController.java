package com.codehunter.khonggiantruyen.adapter.web.controller;

import com.codehunter.khonggiantruyen.WebAdapter;
import com.codehunter.khonggiantruyen.adapter.web.api.updateproduct.IUpdateProductApi;
import com.codehunter.khonggiantruyen.adapter.web.api.updateproduct.UpdateProductRequest;
import com.codehunter.khonggiantruyen.adapter.web.api.updateproduct.UpdateProductResponse;
import com.codehunter.khonggiantruyen.adapter.web.mapper.ProductApiMapper;
import com.codehunter.khonggiantruyen.core.exception.EntityNotFoundException;
import com.codehunter.khonggiantruyen.core.port.in.IUpdateProductUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

/**
 * @author codehunter
 */
@WebAdapter
@RestController
@RequiredArgsConstructor
@Log4j2
public class UpdateProductController implements IUpdateProductApi {
    private final IUpdateProductUseCase updateProductUseCase;
    private final ProductApiMapper productApiMapper;

    @Override
    public UpdateProductResponse updateProduct(UpdateProductRequest in) {
        log.info("UpdateProduct: " + in);
        try {
            IUpdateProductUseCase.UpdateProductDataOut out = updateProductUseCase.updateProduct(new IUpdateProductUseCase.UpdateProductDataIn(productApiMapper.mapToProduct(in.getProduct())));
            return new UpdateProductResponse(productApiMapper.mapToProductDto(out.getProduct()));
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product not found");
        }
    }
}
