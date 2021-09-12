package com.codehunter.khonggiantruyen.core.port.out;

import lombok.NonNull;

public interface IHasCategoryPort {
    Boolean hasCategoryWithId(@NonNull Long id);
}
