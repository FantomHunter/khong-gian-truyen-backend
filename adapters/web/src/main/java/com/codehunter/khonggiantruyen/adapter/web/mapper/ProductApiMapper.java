package com.codehunter.khonggiantruyen.adapter.web.mapper;

import com.codehunter.khonggiantruyen.adapter.web.api.common.EProductStatus;
import com.codehunter.khonggiantruyen.adapter.web.api.common.EProductType;
import com.codehunter.khonggiantruyen.adapter.web.api.common.ProductDto;
import com.codehunter.khonggiantruyen.domain.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductApiMapper {
    public ProductDto mapToProductDto(Product product) {
        return new ProductDto(
                product.getId().getValue(),
                product.getImageUrl(),
                product.getDescription(),
                product.getName(),
                product.getPublishDate(),
                EProductStatus.valueOf(product.getStatus().toString()),
                product.getTotalChapter(),
                EProductType.valueOf(product.getType().toString())
        );
    }
}
