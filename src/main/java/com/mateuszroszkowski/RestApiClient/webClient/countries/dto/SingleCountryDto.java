package com.mateuszroszkowski.RestApiClient.webClient.countries.dto;

import lombok.Data;

@Data
public class SingleCountryDto {
    private String name;
    private long population;
    private int area;
}
