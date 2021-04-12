package com.awbd.proiect.services;

import com.awbd.proiect.domain.Agency;
import com.awbd.proiect.repositories.AgencyRepository;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AgencyServiceTest {
    AgencyService agencyService;

    @Mock
    AgencyRepository agencyRepository;

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Before
    public void setUp() throws Exception {
        agencyService = new AgencyServiceImpl(agencyRepository);
    }

    @Test
    public void findAgencies() {
        List<Agency> agencyList = new ArrayList<Agency>();
        Agency agency = new Agency();
        agency.setId(4L);
        agency.setName("TEST");
        agencyList.add(agency);

        when(agencyRepository.findAll()).thenReturn(agencyList);
        List<Agency> agencies = agencyService.findAll();
        assertEquals(agencies.size(), 1);
        verify(agencyRepository, times(1)).findAll();
    }




}
