package com.awbd.proiect.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CountryRequest {

    @NotBlank(message = "Country name cannot be blank!")
    @NotNull(message = "Country name cannot be null!")
    private String countryName;
}
