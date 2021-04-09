package com.codehunter.khonggiantruyen.core.port.out;

import com.codehunter.khonggiantruyen.core.port.in.IGetAllProductUseCase;

public interface IGetAllProductPort {
    IGetAllProductUseCase.GetAllProductDataOut getAllProduct(IGetAllProductUseCase.GetAllProductDataIn in);
}
