package com.mateuszroszkowski.RestApiClient.controller;

import com.mateuszroszkowski.RestApiClient.dto.WeatherDto;
import com.mateuszroszkowski.RestApiClient.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping("/weather/{latitude}/{longitude}")
    public WeatherDto getWeather(@PathVariable double latitude, @PathVariable double longitude) {
        return weatherService.getWeather(latitude, longitude);
    }
}
