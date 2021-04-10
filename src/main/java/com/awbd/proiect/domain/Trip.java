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

    @ManyToMany(
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "purchase",
            joinColumns =@JoinColumn(name="trip_id",referencedColumnName =
                    "id"),
            inverseJoinColumns
                    =@JoinColumn(name="tourist_id",referencedColumnName="id"))
    private List<Tourist> tourists;


}
