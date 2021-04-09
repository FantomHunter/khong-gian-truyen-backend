package com.codehunter.khonggiantruyen.core;

import com.codehunter.khonggiantruyen.UseCase;
import com.codehunter.khonggiantruyen.core.port.in.IGetAllProductUseCase;
import com.codehunter.khonggiantruyen.core.port.out.IGetAllProductPort;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
public class GetAllProductService implements IGetAllProductUseCase {
    private final IGetAllProductPort getAllProductPort;

    @Override
    public GetAllProductDataOut getAllProduct(GetAllProductDataIn in) {
        return getAllProductPort.getAllProduct(in);
    }
}
