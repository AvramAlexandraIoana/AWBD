package com.awbd.proiect.controllers;

import com.awbd.proiect.domain.Location;
import com.awbd.proiect.domain.Trip;
import com.awbd.proiect.services.LocationService;
import com.awbd.proiect.services.TripService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/trip")
public class TripController {
    private TripService tripService;

    public TripController(TripService tripService) {
        this.tripService = tripService;
    }


    @GetMapping("/list")
    public
    ResponseEntity<List<Trip>> get() {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(tripService.findAll());
    }

    @PostMapping()
    public
    ResponseEntity<Trip> save(@RequestBody Trip trip) {
        Trip savedTrip = tripService.save(trip);
        return ResponseEntity.created(UriComponentsBuilder.
                fromHttpUrl(ServletUriComponentsBuilder.
                        fromCurrentRequestUri().
                        toUriString())
                .replacePath("trip/" + savedTrip.getId())
                .build(savedTrip.getId()))
                .body(savedTrip);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Trip> getById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(tripService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Trip> update(@RequestBody Trip trip) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(tripService.update(trip));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        tripService.deleteById(id);
    }


}