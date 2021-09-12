package com.codehunter.khonggiantruyen.adapter.web.api.getallcategory;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public interface IGetAllCategoryApi {
    @GetMapping("/category")
    @ResponseBody
    GetAllCategoryResponse getAllCategory();
}
