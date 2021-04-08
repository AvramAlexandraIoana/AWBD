package domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
public class Agency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @OneToMany(mappedBy = "agency", cascade = CascadeType.ALL)
    private List<Trip> tripList;

}
