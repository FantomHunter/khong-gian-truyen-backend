package com.codehunter.khonggiantruyen.core.port.in;

import com.codehunter.khonggiantruyen.SelfValidating;
import com.codehunter.khonggiantruyen.domain.Category;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.util.ArrayList;
import java.util.List;

public interface IGetAllCategoryUseCase {
    GetAllCategoryDataOut getAllCategory();

    @Value
    @EqualsAndHashCode(callSuper = false)
    class GetAllCategoryDataOut extends SelfValidating<GetAllCategoryDataOut> {
        List<Category> categories = new ArrayList<>();
    }
}
