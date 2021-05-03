package com.awbd.proiect.services;


import com.awbd.proiect.domain.Trip;
import com.awbd.proiect.domain.User;
import com.awbd.proiect.repositories.UserRepository;
import com.awbd.proiect.utils.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements  UserService{
    UserRepository userRepository;

    @Autowired
    public  UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public List<User> findAll() {
       List<User> users = new LinkedList<>();
        userRepository.findAll().iterator().forEachRemaining(users::add);
        return users;
    }

    @Override
    public User findById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (!userOptional.isPresent()) {
            throw new ObjectNotFoundException("User " + id + " not found");
        }
        return userOptional.get();
    }

    @Override
    public void deleteById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (!userOptional.isPresent()) {
            throw new ObjectNotFoundException("User not found!");
        }
        User user = userOptional.get();
        List<Trip> trips = new LinkedList<Trip>();
        user.getTrips().iterator().forEachRemaining(trips::add);

        for (Trip trip: trips
        ) {
            user.removeTrip(trip);
        }

        userRepository.save(user);
        userRepository.deleteById(id);

    }

}
