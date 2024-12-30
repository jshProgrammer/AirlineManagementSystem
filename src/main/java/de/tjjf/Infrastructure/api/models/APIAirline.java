package de.tjjf.Infrastructure.api.models;

import org.apache.commons.validator.routines.EmailValidator;

import java.util.Date;

public class APIAirline implements APIModel {

    public String name;

    public String foundationYear;

    public APIAddress address;

    public String phoneNumber;

    public String email;


    public APIAirline(){}

    public APIAirline(String name, String foundationYear, APIAddress address, String phoneNumber, String email) {
        this.name = name;
        this.foundationYear = foundationYear;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public APIAddress getAddress() {
        return address;
    }

    public void setAddress(APIAddress address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFoundationYear() {
        return foundationYear;
    }

    public void setFoundationYear(String foundationYear) {
        this.foundationYear = foundationYear;
    }
}
