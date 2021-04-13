package com.awbd.proiect.services;

import com.awbd.proiect.domain.Agency;
import com.awbd.proiect.domain.Country;
import com.awbd.proiect.repositories.AgencyRepository;
import com.awbd.proiect.repositories.CountryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl  implements  CountryService{

    private final Logger log = LoggerFactory.getLogger(CountryServiceImpl.class);

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
        log.info("Find all countries ...");
        return countryList;
    }

    @Override
    public Country findById(Long l) {
        Optional<Country> productOptional =
                countryRepository.findById(l);
        if (!productOptional.isPresent()) {
            throw new RuntimeException("Country not found!");
        }
        log.info("Find by id ", l);
        return productOptional.get();
    }

    @Override
    public Country save(Country country) {
        Country savedCountry = countryRepository.save(country);
        log.info("Saved country ", savedCountry);
        return savedCountry;
    }

    @Override
    public Country update(Country country) {
        Optional<Country> productOptional =
                countryRepository.findById(country.getId());
        if (!productOptional.isPresent()) {
            throw new RuntimeException("Country not found!");
        }
        Country updateCountry = countryRepository.save(country);
        log.info("Update country ", updateCountry);
        return updateCountry;
    }

    @Override
    public void deleteById(Long id) {
        log.info("Delete by id ", id);
        countryRepository.deleteById(id);
    }




}
