package com.codehunter.khonggiantruyen.core.port.in;

import com.codehunter.khonggiantruyen.SelfValidating;
import com.codehunter.khonggiantruyen.domain.Author;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;

public interface ICreateAuthorUseCase {
    CreateAuthorDataOut createAuthor(CreateAuthorDataIn  dataIn);

    @Value
    @EqualsAndHashCode(callSuper = false)
    class CreateAuthorDataIn extends SelfValidating<CreateAuthorDataIn> {
        @NonNull
        String name;

        public CreateAuthorDataIn(@NonNull String name) {
            this.name = name;
            validateSelf();
        }
    }

    @Value
    @EqualsAndHashCode(callSuper = false)
    class CreateAuthorDataOut extends SelfValidating<CreateAuthorDataOut>{
        Author author;

        public CreateAuthorDataOut(Author author) {
            this.author = author;
            validateSelf();
        }
    }
}

