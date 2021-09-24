package com.codehunter.khonggiantruyen.core.port.out;

import com.codehunter.khonggiantruyen.core.exception.EntityNotFoundException;
import com.codehunter.khonggiantruyen.core.port.in.IAddAuthorToProductUseCase;

public interface IAddAuthorToProductPort {
    void addAuthorToProductPort(IAddAuthorToProductUseCase.AddAuthorToProductDataIn dataIn) throws EntityNotFoundException;
}
