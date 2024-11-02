package de.tjjf.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Airport {
    @Id
    private char code;

    private char name;

    private char country;

    private char city;

    private char timezone;

    public Airport(){

    }

    public void setCity(char city) {
        this.city = city;
    }

    public void setCode(char code) {
        this.code = code;
    }

    public void setCountry(char country) {
        this.country = country;
    }

    public void setName(char name) {
        this.name = name;
    }

    public void setTimezone(char timezone) {
        this.timezone = timezone;
    }

    public char getCity() {
        return city;
    }

    public char getCode() {
        return code;
    }

    public char getCountry() {
        return country;
    }

    public char getName() {
        return name;
    }

    public char getTimezone() {
        return timezone;
    }
}
