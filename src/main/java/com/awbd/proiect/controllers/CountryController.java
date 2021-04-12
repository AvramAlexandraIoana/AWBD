package com.awbd.proiect.controllers;

import com.awbd.proiect.domain.Agency;
import com.awbd.proiect.domain.Country;
import com.awbd.proiect.services.AgencyService;
import com.awbd.proiect.services.CountryService;
import com.awbd.proiect.services.CountryServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {
    private CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/list")
    public
    ResponseEntity<List<Country>> get() {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(countryService.findAll());
    }
}
