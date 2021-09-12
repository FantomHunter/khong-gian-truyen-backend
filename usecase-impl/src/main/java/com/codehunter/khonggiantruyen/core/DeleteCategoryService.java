package com.codehunter.khonggiantruyen.core;

import com.codehunter.khonggiantruyen.UseCase;
import com.codehunter.khonggiantruyen.core.exception.EntityNotFoundException;
import com.codehunter.khonggiantruyen.core.port.in.IDeleteCategoryUseCase;
import com.codehunter.khonggiantruyen.core.port.out.IDeleteCategoryPort;
import com.codehunter.khonggiantruyen.core.port.out.IHasCategoryPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.transaction.Transactional;

@UseCase
@Slf4j
@Transactional
@RequiredArgsConstructor
public class DeleteCategoryService implements IDeleteCategoryUseCase {
    private final IDeleteCategoryPort deleteCategoryPort;
    private final IHasCategoryPort hasCategoryPort;
    @Override
    public void deleteCategory(DeleteCategoryDataIn dataIn) throws EntityNotFoundException {
        log.info("Delete category {}", dataIn);
        if (!hasCategoryPort.hasCategoryWithId(dataIn.getId())) {
            throw  new EntityNotFoundException("Category not found");
        }
        deleteCategoryPort.deleteCategory(dataIn);
    }
}
