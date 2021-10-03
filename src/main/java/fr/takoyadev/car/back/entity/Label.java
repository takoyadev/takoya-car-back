package fr.takoyadev.car.back.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Label {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String value;
    private String color;
    @ManyToMany
    private List<Maintenance> maintenances;

}
