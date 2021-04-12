package com.awbd.proiect.services;

import com.awbd.proiect.domain.Agency;
import com.awbd.proiect.repositories.AgencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class AgencyServiceImpl implements AgencyService {
    AgencyRepository agencyRepository;
    @Autowired
    public AgencyServiceImpl(AgencyRepository agencyRepository) {
        this.agencyRepository = agencyRepository;
    }

    @Override
    public List<Agency> findAll(){
        List<Agency> agencyList = new LinkedList<>();

        agencyRepository.findAll().iterator().forEachRemaining(agencyList::add);
        return agencyList;
    }

    @Override
    public Agency findById(Long l) {
        Optional<Agency> agencyOptional =
                agencyRepository.findById(l);
        if (!agencyOptional.isPresent()) {
            throw new RuntimeException("Product not found!");
        }
        return agencyOptional.get();
    }

    @Override
    public Agency save(Agency agency) {
        Agency savedAgency = agencyRepository.save(agency);
        return savedAgency;
    }

    @Override
    public void deleteById(Long id) {
        agencyRepository.deleteById(id);
    }





}
