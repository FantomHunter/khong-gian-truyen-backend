package com.codehunter.khonggiantruyen.adapter.web.api.createauthor;

import com.codehunter.khonggiantruyen.adapter.web.api.common.AuthorDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

@Data
@Setter(AccessLevel.NONE)
@Builder
public class CreateAuthorResponse {
    private AuthorDto newAuthor;
}
