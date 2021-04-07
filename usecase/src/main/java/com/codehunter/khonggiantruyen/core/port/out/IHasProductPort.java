package com.codehunter.khonggiantruyen.core.port.out;

import lombok.NonNull;

public interface IHasProductPort {
    Boolean hasProductWithId(@NonNull Long id);
}
