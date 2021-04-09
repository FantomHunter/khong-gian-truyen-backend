package com.codehunter.khonggiantruyen.peristence.mapper;

import com.codehunter.khonggiantruyen.core.port.in.ICreateSimpleProductUseCase;
import com.codehunter.khonggiantruyen.domain.Product;
import com.codehunter.khonggiantruyen.peristence.entity.ProductDao;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Collections;

@Component
public class ProductMapper {
    public ProductDao mapToProductDao(ICreateSimpleProductUseCase.CreateSimpleProductDataIn dataIn) {
        return new ProductDao(
                null,
                dataIn.getName(),
                dataIn.getDescription(),
                dataIn.getImageUrl(),
                new Timestamp(dataIn.getPublishDate().getTime()).toLocalDateTime(),
                dataIn.getTotalChapter(),
                dataIn.getStatus(),
                dataIn.getType(),
                null,
                Collections.EMPTY_LIST,
                Collections.EMPTY_LIST,
                Collections.EMPTY_LIST,
                Collections.EMPTY_LIST,
                Collections.EMPTY_LIST
        );
    }

    public ICreateSimpleProductUseCase.CreateSimpleProductDataOut maptoCreateSimpleProductDataOut(ProductDao productDao) {
        return new ICreateSimpleProductUseCase.CreateSimpleProductDataOut(mapToProduct(productDao));
    }

    public Product mapToProduct(ProductDao productDao) {
        return new Product(
                new Product.ProductId(productDao.getId()),
                productDao.getDescription(),
                productDao.getImageUrl(),
                productDao.getName(),
                Timestamp.valueOf(productDao.getPublishDate()),
                productDao.getStatus(),
                productDao.getTotalChapter(),
                productDao.getType()
        );
    }


}
