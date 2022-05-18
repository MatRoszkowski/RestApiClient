package com.mateuszroszkowski.RestApiClient.webClient.countries.dto;

import lombok.Data;

import java.util.List;

@Data
public class CountryResponseDto {
    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private List<SingleCountryDto> data;

}
