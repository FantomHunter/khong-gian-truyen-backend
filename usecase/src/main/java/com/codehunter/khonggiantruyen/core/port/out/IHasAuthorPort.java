package com.codehunter.khonggiantruyen.core.port.out;

import lombok.NonNull;

public interface IHasAuthorPort {
    Boolean hasAuthorWithId(@NonNull Long authorId);
}
