package de.tjjf.Domain.models;

import org.apache.commons.validator.routines.EmailValidator;

import java.util.Date;

public class MAirline implements MModel {
    private String name;

    private Date foundationYear;

    private String headQuarters;
    private MAdress adress;
    private String phoneNumber;
    private String email;

    public MAirline(String name, Date foundationYear, String headQuarters, MAdress adress, String phoneNumber, String email) {
        this.name = name;
        this.foundationYear = foundationYear;
        this.headQuarters = headQuarters;
        this.adress = adress;
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

    public void setFoundationYear(Date foundationYear) {
        this.foundationYear = foundationYear;
    }

    public void setHeadQuarters(String headQuarters) {
        this.headQuarters = headQuarters;
    }

    public MAdress getAdress() {
        return adress;
    }

    public void setAdress(MAdress adress) {
        this.adress = adress;
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
