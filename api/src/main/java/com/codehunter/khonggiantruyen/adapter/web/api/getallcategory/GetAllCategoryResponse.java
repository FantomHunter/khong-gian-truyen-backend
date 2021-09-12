package com.codehunter.khonggiantruyen.adapter.web.api.getallcategory;

import com.codehunter.khonggiantruyen.adapter.web.api.common.CategoryDto;
import lombok.*;

import java.util.List;

@Value
@EqualsAndHashCode
@Builder
@RequiredArgsConstructor
public class GetAllCategoryResponse {
    @NonNull List<CategoryDto> categories;
}
