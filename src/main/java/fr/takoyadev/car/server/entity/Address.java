package fr.takoyadev.car.server.entity;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 50, nullable = false)
    private String line1;

    @Column(length = 50, nullable = false)
    private String line2;

    @Column(length = 50, nullable = false)
    private String zipCode;

    @Column(length = 50, nullable = false)
    private String city;

    @Column(length = 50, nullable = false)
    private String country;

}
