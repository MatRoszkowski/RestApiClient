package com.mateuszroszkowski.RestApiClient.webClient.weather.dto;

import lombok.Data;

@Data
public class OpenWeatherWeatherDto {
    private OpenWeatherMainDto main;
    private OpenWeatherWindDto wind;
}
