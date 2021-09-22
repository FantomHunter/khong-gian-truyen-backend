package com.codehunter.khonggiantruyen.core.port.in;

import com.codehunter.khonggiantruyen.SelfValidating;
import com.codehunter.khonggiantruyen.core.exception.EntityNotFoundException;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;

public interface IAddCategoryToProductUseCase {
    void addCategoryToProduct(AddCategoryToProductDataIn dataIn) throws EntityNotFoundException;

    @Value
    @EqualsAndHashCode(callSuper = false)
    class AddCategoryToProductDataIn extends SelfValidating<AddCategoryToProductDataIn> {
        @NonNull
        Long productId;
        @NonNull
        Long CategoryId;

        public AddCategoryToProductDataIn(@NonNull Long productId, @NonNull Long categoryId) {
            this.productId = productId;
            CategoryId = categoryId;
            validateSelf();
        }
    }

}
