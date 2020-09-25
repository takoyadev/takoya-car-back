package fr.takoyadev.car.server.entity;

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

    @OneToOne
    private Car car;
}
