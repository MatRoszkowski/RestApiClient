package com.mateuszroszkowski.RestApiClient.webClient.weather.dto;

import lombok.Data;

@Data
public class OpenWeatherMainDto {
    private float temp;
    private int pressure;
    private int humidity;
}
