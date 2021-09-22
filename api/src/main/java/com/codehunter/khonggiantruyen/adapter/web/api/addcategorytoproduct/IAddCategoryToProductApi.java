package com.codehunter.khonggiantruyen.adapter.web.api.addcategorytoproduct;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

public interface IAddCategoryToProductApi {
    @PostMapping("/product/category")
    @ResponseBody
    AddCategoryToProductResponse addCategoryToProduct(@RequestBody AddCategoryToProductRequest request);
}
