package fr.takoyadev.car.back.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Data
@Entity
public class Owner {

    @Id
    private Long id;
    private String lastName;
    private String firstName;
    @OneToMany
    private List<Car> cars;
    @OneToOne
    private User user;

}
