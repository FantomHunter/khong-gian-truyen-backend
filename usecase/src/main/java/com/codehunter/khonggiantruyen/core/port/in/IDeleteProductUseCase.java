package com.codehunter.khonggiantruyen.core.port.in;

import com.codehunter.khonggiantruyen.SelfValidating;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;

public interface IDeleteProductUseCase {
    void deleteProduct(DeleteProductDataIn in);

    @Value
    @EqualsAndHashCode(callSuper = false)
    class DeleteProductDataIn extends SelfValidating<DeleteProductDataIn> {
        @NonNull
        Long id;

        public DeleteProductDataIn(@NonNull Long id) {
            this.id = id;
            validateSelf();
        }
    }
}
