package de.tjjf.Infrastructure.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Airport {

    @Column(nullable = false)
    @Id
    private String code;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String timezone;

    public Airport(){}

    public Airport(String code, String name, String country, String city, String timezone) {
        this.code = code;
        this.name = name;
        this.country = country;
        this.city = city;
        this.timezone = timezone;
    }
}
