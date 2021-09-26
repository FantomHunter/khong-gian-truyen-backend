package com.codehunter.khonggiantruyen.adapter.web.api.getallauthor;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter(AccessLevel.NONE)
@Builder
public class GetAllAuthorRequest {
    @NonNull
    private Integer page;
    @NonNull
    private Integer size;
}
