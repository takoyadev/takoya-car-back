package fr.takoyadev.car.back.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String login;
    private String password;
    private String email;
    @OneToOne
    private Owner owner;
    @ManyToMany
    private List<Role> roles;

}
