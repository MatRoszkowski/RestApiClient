package com.mateuszroszkowski.RestApiClient.webClient.countries;

import com.mateuszroszkowski.RestApiClient.dto.CountryDto;
import com.mateuszroszkowski.RestApiClient.webClient.countries.dto.CountryResponseDto;
import com.mateuszroszkowski.RestApiClient.webClient.countries.dto.SingleCountryDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CountryClient {
    private RestTemplate restTemplate = new RestTemplate();
    private final String URL = "https://jsonmock.hackerrank.com/api/countries/search?";

    public List<CountryDto> getCountriesWithString(String name) {
        List<CountryDto> countries = new ArrayList<>();
        String url = "name={name}&page={page}";
        int page = 0;
        int totalPages;
        do {
            page++;
            CountryResponseDto countryResponseDto = callGetMethod(url, CountryResponseDto.class, name, page);
            totalPages = countryResponseDto.getTotal_pages();
            List<SingleCountryDto> singleCountryDtos = countryResponseDto.getData();
            countries.addAll(singleCountryDtos.stream().map(c -> CountryDto.builder()
                    .name(c.getName())
                    .area(c.getArea())
                    .population(c.getPopulation()).build()).collect(Collectors.toList()));
        } while (page < totalPages);
        return countries;
    }

    public List<CountryDto> getCountiesWithStringAndPopulationGreaterThan(long population, String name){
        List<CountryDto> counties = getCountriesWithString(name);
        List<CountryDto> countiesWithPopulationGreaterThan = counties.stream()
                .filter(countryDto -> countryDto.getPopulation() > population).collect(Collectors.toList());
        return countiesWithPopulationGreaterThan;
    }

    public int getNumberOfCountiesWithString(String name) {
        List<CountryDto> counties = getCountriesWithString(name);
        return counties.size();
    }


    private <T> T callGetMethod(String url, Class<T> responseType, Object... objects) {
        return restTemplate.getForObject(URL + url, responseType, objects);
    }
}
