package com.mateuszroszkowski.RestApiClient.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CountryDto {
    private String name;
    private long population;
    private int area;
}
