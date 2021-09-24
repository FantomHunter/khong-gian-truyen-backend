package com.codehunter.khonggiantruyen.adapter.web.api.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorDto {
    private Long id;
    private String name;
}
