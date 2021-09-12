package com.codehunter.khonggiantruyen.core.port.in;

import com.codehunter.khonggiantruyen.SelfValidating;
import com.codehunter.khonggiantruyen.domain.Category;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;

public interface ICreateCategoryUseCase {
    CreateCategoryDataOut createCategory(CreateCategoryDataIn dataIn);

    @Value
    @EqualsAndHashCode(callSuper = false)
    class CreateCategoryDataIn extends SelfValidating<CreateCategoryDataIn> {
        @NonNull
        String name;

        public CreateCategoryDataIn( @NonNull String name) {
            this.name = name;
            this.validateSelf();
        }
    }

    @Value
    @EqualsAndHashCode(callSuper = false)
    class CreateCategoryDataOut extends SelfValidating<CreateCategoryDataOut> {
        Category category;
    }

}
