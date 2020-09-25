package fr.takoyadev.car.server.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 30, nullable = false)
    private String nom;

    @Column(length = 30, nullable = false)
    private String prenom;

}
