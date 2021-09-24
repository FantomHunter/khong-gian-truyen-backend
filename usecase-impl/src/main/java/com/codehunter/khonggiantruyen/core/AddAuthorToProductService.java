package com.codehunter.khonggiantruyen.core;

import com.codehunter.khonggiantruyen.UseCase;
import com.codehunter.khonggiantruyen.core.exception.EntityNotFoundException;
import com.codehunter.khonggiantruyen.core.port.in.IAddAuthorToProductUseCase;
import com.codehunter.khonggiantruyen.core.port.out.IAddAuthorToProductPort;
import com.codehunter.khonggiantruyen.core.port.out.IHasAuthorPort;
import com.codehunter.khonggiantruyen.core.port.out.IHasProductPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.transaction.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AddAuthorToProductService implements IAddAuthorToProductUseCase {
    public static final String AUTHOR_NOT_FOUND = "Author not found";
    public static final String PRODUCT_NOT_FOUND = "Product not found";
    private final IAddAuthorToProductPort addAuthorToProductPort;
    private final IHasProductPort hasProductPort;
    private final IHasAuthorPort hasAuthorPort;

    @Override
    public void addAuthorToProduct(AddAuthorToProductDataIn dataIn) throws EntityNotFoundException {
        log.info("addAuthorToProduct: {}", dataIn);
        if (!hasAuthorPort.hasAuthorWithId(dataIn.getAuthorId())) throw new EntityNotFoundException(AUTHOR_NOT_FOUND);
        if (!hasProductPort.hasProductWithId(dataIn.getProductId()))
            throw new EntityNotFoundException(PRODUCT_NOT_FOUND);
        addAuthorToProductPort.addAuthorToProductPort(dataIn);
    }
}
