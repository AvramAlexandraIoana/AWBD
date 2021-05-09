package com.awbd.proiect.controllers;
import com.awbd.proiect.mapper.CountryMapper;
import com.awbd.proiect.mapper.LocationMapper;
import com.awbd.proiect.repositories.CountryRepository;
import com.awbd.proiect.repositories.LocationRepository;
import com.awbd.proiect.services.CountryService;
import com.awbd.proiect.services.CountryServiceImpl;
import com.awbd.proiect.services.LocationService;
import com.awbd.proiect.services.LocationServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;


import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class LocationControllerIT {
    @Autowired
    MockMvc mockMvc;

    LocationService locationService;

    @Autowired
    LocationMapper locationMapper;

    @Autowired
    private ObjectMapper objectMapper;

    @Mock
    LocationRepository locationRepository;


    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Before
    public void setUp() throws Exception {
        locationService = new LocationServiceImpl(locationRepository);
    }
}
