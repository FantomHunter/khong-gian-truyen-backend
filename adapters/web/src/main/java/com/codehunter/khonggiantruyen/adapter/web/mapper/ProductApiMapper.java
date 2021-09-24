package com.codehunter.khonggiantruyen.adapter.web.mapper;

import com.codehunter.khonggiantruyen.adapter.web.api.common.AuthorDto;
import com.codehunter.khonggiantruyen.adapter.web.api.common.EProductStatus;
import com.codehunter.khonggiantruyen.adapter.web.api.common.EProductType;
import com.codehunter.khonggiantruyen.adapter.web.api.common.ProductDto;
import com.codehunter.khonggiantruyen.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
public class ProductApiMapper {
    private final CategoryApiMapper categoryApiMapper;

    public ProductDto mapToProductDto(Product product) {
        return new ProductDto(
                product.getId().getValue(),
                product.getDescription(),
                product.getImageUrl(),
                product.getName(),
                product.getPublishDate(),
                EProductStatus.valueOf(product.getStatus().toString()),
                product.getTotalChapter(),
                EProductType.valueOf(product.getType().toString()),
                Optional.ofNullable(product.getCategoryList())
                        .map(Collection::stream)
                        .orElseGet(Stream::empty)
                        .filter(Objects::nonNull)
                        .map(categoryApiMapper::mapToCategoryDto)
                        .collect(Collectors.toList()),
                Optional.ofNullable(product.getAuthor())
                        .map(author -> AuthorDto.builder()
                                .id(author.getId())
                                .name(author.getName())
                                .build())
                        .orElse(null)

        );
    }

    public List<ProductDto> mapToProductDtoList(List<Product> productList) {
        return productList.stream()
                .map(this::mapToProductDto)
                .collect(Collectors.toList());
    }

    public Product mapToProduct(ProductDto productDto) {
        return new Product(
                new Product.ProductId(productDto.getId()),
                productDto.getDescription(),
                productDto.getImageUrl(),
                productDto.getName(),
                productDto.getPublishDate(),
                com.codehunter.khonggiantruyen.domain.EProductStatus.valueOf(productDto.getStatus().toString()),
                productDto.getTotalChapter(),
                com.codehunter.khonggiantruyen.domain.EProductType.valueOf(productDto.getType().toString()),
                null,
                null
        );
    }
}
