package com.awbd.proiect.controllers;

import com.awbd.proiect.domain.Agency;
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

    @PostMapping("/save")
    public
    ResponseEntity<Agency> save(@RequestBody  Agency agency) {
        Agency savedAgency = agencyService.save(agency);
        return ResponseEntity.created(UriComponentsBuilder.
                fromHttpUrl(ServletUriComponentsBuilder.
                        fromCurrentRequestUri().
                        toUriString())
                .replacePath("locations/" + savedAgency.getId())
                .build(savedAgency.getId()))
                .body(savedAgency);

    }



}
