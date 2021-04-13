package com.awbd.proiect.services;

import com.awbd.proiect.domain.Country;
import com.awbd.proiect.domain.Location;
import com.awbd.proiect.repositories.CountryRepository;
import com.awbd.proiect.repositories.LocationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public  class LocationServiceImpl implements  LocationService{

    private final Logger log = LoggerFactory.getLogger(LocationServiceImpl.class);

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
        log.info("Find all locations ...");
        return locations;
    }

    @Override
    public Location findById(Long l) {
        Optional<Location> locationOptional =
                locationRepository.findById(l);
        if (!locationOptional.isPresent()) {
            throw new RuntimeException("Location not found!");
        }
        log.info("Find by id ", l);
        return locationOptional.get();
    }

    @Override
    public Location save(Location location) {
        Location savedLocation = locationRepository.save(location);
        log.info("Saved location ", savedLocation);
        return savedLocation;
    }


    @Override
    public Location update(Location location) {
        Optional<Location> locationOptional =
                locationRepository.findById(location.getId());
        if (!locationOptional.isPresent()) {
            throw new RuntimeException("Location not found!");
        }
        Location updateLocation = locationRepository.save(location);
        log.info("Update location ", updateLocation);
        return updateLocation;
    }

    @Override
    public void deleteById(Long id) {
        log.info("Delete by id ", id);
        locationRepository.deleteById(id);
    }




}
