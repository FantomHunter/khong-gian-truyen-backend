package com.codehunter.khonggiantruyen.adapter.web.mapper;

import com.codehunter.khonggiantruyen.adapter.web.api.common.EProductStatus;
import com.codehunter.khonggiantruyen.adapter.web.api.common.EProductType;
import com.codehunter.khonggiantruyen.adapter.web.api.common.ProductDto;
import com.codehunter.khonggiantruyen.domain.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductApiMapper {
    public ProductDto mapToProductDto(Product product) {
        return new ProductDto(
                product.getId().getValue(),
                product.getDescription(),
                product.getImageUrl(),
                product.getName(),
                product.getPublishDate(),
                EProductStatus.valueOf(product.getStatus().toString()),
                product.getTotalChapter(),
                EProductType.valueOf(product.getType().toString())
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
                com.codehunter.khonggiantruyen.domain.EProductType.valueOf(productDto.getType().toString())
        );
    }
}
