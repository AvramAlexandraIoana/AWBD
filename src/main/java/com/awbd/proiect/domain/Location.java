package com.awbd.proiect.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String streetAddress;
    private String city;

    @ManyToOne
    @JoinColumn(name = "country_id")
    @JsonBackReference
    private Country country;


    @OneToMany(mappedBy = "location",  cascade = CascadeType.ALL)
    private List<Agency> agencyList;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Info info;

}
