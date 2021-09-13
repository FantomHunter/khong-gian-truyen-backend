package com.codehunter.khonggiantruyen.core.port.out;

import com.codehunter.khonggiantruyen.core.exception.EntityNotFoundException;
import com.codehunter.khonggiantruyen.core.port.in.IUpdateCategoryUseCase;

public interface IUpdateCategoryPort {
    IUpdateCategoryUseCase.UpdateCategoryDataOut updateCategory(IUpdateCategoryUseCase.UpdateCategoryDataIn data) throws EntityNotFoundException;
}
