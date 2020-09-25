package fr.takoyadev.car.server.entity;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 50, nullable = false)
    private String marque;

    @Column(length = 50, nullable = false)
    private String modele;

    @OneToOne
    private Owner owner;

}
