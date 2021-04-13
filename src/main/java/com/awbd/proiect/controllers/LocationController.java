package com.awbd.proiect.controllers;

import com.awbd.proiect.domain.Country;
import com.awbd.proiect.domain.Location;
import com.awbd.proiect.services.LocationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/location")
public class LocationController {
    private LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }


    @GetMapping("/list")
    public
    ResponseEntity<List<Location>> get() {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(locationService.findAll());
    }

    @PostMapping()
    public
    ResponseEntity<Location> save(@RequestBody Location location) {
        Location savedLocation = locationService.save(location);
        return ResponseEntity.created(UriComponentsBuilder.
                fromHttpUrl(ServletUriComponentsBuilder.
                        fromCurrentRequestUri().
                        toUriString())
                .replacePath("locations/" + savedLocation.getId())
                .build(savedLocation.getId()))
                .body(savedLocation);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Location> getById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(locationService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Location> update(@RequestBody Location location) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(locationService.update(location));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        locationService.deleteById(id);
    }
}
