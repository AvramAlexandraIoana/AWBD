package com.awbd.proiect.services;

import com.awbd.proiect.domain.Country;
import com.awbd.proiect.domain.Location;
import com.awbd.proiect.repositories.CountryRepository;
import com.awbd.proiect.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public  class LocationServiceImpl implements  LocationService{
    LocationRepository locationRepository;
    @Autowired
    public LocationServiceImpl(LocationRepository locationRepository) {

        this.locationRepository = locationRepository;
    }

    @Override
    public
    List<Location> findAll(){
        List<Location> locations = new LinkedList<>();
        locationRepository.findAll().iterator().forEachRemaining(locations::add);
        return locations;
    }

    @Override
    public Location save(Location location) {
        Location savedLocation = locationRepository.save(location);
        return savedLocation;
    }



}
