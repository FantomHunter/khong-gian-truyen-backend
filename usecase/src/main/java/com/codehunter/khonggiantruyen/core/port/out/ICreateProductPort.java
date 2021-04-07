package com.codehunter.khonggiantruyen.core.port.out;

import com.codehunter.khonggiantruyen.core.port.in.ICreateSimpleProductUseCase;

public interface ICreateProductPort {
    ICreateSimpleProductUseCase.CreateSimpleProductDataOut createSimpleProduct(ICreateSimpleProductUseCase.CreateSimpleProductDataIn in);
}
