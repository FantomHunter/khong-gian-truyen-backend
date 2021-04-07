package com.codehunter.khonggiantruyen.core.port.in;

import com.codehunter.khonggiantruyen.SelfValidating;
import com.codehunter.khonggiantruyen.domain.EProductStatus;
import com.codehunter.khonggiantruyen.domain.EProductType;
import com.codehunter.khonggiantruyen.domain.Product;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;

import java.util.Date;

public interface ICreateSimpleProductUseCase {
    CreateSimpleProductDataOut createSimpleProduct(CreateSimpleProductDataIn in);

    @Value
    @EqualsAndHashCode(callSuper = false)
    class CreateSimpleProductDataIn extends SelfValidating<CreateSimpleProductDataIn> {
        String description;
        @NonNull
        String imageUrl;
        @NonNull
        String name;
        Date publishDate;
        EProductStatus status;
        Integer totalChapter;
        EProductType type;

        public CreateSimpleProductDataIn(String description, @NonNull String imageUrl, @NonNull String name, Date publishDate, EProductStatus status, Integer totalChapter, EProductType type) {
            this.description = description;
            this.imageUrl = imageUrl;
            this.name = name;
            this.publishDate = publishDate;
            this.status = status;
            this.totalChapter = totalChapter;
            this.type = type;
            this.validateSelf();
        }
    }

    @Value
    @EqualsAndHashCode(callSuper = false)
    class CreateSimpleProductDataOut extends SelfValidating<CreateSimpleProductDataOut> {
        @NonNull
        Product product;
    }

}
