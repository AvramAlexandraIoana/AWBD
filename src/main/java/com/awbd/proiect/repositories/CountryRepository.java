package com.awbd.proiect.repositories;

import domain.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository  extends CrudRepository<Country, Long> {
}
