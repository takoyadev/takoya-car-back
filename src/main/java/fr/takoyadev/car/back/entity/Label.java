package fr.takoyadev.car.back.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Data
@Entity
public class Label {

    @Id
    private Long id;
    private String value;
    private String color;
    @ManyToMany
    private List<Maintenance> maintenances;

}
