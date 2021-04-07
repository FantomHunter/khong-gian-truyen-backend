package com.codehunter.khonggiantruyen.peristence;

import com.codehunter.khonggiantruyen.PersistenceAdapter;
import com.codehunter.khonggiantruyen.core.port.in.ICreateSimpleProductUseCase;
import com.codehunter.khonggiantruyen.core.port.out.ICreateProductPort;
import com.codehunter.khonggiantruyen.peristence.entity.ProductDao;
import com.codehunter.khonggiantruyen.peristence.mapper.ProductMapper;
import com.codehunter.khonggiantruyen.peristence.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@PersistenceAdapter
@Slf4j
public class ProductPersistenceAdapter implements ICreateProductPort {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ICreateSimpleProductUseCase.CreateSimpleProductDataOut createSimpleProduct(ICreateSimpleProductUseCase.CreateSimpleProductDataIn in) {
        ProductDao productDao = productRepository.save(productMapper.mapToProductDao(in));
        return productMapper.maptoCreateSimpleProductDataOut(productDao);
    }
}
