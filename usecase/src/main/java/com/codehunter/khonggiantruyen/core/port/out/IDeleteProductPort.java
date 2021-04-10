package com.codehunter.khonggiantruyen.core.port.out;

import com.codehunter.khonggiantruyen.core.port.in.IDeleteProductUseCase;

public interface IDeleteProductPort {
    void deleteProduct(IDeleteProductUseCase.DeleteProductDataIn in);
}
