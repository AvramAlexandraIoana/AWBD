package com.awbd.proiect.controllers;

import com.awbd.proiect.domain.Country;
import com.awbd.proiect.domain.Location;
import com.awbd.proiect.domain.User;
import com.awbd.proiect.services.LocationService;
import com.awbd.proiect.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/list")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<User>> get() {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.findById(id));
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteById(@PathVariable Long id) {
        userService.deleteById(id);
    }

}
