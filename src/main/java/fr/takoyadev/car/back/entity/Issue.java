package fr.takoyadev.car.back.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Issue {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date date;
    private String title;
    private String description;
    private String status;
    @ManyToOne
    private Car car;
    @ManyToMany
    private List<Maintenance> maintenances;
    
}
