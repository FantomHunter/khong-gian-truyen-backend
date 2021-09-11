package com.codehunter.khonggiantruyen.core;

import com.codehunter.khonggiantruyen.UseCase;
import com.codehunter.khonggiantruyen.core.port.in.ICreateCategoryUseCase;
import com.codehunter.khonggiantruyen.core.port.out.ICreateCategoryPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@UseCase
@AllArgsConstructor
@Slf4j
public class CreateCategoryService implements ICreateCategoryUseCase {
    private final ICreateCategoryPort createCategoryPort;


    @Override
    public CreateCategoryDataOut createCategory(CreateCategoryDataIn dataIn) {
        log.info("create new category {}", dataIn);
        return createCategoryPort.createCategory(dataIn);
    }
}
