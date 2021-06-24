package com.codehunter.khonggiantruyen.core;

import com.codehunter.khonggiantruyen.UseCase;
import com.codehunter.khonggiantruyen.core.exception.EntityNotFoundException;
import com.codehunter.khonggiantruyen.core.port.in.IUpdateProductUseCase;
import com.codehunter.khonggiantruyen.core.port.out.IHasProductPort;
import com.codehunter.khonggiantruyen.core.port.out.IUpdateProductPort;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;

/**
 * @author codehunter
 */

@UseCase
@RequiredArgsConstructor
@Transactional
public class UpdateProductService implements IUpdateProductUseCase {
    private final IUpdateProductPort updateProductPort;
    private final IHasProductPort hasProductPort;

    @Override
    public UpdateProductDataOut updateProduct(UpdateProductDataIn in) throws EntityNotFoundException {
        if (hasProductPort.hasProductWithId(in.getProduct().getId().getValue())) {
            return updateProductPort.updateProduct(in);
        }
        throw new EntityNotFoundException("Product not found, id: " + in.getProduct().getId().getValue());
    }
}
