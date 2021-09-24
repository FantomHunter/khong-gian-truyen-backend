package com.codehunter.khonggiantruyen.adapter.web.api.createauthor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

public interface ICreateAuthorApi {
    @PostMapping("/author")
    @ResponseBody
    CreateAuthorResponse createAuthor(@RequestBody CreateAuthorRequest request);
}
