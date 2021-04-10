package com.awbd.proiect.repositories;

import com.awbd.proiect.domain.Location;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LocationRepository extends PagingAndSortingRepository<Location, Long> {
    @Query("select l from Location l where l.country.id = ?1")
    List<Location> findByCountry(Long countryId);

    @Query("select l from Location l where l.country.countryName = :city")
    List<Location> findByCountryName(@Param("countryName") String countryName);

}
