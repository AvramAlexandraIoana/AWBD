package com.awbd.proiect.controllers;

import com.awbd.proiect.domain.Agency;
import com.awbd.proiect.domain.Country;
import com.awbd.proiect.services.AgencyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/agency")
public class AgencyController {
    private AgencyService agencyService;

    public AgencyController(AgencyService agencyService) {
        this.agencyService = agencyService;
    }


    @GetMapping("/list")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<List<Agency>> get() {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(agencyService.findAll());
    }

    @PostMapping()
    public
    @PreAuthorize("hasRole('ROLE_ADMIN')")
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
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Agency> getById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(agencyService.findById(id));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Agency> update(@RequestBody Agency agency) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(agencyService.update(agency));
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteById(@PathVariable Long id) {
        agencyService.deleteById(id);
    }



}
