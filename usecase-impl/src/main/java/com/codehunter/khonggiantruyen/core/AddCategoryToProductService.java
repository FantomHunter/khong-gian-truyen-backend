package com.codehunter.khonggiantruyen.core;

import com.codehunter.khonggiantruyen.UseCase;
import com.codehunter.khonggiantruyen.core.exception.EntityNotFoundException;
import com.codehunter.khonggiantruyen.core.port.in.IAddCategoryToProductUseCase;
import com.codehunter.khonggiantruyen.core.port.out.IAddCategoryToProductPort;
import com.codehunter.khonggiantruyen.core.port.out.IHasCategoryPort;
import com.codehunter.khonggiantruyen.core.port.out.IHasProductPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.transaction.Transactional;

@UseCase
@Transactional
@RequiredArgsConstructor
@Slf4j
public class AddCategoryToProductService implements IAddCategoryToProductUseCase {
    private final IHasCategoryPort hasCategoryPort;
    private final IHasProductPort hasProductPort;
    private final IAddCategoryToProductPort addCategoryToProductPort;

    @Override
    public void addCategoryToProduct(AddCategoryToProductDataIn dataIn) throws EntityNotFoundException {
        log.info("addCategoryToProduct:  {}", dataIn);
        if (!hasCategoryPort.hasCategoryWithId(dataIn.getCategoryId()))
            throw new EntityNotFoundException("Category not found " + dataIn.getCategoryId());
        if (!hasProductPort.hasProductWithId(dataIn.getProductId()))
            throw new EntityNotFoundException("Product not found " + dataIn.getProductId());
        addCategoryToProductPort.addCategoryToProduct(dataIn);
    }
}
