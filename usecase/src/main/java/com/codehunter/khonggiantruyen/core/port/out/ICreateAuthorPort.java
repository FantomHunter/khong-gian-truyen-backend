package com.codehunter.khonggiantruyen.core.port.out;

import com.codehunter.khonggiantruyen.core.port.in.ICreateAuthorUseCase;

public interface ICreateAuthorPort {
    ICreateAuthorUseCase.CreateAuthorDataOut createAuthor(ICreateAuthorUseCase.CreateAuthorDataIn dataIn);
}
