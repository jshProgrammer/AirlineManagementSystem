package de.tjjf.Domain.models;

import org.apache.commons.validator.routines.EmailValidator;

import java.util.Date;

public class DomainAirline implements DomainModel {

    private String name;

    private final Date foundationYear;

    private String headQuarters;

    private DomainAddress address;

    private String phoneNumber;

    private String email;

    public DomainAirline(String name, Date foundationYear, String headQuarters, DomainAddress address, String phoneNumber, String email) {
        this.name = name;
        this.foundationYear = foundationYear;
        this.headQuarters = headQuarters;
        this.address = address;
        this.phoneNumber=phoneNumber;

        EmailValidator validator = EmailValidator.getInstance();
        boolean isValid = validator.isValid(email);
        if(!isValid) throw new IllegalArgumentException("Email is not a valid email");

        this.email =email;
    }

    public String getName() {
        return name;
    }

    public Date getFoundationYear() {
        return foundationYear;
    }

    public String getHeadQuarters() {
        return headQuarters;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHeadQuarters(String headQuarters) {
        this.headQuarters = headQuarters;
    }

    public DomainAddress getAddress() {
        return address;
    }

    public void setAddress(DomainAddress address) {
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
}
