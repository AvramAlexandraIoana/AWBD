package com.awbd.proiect.services;

import com.awbd.proiect.domain.Agency;

import java.util.List;

public interface AgencyService {
    List<Agency> findAll();
    Agency findById(Long l);
    Agency save(Agency agency);
    void deleteById(Long id);

}
