package fr.takoyadev.car.server.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Entretien {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Getter
    @Column(nullable = false)
    private Date date;

    @Getter
    @Column(nullable = false)
    private String libelle;

    @Getter
    @OneToOne
    private Car car;
}
