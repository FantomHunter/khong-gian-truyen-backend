package com.codehunter.khonggiantruyen.core.port.in;

import com.codehunter.khonggiantruyen.SelfValidating;
import com.codehunter.khonggiantruyen.domain.Product;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;

import java.util.ArrayList;
import java.util.List;

public interface IGetAllProductUseCase {
    GetAllProductDataOut getAllProduct(GetAllProductDataIn in);

    @Value
    @EqualsAndHashCode(callSuper = false)
    class GetAllProductDataIn extends SelfValidating<GetAllProductDataIn> {
        @NonNull
        Integer page;
        @NonNull
        Integer size;
        @NonNull
        EOrder orderBy;

        public enum EOrder {
            BY_ID, BY_TIME, BY_VIEW, BY_COMMENT;
        }
    }

    @Value
    @EqualsAndHashCode(callSuper = false)
    class GetAllProductDataOut extends SelfValidating<GetAllProductDataOut> {
        List<Product> productList = new ArrayList<>();
    }

}
