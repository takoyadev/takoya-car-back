package fr.takoyadev.car.back.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String licensePlate;
    private String brand;
    private String model;
    private String status;
    @ManyToOne
    private Owner owner;
    @OneToMany
    private List<Maintenance> maintenances;
    @ManyToMany
    private List<Issue> issues;

}
