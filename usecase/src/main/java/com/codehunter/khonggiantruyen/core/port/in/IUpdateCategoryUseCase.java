package com.codehunter.khonggiantruyen.core.port.in;

import com.codehunter.khonggiantruyen.SelfValidating;
import com.codehunter.khonggiantruyen.core.exception.EntityNotFoundException;
import com.codehunter.khonggiantruyen.domain.Category;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;

public interface IUpdateCategoryUseCase {
    UpdateCategoryDataOut updateCategory(UpdateCategoryDataIn dataIn) throws EntityNotFoundException;

    @Value
    @EqualsAndHashCode(callSuper = false)
    class UpdateCategoryDataIn extends SelfValidating<UpdateCategoryDataIn> {
        @NonNull Category category;
        public UpdateCategoryDataIn(@NonNull Category category) {
            this.category = category;
            validateSelf();
        }
    }

    @Value
    @EqualsAndHashCode(callSuper = false)
    class UpdateCategoryDataOut extends SelfValidating<UpdateCategoryDataOut> {
        Category category;

        public UpdateCategoryDataOut(Category category) {
            this.category = category;
            validateSelf();
        }
    }
}
