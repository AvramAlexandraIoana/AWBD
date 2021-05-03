package com.awbd.proiect.services;

import com.awbd.proiect.domain.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Long id);
    void deleteById(Long id);
}
