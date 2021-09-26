package com.codehunter.khonggiantruyen.adapter.web.api.getallauthor;

import com.codehunter.khonggiantruyen.adapter.web.api.common.AuthorDto;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter(AccessLevel.NONE)
@Builder
public class GetAllAuthorResponse {
    private List<AuthorDto> authorList;
}
