package com.codehunter.khonggiantruyen.core;

import com.codehunter.khonggiantruyen.UseCase;
import com.codehunter.khonggiantruyen.core.port.in.ICreateAuthorUseCase;
import com.codehunter.khonggiantruyen.core.port.out.ICreateAuthorPort;
import com.codehunter.khonggiantruyen.core.port.out.IHasAuthorPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.transaction.Transactional;

@UseCase
@Transactional
@RequiredArgsConstructor
@Slf4j
public class CreateAuthorService implements ICreateAuthorUseCase {
    private final ICreateAuthorPort createAuthorPort;

    @Override
    public CreateAuthorDataOut createAuthor(CreateAuthorDataIn dataIn) {
        log.info("createAuthor: {}", dataIn);
        return createAuthorPort.createAuthor(dataIn);
    }
}
