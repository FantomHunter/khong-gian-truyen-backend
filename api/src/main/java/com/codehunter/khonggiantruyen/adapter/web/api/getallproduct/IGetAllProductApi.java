package com.codehunter.khonggiantruyen.adapter.web.api.getallproduct;

import com.codehunter.khonggiantruyen.adapter.web.api.common.EOrder;
import org.springframework.web.bind.annotation.*;

public interface IGetAllProductApi {

    @GetMapping(path = "/product")
    @ResponseBody
    GetAllProductResponse getAllProduct(@RequestParam Integer page, @RequestParam Integer size, @RequestParam EOrder order);
}
