package com.codehunter.khonggiantruyen.adapter.web.controller;

import com.codehunter.khonggiantruyen.WebAdapter;
import com.codehunter.khonggiantruyen.adapter.web.api.createsimpleproduct.CreateSimpleProductRequest;
import com.codehunter.khonggiantruyen.adapter.web.api.createsimpleproduct.CreateSimpleProductResponse;
import com.codehunter.khonggiantruyen.adapter.web.api.createsimpleproduct.ICreateSimpleProductApi;
import com.codehunter.khonggiantruyen.adapter.web.mapper.ProductApiMapper;
import com.codehunter.khonggiantruyen.core.port.in.ICreateSimpleProductUseCase;
import com.codehunter.khonggiantruyen.domain.EProductStatus;
import com.codehunter.khonggiantruyen.domain.EProductType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
@Slf4j
public class CreateSimpleProductController implements ICreateSimpleProductApi {
    private final ICreateSimpleProductUseCase createSimpleProductUseCase;
    private final ProductApiMapper productApiMapper;


    @Override
    public CreateSimpleProductResponse createSimpleProduct(CreateSimpleProductRequest request) {
        ICreateSimpleProductUseCase.CreateSimpleProductDataIn dataIn = new ICreateSimpleProductUseCase.CreateSimpleProductDataIn(
                request.getDescription(),
                request.getImageUrl(),
                request.getName(),
                request.getPublishDate(),
                EProductStatus.valueOf(request.getStatus().toString()),
                request.getTotalChapter(),
                EProductType.valueOf(request.getType().toString())
        );
        ICreateSimpleProductUseCase.CreateSimpleProductDataOut dataOut = createSimpleProductUseCase.createSimpleProduct(dataIn);

        return new CreateSimpleProductResponse(productApiMapper.mapToProductDto(dataOut.getProduct()));
    }
}
