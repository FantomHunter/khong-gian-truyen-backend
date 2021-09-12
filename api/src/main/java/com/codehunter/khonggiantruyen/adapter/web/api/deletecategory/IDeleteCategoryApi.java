package com.codehunter.khonggiantruyen.adapter.web.api.deletecategory;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

public interface IDeleteCategoryApi {
    @DeleteMapping("/category/{id}")
    @ResponseBody
    DeleteCategoryResponse deleteCategory(@PathVariable("id") Long id);
}
