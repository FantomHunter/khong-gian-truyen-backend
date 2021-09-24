package com.codehunter.khonggiantruyen.adapter.web.api.createauthor;

import lombok.*;

@Data
@Setter(AccessLevel.NONE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateAuthorRequest {
    @NonNull
    private String name;
}
