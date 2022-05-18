package com.mateuszroszkowski.RestApiClient.webClient.weather;

import com.mateuszroszkowski.RestApiClient.dto.WeatherDto;
import com.mateuszroszkowski.RestApiClient.webClient.weather.dto.OpenWeatherWeatherDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherClient {

    private RestTemplate restTemplate = new RestTemplate();
    private final String API_KEY = "f43f47a6dea2ced6871035e5a717b27f";
    private final String URL = "https://api.openweathermap.org/data/2.5/weather";

    public WeatherDto getWeatherForLocation(double latitude, double longitude) {
        String url = "?lat={lat}&lon={lon}&appid={API key}&units=metric";
        OpenWeatherWeatherDto openWeatherWeatherDto = callGetMethod(url,
                OpenWeatherWeatherDto.class,
                latitude, longitude, API_KEY);

        return WeatherDto.builder()
                .temperature(openWeatherWeatherDto.getMain().getTemp())
                .pressure(openWeatherWeatherDto.getMain().getPressure())
                .humidity(openWeatherWeatherDto.getMain().getHumidity())
                .windSpeed(openWeatherWeatherDto.getWind().getSpeed())
                .build();
    }

    private <T> T callGetMethod(String url, Class<T> responseType, Object... objects) {
        return restTemplate.getForObject(URL + url,
                responseType, objects);
    }
}
