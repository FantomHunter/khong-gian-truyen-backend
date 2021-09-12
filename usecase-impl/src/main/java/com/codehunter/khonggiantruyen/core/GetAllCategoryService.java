package com.codehunter.khonggiantruyen.core;

import com.codehunter.khonggiantruyen.UseCase;
import com.codehunter.khonggiantruyen.core.port.in.IGetAllCategoryUseCase;
import com.codehunter.khonggiantruyen.core.port.out.IGetAllCategoryPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.transaction.Transactional;

@UseCase
@Transactional
@Slf4j
@AllArgsConstructor
public class GetAllCategoryService implements IGetAllCategoryUseCase {
    private final IGetAllCategoryPort getAllCategoryPort;

    @Override
    public GetAllCategoryDataOut getAllCategory() {
        log.info("Get all category");
        return getAllCategoryPort.getAllCategory();
    }
}
