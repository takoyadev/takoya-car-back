package fr.takoyadev.car.server.entity;

import fr.takoyadev.car.server.enums.Status;
import lombok.Getter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Entity
public class Entretien {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private String libelle;

    @Column(nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @OneToOne
    private Car car;
}
