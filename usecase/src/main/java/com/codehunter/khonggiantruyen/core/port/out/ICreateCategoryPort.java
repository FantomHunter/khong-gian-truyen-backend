package com.codehunter.khonggiantruyen.core.port.out;

import com.codehunter.khonggiantruyen.core.port.in.ICreateCategoryUseCase;

public interface ICreateCategoryPort {
    ICreateCategoryUseCase.CreateCategoryDataOut createCategory(ICreateCategoryUseCase.CreateCategoryDataIn dataIn);
}
