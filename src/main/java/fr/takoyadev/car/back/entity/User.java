package fr.takoyadev.car.back.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@Entity
public class User {

    @Id
    private Long id;
    private String login;
    private String password;
    private String email;
    @OneToOne
    private Owner owner;

}
