package com.mateuszroszkowski.RestApiClient.service;

import com.mateuszroszkowski.RestApiClient.dto.CountryDto;
import com.mateuszroszkowski.RestApiClient.webClient.countries.CountryClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CountryService {
    private final CountryClient countryClient;

    public List<CountryDto> getCountriesWithString(String name) {
        return countryClient.getCountriesWithString(name);
    }

    public List<CountryDto> getCountriesWithStringAndPopulationGreaterThan(long population, String name) {
        return countryClient.getCountiesWithStringAndPopulationGreaterThan(population, name);
    }

    public int getNumberOfCountiesWithString(String name) {
        return countryClient.getNumberOfCountiesWithString(name);
    }
}
