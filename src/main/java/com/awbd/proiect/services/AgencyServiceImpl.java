package com.awbd.proiect.services;

import com.awbd.proiect.domain.Agency;
import com.awbd.proiect.domain.Location;
import com.awbd.proiect.repositories.AgencyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class AgencyServiceImpl implements AgencyService {
    private final Logger log = LoggerFactory.getLogger(AgencyServiceImpl.class);

    AgencyRepository agencyRepository;
    @Autowired
    public AgencyServiceImpl(AgencyRepository agencyRepository) {
        this.agencyRepository = agencyRepository;
    }

    @Override
    public List<Agency> findAll(){
        List<Agency> agencyList = new LinkedList<>();
        agencyRepository.findAll().iterator().forEachRemaining(agencyList::add);
        log.info("Find all ...", agencyList);
        return agencyList;
    }

    @Override
    public Agency findById(Long l) {
        Optional<Agency> agencyOptional =
                agencyRepository.findById(l);
        if (!agencyOptional.isPresent()) {
            throw new RuntimeException("Agency not found!");
        }
        log.info("Find by id ...", agencyOptional.get());
        return agencyOptional.get();
    }

    @Override
    public Agency save(Agency agency) {
        Agency savedAgency = agencyRepository.save(agency);
        log.info("Saved agency ...", savedAgency);
        return savedAgency;
    }

    @Override
    public
    Agency update(Agency agency) {
        Optional<Agency> agencyOptional =
                agencyRepository.findById(agency.getId());
        if (!agencyOptional.isPresent()) {
            throw new RuntimeException("Agency not found!");
        }
        Agency updateAgency = agencyRepository.save(agency);
        log.info("Update agency ...", updateAgency);
        return updateAgency;
    }

    @Override
    public void deleteById(Long id) {
        log.info("Delete by id ", id);
        agencyRepository.deleteById(id);
    }





}
