package com.awbd.proiect.mapper;

import com.awbd.proiect.domain.Country;
import com.awbd.proiect.dto.CountryRequest;
import org.springframework.stereotype.Component;

@Component
public class CountryMapper {
    public Country countryRequestToCountry(CountryRequest countryRequest) {
        return new Country(countryRequest.getCountryName());
    }
}
