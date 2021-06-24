package com.codehunter.khonggiantruyen.core.port.in;

import com.codehunter.khonggiantruyen.SelfValidating;
import com.codehunter.khonggiantruyen.core.exception.EntityNotFoundException;
import com.codehunter.khonggiantruyen.domain.Product;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;

/**
 * @author codehunter
 */
public interface IUpdateProductUseCase {
    UpdateProductDataOut updateProduct(UpdateProductDataIn in) throws EntityNotFoundException;

    @Value
    @EqualsAndHashCode(callSuper = false)
    class UpdateProductDataIn extends SelfValidating<UpdateProductDataIn> {
        @NonNull
        Product product;

        public UpdateProductDataIn(@NonNull Product product) {
            this.product = product;
            validateSelf();
        }
    }

    @Value
    @EqualsAndHashCode(callSuper = false)
    class UpdateProductDataOut extends SelfValidating<UpdateProductDataOut> {
        Product product;
    }


}
