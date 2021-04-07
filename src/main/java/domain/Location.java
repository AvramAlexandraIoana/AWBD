package domain;

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
    private Country country;


    @OneToMany(mappedBy = "location")
    private List<Agency> agencyList;

    @OneToOne
    private Info info;

}
