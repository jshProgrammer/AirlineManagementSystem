package de.tjjf.Domain.models;

import java.util.Date;

public class MAirline implements MModel {
    private String name;

    private Date foundationYear;

    private String headQuarters;
    private MAdress adress;
    private int phoneNumber;
    private String eMail;

    public MAirline(String name, Date foundationYear, String headQuarters, MAdress adress, int phoneNumber, String eMail) {
        this.name = name;
        this.foundationYear = foundationYear;
        this.headQuarters = headQuarters;
        this.adress = adress;
        this.phoneNumber=phoneNumber;
        this.eMail=eMail;
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

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
}
