package com.codehunter.khonggiantruyen.adapter.web.api.createsimpleproduct;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

public interface ICreateSimpleProductApi {
    @PostMapping(path = "/product")
    @ResponseBody
    CreateSimpleProductResponse createSimpleProduct(@RequestBody CreateSimpleProductRequest request);
}
