package com.codehunter.khonggiantruyen.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Value;

@AllArgsConstructor
@EqualsAndHashCode
public class ResourceDownload {
    @Getter
    private final Long id;
    @Getter
    private final EFormatType type;
    @Getter
    private final String url;
}
