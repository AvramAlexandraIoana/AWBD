package com.awbd.proiect;

import domain.Agency;
import domain.Location;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import java.util.Arrays;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace =
        AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("mysql")
@Rollback(false)
public class CascadeTypesTest {
    @Autowired
    private EntityManager entityManager;

    @Ignore
    @Test
    public void saveLocation() {
        Location location = new Location();
        location.setCity("Bucuresti");
        location.setStreetAddress("Stefan Cel Mare");

        Agency agency = new Agency();
        agency.setName("Tarom");
        agency.setLocation(location);

        location.setAgencyList(Arrays.asList(agency));
        entityManager.persist(location);
        entityManager.flush();
        entityManager.clear();
    }

    @Test
    public void updateLocation(){
        Agency agency = entityManager.find(Agency.class, 2L);
        Location location = agency.getLocation();
        location.setCity("Craiova");
        location.getAgencyList().forEach(agency1 ->
        {
            agency1.setName("Agentie Craiova");
        });
        entityManager.merge(location);
        entityManager.flush();
    }

    @Test
    public void orphanRemoval(){
        Location location = entityManager.find(Location.class, 1L);
        location.setInfo(null);
        entityManager.persist(location);
        entityManager.flush();
    }

    @ParameterizedTest
    @ValueSource(longs = {1, 2})
    public void orphanRemoval(long id){
        Location location = entityManager.find(Location.class, 1L);
        location.setInfo(null);
        entityManager.persist(location);
        entityManager.flush();
    }


}