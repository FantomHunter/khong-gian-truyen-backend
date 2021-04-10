package com.codehunter.khonggiantruyen.adapter.web.api.deleteproduct;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

public interface IDeleteProductApi {
    @DeleteMapping("/product/{id}")
    @ResponseBody
    DeleteProductResponse deleteProduct(@PathVariable("id") Long id);
}
