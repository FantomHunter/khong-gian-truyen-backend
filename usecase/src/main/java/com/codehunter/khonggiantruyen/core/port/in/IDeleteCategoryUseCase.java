package com.codehunter.khonggiantruyen.core.port.in;

import com.codehunter.khonggiantruyen.SelfValidating;
import com.codehunter.khonggiantruyen.core.exception.EntityNotFoundException;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;

public interface IDeleteCategoryUseCase {
    void deleteCategory(DeleteCategoryDataIn dataIn) throws EntityNotFoundException;

    @Value
    @EqualsAndHashCode(callSuper = false)
    class DeleteCategoryDataIn extends SelfValidating<DeleteCategoryDataIn> {
        @NonNull
        Long id;

        public DeleteCategoryDataIn(@NonNull Long id) {
            this.id = id;
            validateSelf();
        }
    }
}
