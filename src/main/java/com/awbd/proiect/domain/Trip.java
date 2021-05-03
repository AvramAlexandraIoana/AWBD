package com.awbd.proiect.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private int numberOfSpots;

    @ManyToOne
    @JoinColumn(name="agency_id")
    private Agency agency;


    @ManyToOne
    @JoinColumn(name="location_id")
    private Location location;

    @ManyToMany(mappedBy = "trips",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<User> users;


}
