package com.codehunter.khonggiantruyen.core;

import com.codehunter.khonggiantruyen.UseCase;
import com.codehunter.khonggiantruyen.core.exception.EntityNotFoundException;
import com.codehunter.khonggiantruyen.core.port.in.IDeleteProductUseCase;
import com.codehunter.khonggiantruyen.core.port.out.IDeleteProductPort;
import com.codehunter.khonggiantruyen.core.port.out.IHasProductPort;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
public class DeleteProductService implements IDeleteProductUseCase {
    private final IDeleteProductPort deleteProductPort;
    private final IHasProductPort hasProductPort;
    @Override
    public void deleteProduct(DeleteProductDataIn in) throws EntityNotFoundException {
        if (!hasProductPort.hasProductWithId(in.getId())){
            throw new EntityNotFoundException("Product not found");
        }
        deleteProductPort.deleteProduct(in);

    }
}
