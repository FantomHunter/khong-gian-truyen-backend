package com.codehunter.khonggiantruyen.core.port.out;

import com.codehunter.khonggiantruyen.core.port.in.IGetAllAuthorUseCase;

public interface IGetAllAuthorPort {
    IGetAllAuthorUseCase.GetAllAuthorDataOut getAllAuthor(IGetAllAuthorUseCase.GetAllAuthorDataIn dataIn);
}
