package com.mateuszroszkowski.RestApiClient.controller;

import com.mateuszroszkowski.RestApiClient.dto.CountryDto;
import com.mateuszroszkowski.RestApiClient.dto.WeatherDto;
import com.mateuszroszkowski.RestApiClient.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CountryController {

    private final CountryService countryService;

    @GetMapping("/countries/{name}")
    public List<CountryDto> getCountriesWithString(@PathVariable String name) {
        return countryService.getCountriesWithString(name);
    }

    @GetMapping("/countries/{name}/population/{population}")
    public List<CountryDto> getCountriesWithStringAndPopulationGreaterThan(@PathVariable long population, @PathVariable String name) {
        return countryService.getCountriesWithStringAndPopulationGreaterThan(population, name);
    }

    @GetMapping("/countries/size/{name}")
    public int getNumberOfCountriesWithString(@PathVariable String name) {
        return countryService.getNumberOfCountiesWithString(name);
    }
}
