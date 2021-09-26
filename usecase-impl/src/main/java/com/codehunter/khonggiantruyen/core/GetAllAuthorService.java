package com.codehunter.khonggiantruyen.core;

import com.codehunter.khonggiantruyen.UseCase;
import com.codehunter.khonggiantruyen.core.port.in.IGetAllAuthorUseCase;
import com.codehunter.khonggiantruyen.core.port.out.IGetAllAuthorPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.transaction.Transactional;

@UseCase
@Transactional
@RequiredArgsConstructor
@Slf4j
public class GetAllAuthorService implements IGetAllAuthorUseCase {
    private final IGetAllAuthorPort getAllAuthorPort;

    @Override
    public GetAllAuthorDataOut getAllAuthor(GetAllAuthorDataIn dataIn) {
        log.info("getAllAuthor: {}", dataIn);
        return getAllAuthorPort.getAllAuthor(dataIn);
    }
}
