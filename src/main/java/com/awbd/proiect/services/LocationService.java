package com.awbd.proiect.services;

import com.awbd.proiect.domain.Country;
import com.awbd.proiect.domain.Location;

import java.util.List;

public interface LocationService {
    List<Location> findAll();
    Location findById(Long l);
    Location save(Location location);
    Location update(Location location);
    void deleteById(Long id);
}
