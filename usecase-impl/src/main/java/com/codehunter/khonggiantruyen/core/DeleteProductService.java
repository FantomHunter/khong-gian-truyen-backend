package com.codehunter.khonggiantruyen.core;

import com.codehunter.khonggiantruyen.UseCase;
import com.codehunter.khonggiantruyen.core.port.in.IDeleteProductUseCase;
import com.codehunter.khonggiantruyen.core.port.out.IDeleteProductPort;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
public class DeleteProductService implements IDeleteProductUseCase {
    private final IDeleteProductPort deleteProductPort;
    @Override
    public void deleteProduct(DeleteProductDataIn in) {
        deleteProductPort.deleteProduct(in);
    }
}
