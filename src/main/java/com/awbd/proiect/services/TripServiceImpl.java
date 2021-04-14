package com.awbd.proiect.services;

import com.awbd.proiect.domain.Trip;
import com.awbd.proiect.repositories.TripRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class TripServiceImpl implements TripService {
    private final Logger log = LoggerFactory.getLogger(TripServiceImpl.class);

    TripRepository tripRepository;

    @Autowired
    public TripServiceImpl(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    @Override
    public
    List<Trip> findAll(){
        List<Trip> trips = new LinkedList<>();
        tripRepository.findAll().iterator().forEachRemaining(trips::add);
        log.info("Find all trips ...", trips);
        return trips;
    }

    @Override
    public Trip findById(Long l) {
        Optional<Trip> tripOptional =
                tripRepository.findById(l);
        if (!tripOptional.isPresent()) {
            throw new RuntimeException("Trip not found!");
        }
        log.info("Find by id ...", tripOptional.get());
        return tripOptional.get();
    }

    @Override
    public Trip save(Trip trip) {
        Trip savedTrip = tripRepository.save(trip);
        log.info("Saved trip ...", savedTrip);
        return savedTrip;
    }


    @Override
    public Trip update(Trip trip) {
        Optional<Trip> tripOptional =
                tripRepository.findById(trip.getId());
        if (!tripOptional.isPresent()) {
            throw new RuntimeException("Trip not found!");
        }
        Trip updateTrip = tripRepository.save(trip);
        log.info("Update trip ...", updateTrip);
        return updateTrip;
    }

    @Override
    public void deleteById(Long id) {
        log.info("Delete by id ", id);
        tripRepository.deleteById(id);
    }


}
