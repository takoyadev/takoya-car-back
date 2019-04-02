package fr.takoyadev.car.server.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
public class Car {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Getter
    @Column(length = 50, nullable = false)
    private String marque;

    @Getter
    @Column(length = 50, nullable = false)
    private String modele;

}
