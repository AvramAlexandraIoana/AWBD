package com.awbd.proiect.controllers;

import com.awbd.proiect.domain.Agency;
import com.awbd.proiect.domain.Country;
import com.awbd.proiect.domain.Location;
import com.awbd.proiect.services.AgencyService;
import com.awbd.proiect.services.CountryService;
import com.awbd.proiect.services.CountryServiceImpl;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

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

    @PostMapping()
    public
    ResponseEntity<Country> save(@RequestBody Country country) {
        Country savedCountry = countryService.save(country);
        return ResponseEntity.created(UriComponentsBuilder.
                fromHttpUrl(ServletUriComponentsBuilder.
                        fromCurrentRequestUri().
                        toUriString())
                .replacePath("country/" + savedCountry.getId())
                .build(savedCountry.getId()))
                .body(savedCountry);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> getById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(countryService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Country> update(@RequestBody Country country) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(countryService.update(country));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        countryService.deleteById(id);
    }


}
