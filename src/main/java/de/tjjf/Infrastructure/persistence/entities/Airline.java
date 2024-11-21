package de.tjjf.Infrastructure.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;
@Entity
public class Airline implements Model {
    @Id
    private String name;

    private Date foundationYear;

    private String headQuarters;
    private String eMail;
    private String phoneNumber;
    private String adress;

    //TODO: sollen wir hier mit OneToMany auch die Flugzeuge speichern => eig wird das ja selten abgerufen

    public Airline() {}

    public Airline(String name, Date foundationYear, String headQuarters, String eMail, String phoneNumber, String adress) {
        this.name = name;
        this.foundationYear = foundationYear;
        this.headQuarters = headQuarters;
        this.eMail=eMail;
        this.phoneNumber=phoneNumber;
        this.adress=adress;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
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
}
