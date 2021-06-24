package com.codehunter.khonggiantruyen.adapter.web.api.updateproduct;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author codehunter
 */
public interface IUpdateProductApi {

    @PutMapping(path = "/product")
    @ResponseBody
    UpdateProductResponse updateProduct(@RequestBody UpdateProductRequest in);
}
