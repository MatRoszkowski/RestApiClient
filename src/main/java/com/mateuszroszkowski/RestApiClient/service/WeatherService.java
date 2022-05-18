package com.mateuszroszkowski.RestApiClient.service;

import com.mateuszroszkowski.RestApiClient.dto.WeatherDto;
import com.mateuszroszkowski.RestApiClient.webClient.weather.WeatherClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@AllArgsConstructor
public class WeatherService {
    private final WeatherClient weatherClient;


    public WeatherDto getWeather(double latitude, double longitude) {
        WeatherDto weather = weatherClient.getWeatherForLocation(latitude, longitude);
        return weather;
    }
}
