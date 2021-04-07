package com.codehunter.khonggiantruyen.core;

import com.codehunter.khonggiantruyen.UseCase;
import com.codehunter.khonggiantruyen.core.port.in.ICreateSimpleProductUseCase;
import com.codehunter.khonggiantruyen.core.port.out.ICreateProductPort;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
public class CreateProductService implements ICreateSimpleProductUseCase {
    private final ICreateProductPort createProductPort;

    @Override
    public CreateSimpleProductDataOut createSimpleProduct(CreateSimpleProductDataIn in) {
        return createProductPort.createSimpleProduct(in);
    }
}
