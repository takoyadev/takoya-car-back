package fr.takoyadev.car.server.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
public class Owner {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Getter
    @Column(length = 30, nullable = false)
    private String nom;

    @Getter
    @Column(length = 30, nullable = false)
    private String prenom;

}
