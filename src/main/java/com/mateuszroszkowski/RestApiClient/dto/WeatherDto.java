package com.mateuszroszkowski.RestApiClient.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WeatherDto {
    private float temperature;
    private int pressure;
    private int humidity;
    private float windSpeed;
}
