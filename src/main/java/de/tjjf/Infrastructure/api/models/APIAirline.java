package de.tjjf.Infrastructure.api.models;

import org.apache.commons.validator.routines.EmailValidator;

import java.util.Date;

public class APIAirline implements APIModel {

    private String name;

    private Date foundationYear;

    private APIAddress address;

    private String phoneNumber;

    private String email;


    public APIAirline(){}


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

    public Date getFoundationYear() {
        return foundationYear;
    }

    public void setFoundationYear(Date foundationYear) {
        this.foundationYear = foundationYear;
    }
}
