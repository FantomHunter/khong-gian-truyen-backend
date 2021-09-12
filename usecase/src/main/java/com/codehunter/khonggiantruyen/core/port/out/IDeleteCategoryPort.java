package com.codehunter.khonggiantruyen.core.port.out;

import com.codehunter.khonggiantruyen.core.port.in.IDeleteCategoryUseCase;

public interface IDeleteCategoryPort {
    void deleteCategory(IDeleteCategoryUseCase.DeleteCategoryDataIn dataIn);
}
