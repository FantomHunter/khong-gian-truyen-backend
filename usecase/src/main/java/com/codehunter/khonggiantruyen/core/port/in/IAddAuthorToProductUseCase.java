package com.codehunter.khonggiantruyen.core.port.in;

import com.codehunter.khonggiantruyen.SelfValidating;
import com.codehunter.khonggiantruyen.core.exception.EntityNotFoundException;
import lombok.EqualsAndHashCode;
import lombok.Value;

public interface IAddAuthorToProductUseCase {
    void addAuthorToProduct(AddAuthorToProductDataIn dataIn) throws EntityNotFoundException;

    @Value
    @EqualsAndHashCode(callSuper = false)
    class AddAuthorToProductDataIn extends SelfValidating<AddAuthorToProductDataIn> {
        Long productId;
        Long authorId;

        public AddAuthorToProductDataIn(Long productId, Long authorId) {
            this.productId = productId;
            this.authorId = authorId;
            validateSelf();
        }
    }
}
