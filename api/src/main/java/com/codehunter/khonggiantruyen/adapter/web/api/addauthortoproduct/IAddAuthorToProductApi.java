package com.codehunter.khonggiantruyen.adapter.web.api.addauthortoproduct;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

public interface IAddAuthorToProductApi {
    @PostMapping("/product/author")
    @ResponseBody
    AddAuthorToProductResponse addAuthorToProduct(@RequestBody AddAuthorToProductRequest request);
}
