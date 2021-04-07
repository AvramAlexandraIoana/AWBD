package domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Info {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Byte[] image;
    private String description;

    @OneToOne
    private Location location;
}
