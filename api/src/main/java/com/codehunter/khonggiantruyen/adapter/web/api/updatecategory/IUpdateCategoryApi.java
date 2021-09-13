package com.codehunter.khonggiantruyen.adapter.web.api.updatecategory;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

public interface IUpdateCategoryApi {
    @PutMapping("/category")
    @ResponseBody
    UpdateCategoryResponse updateCategory(@RequestBody UpdateCategoryRequest in);
}
