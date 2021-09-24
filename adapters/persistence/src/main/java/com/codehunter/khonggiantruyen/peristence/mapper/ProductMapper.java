package com.codehunter.khonggiantruyen.peristence.mapper;

import com.codehunter.khonggiantruyen.core.port.in.ICreateSimpleProductUseCase;
import com.codehunter.khonggiantruyen.domain.Author;
import com.codehunter.khonggiantruyen.domain.Product;
import com.codehunter.khonggiantruyen.peristence.entity.ProductDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProductMapper {
    private final CategoryMaper categoryMaper;

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

    public ICreateSimpleProductUseCase.CreateSimpleProductDataOut mapToCreateSimpleProductDataOut(ProductDao productDao) {
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
                productDao.getType(),
                productDao.getCategoryList()
                        .stream()
                        .map(categoryMaper::mapToCategory)
                        .collect(Collectors.toList()),
                Optional.ofNullable(productDao.getAuthor())
                        .map(authorDao -> new Author(authorDao.getId(), authorDao.getName()))
                        .orElse(null)
        );
    }

    public ProductDao mapToProductDao(Product product) {
        return new ProductDao(
                product.getId().getValue(),
                product.getName(),
                product.getDescription(),
                product.getImageUrl(),
                new Timestamp(product.getPublishDate().getTime()).toLocalDateTime(),
                product.getTotalChapter(),
                product.getStatus(),
                product.getType(),
                null,
                Collections.EMPTY_LIST,
                Collections.EMPTY_LIST,
                Collections.EMPTY_LIST,
                Collections.EMPTY_LIST,
                Collections.EMPTY_LIST
        );
    }

    public ProductDao mapToProductDaoWithTarget(Product product, ProductDao productDao) {
        return new ProductDao(
                product.getId().getValue() != null ? product.getId().getValue() : productDao.getId(),
                product.getName() != null ? product.getName() : productDao.getName(),
                product.getDescription() != null ? product.getDescription() : productDao.getDescription(),
                product.getImageUrl() != null ? product.getImageUrl() : productDao.getImageUrl(),
                product.getPublishDate() != null ? new Timestamp(product.getPublishDate().getTime()).toLocalDateTime() : productDao.getPublishDate(),
                product.getTotalChapter() != null ? product.getTotalChapter() : productDao.getTotalChapter(),
                product.getStatus() != null ? product.getStatus() : productDao.getStatus(),
                product.getType() != null ? product.getType() : productDao.getType(),
                productDao.getAuthor(),
                productDao.getCategoryList(),
                productDao.getResourceDownloadList(),
                productDao.getLikedList(),
                productDao.getCommentedList(),
                productDao.getRatingList()
        );
    }
}
