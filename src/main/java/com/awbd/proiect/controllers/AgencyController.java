package com.awbd.proiect.controllers;

import com.awbd.proiect.domain.Agency;
import com.awbd.proiect.domain.Country;
import com.awbd.proiect.services.AgencyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/agency")
public class AgencyController {
    private AgencyService agencyService;

    public AgencyController(AgencyService agencyService) {
        this.agencyService = agencyService;
    }


    @GetMapping("/list")
    public ResponseEntity<List<Agency>> get() {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(agencyService.findAll());
    }

    @PostMapping()
    public
    ResponseEntity<Agency> save(@RequestBody  Agency agency) {
        Agency savedAgency = agencyService.save(agency);
        return ResponseEntity.created(UriComponentsBuilder.
                fromHttpUrl(ServletUriComponentsBuilder.
                        fromCurrentRequestUri().
                        toUriString())
                .replacePath("agency/" + savedAgency.getId())
                .build(savedAgency.getId()))
                .body(savedAgency);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Agency> getById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(agencyService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Agency> update(@RequestBody Agency agency) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(agencyService.update(agency));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        agencyService.deleteById(id);
    }



}
