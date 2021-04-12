package com.awbd.proiect.services;

import com.awbd.proiect.domain.Agency;
import com.awbd.proiect.domain.Country;
import com.awbd.proiect.repositories.AgencyRepository;
import com.awbd.proiect.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl  implements  CountryService{
    CountryRepository countryRepository;
    @Autowired
    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public
    List<Country> findAll(){
        List<Country> countryList = new LinkedList<>();
        countryRepository.findAll().iterator().forEachRemaining(countryList::add);
        return countryList;
    }


}
