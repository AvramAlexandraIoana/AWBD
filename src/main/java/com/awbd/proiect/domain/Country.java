package com.awbd.proiect.domain;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String countryName;

    @OneToMany(mappedBy = "country",  cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Location> locationList;


}
