package com.codehunter.khonggiantruyen.adapter.web.api.getallauthor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

public interface IGetAllAuthorApi {
    @GetMapping(path = "/author")
    @ResponseBody
    GetAllAuthorResponse getAllAuthor(@RequestParam Integer page, @RequestParam Integer size);
}
