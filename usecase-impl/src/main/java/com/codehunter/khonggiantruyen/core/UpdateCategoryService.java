package com.codehunter.khonggiantruyen.core;

import com.codehunter.khonggiantruyen.UseCase;
import com.codehunter.khonggiantruyen.core.exception.EntityNotFoundException;
import com.codehunter.khonggiantruyen.core.port.in.IUpdateCategoryUseCase;
import com.codehunter.khonggiantruyen.core.port.out.IHasCategoryPort;
import com.codehunter.khonggiantruyen.core.port.out.IUpdateCategoryPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@UseCase
@RequiredArgsConstructor
@Slf4j
public class UpdateCategoryService implements IUpdateCategoryUseCase {
    private final IUpdateCategoryPort updateCategoryPort;
    private final IHasCategoryPort hasCategoryPort;

    @Override
    public UpdateCategoryDataOut updateCategory(UpdateCategoryDataIn dataIn) throws EntityNotFoundException {
        log.info("Update category {}", dataIn);
        if (hasCategoryPort.hasCategoryWithId(dataIn.getCategory().getId())) {
            return updateCategoryPort.updateCategory(dataIn);
        }
        throw new EntityNotFoundException("Category not found");
    }
}
