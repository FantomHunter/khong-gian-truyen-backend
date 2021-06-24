package com.codehunter.khonggiantruyen.core.port.out;

import com.codehunter.khonggiantruyen.core.exception.EntityNotFoundException;
import com.codehunter.khonggiantruyen.core.port.in.IUpdateProductUseCase;

/**
 * @author codehunter
 */
public interface IUpdateProductPort {
    IUpdateProductUseCase.UpdateProductDataOut updateProduct(IUpdateProductUseCase.UpdateProductDataIn in) throws EntityNotFoundException;
}
