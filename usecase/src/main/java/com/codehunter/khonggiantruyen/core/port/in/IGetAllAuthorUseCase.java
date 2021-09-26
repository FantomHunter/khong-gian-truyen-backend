package com.codehunter.khonggiantruyen.core.port.in;

import com.codehunter.khonggiantruyen.SelfValidating;
import com.codehunter.khonggiantruyen.domain.Author;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public interface IGetAllAuthorUseCase {
    GetAllAuthorDataOut getAllAuthor(GetAllAuthorDataIn dataIn);

    @Value
    @EqualsAndHashCode(callSuper = false)
    class GetAllAuthorDataIn extends SelfValidating<GetAllAuthorDataIn> {
        @NonNull
        Integer page;
        @NonNull
        Integer size;

        public GetAllAuthorDataIn(@NonNull Integer page, @NonNull Integer size) {
            this.page = page;
            this.size = size;
            validateSelf();
        }
    }

    @Value
    @EqualsAndHashCode(callSuper = false)
    class GetAllAuthorDataOut extends SelfValidating<GetAllAuthorDataOut> {
        List<Author> authorList;

        public GetAllAuthorDataOut(List<Author> authorList) {
            this.authorList = Collections.unmodifiableList(authorList);
        }
    }

}
