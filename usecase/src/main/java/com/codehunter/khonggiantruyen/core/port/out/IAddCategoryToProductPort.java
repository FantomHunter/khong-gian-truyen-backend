package com.codehunter.khonggiantruyen.core.port.out;

import com.codehunter.khonggiantruyen.core.exception.EntityNotFoundException;
import com.codehunter.khonggiantruyen.core.port.in.IAddCategoryToProductUseCase;

public interface IAddCategoryToProductPort {
    void addCategoryToProduct(IAddCategoryToProductUseCase.AddCategoryToProductDataIn dataIn) throws EntityNotFoundException;
}
