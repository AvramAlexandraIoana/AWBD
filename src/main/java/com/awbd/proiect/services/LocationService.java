package com.awbd.proiect.services;

import com.awbd.proiect.domain.Location;

import java.util.List;

public interface LocationService {
    List<Location> findAll();
    Location save(Location location);
}
