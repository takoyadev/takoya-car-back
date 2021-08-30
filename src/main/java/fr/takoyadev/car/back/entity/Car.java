package fr.takoyadev.car.back.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Car {

    @Id
    private Long id;
    private String brand;
    private String owner;

}
