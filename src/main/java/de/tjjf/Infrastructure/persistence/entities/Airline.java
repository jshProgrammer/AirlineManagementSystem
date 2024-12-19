package de.tjjf.Infrastructure.persistence.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Airline implements Model {
    @Id
    @Column(nullable=false)
    private String name;

    @Column(nullable=false)
    private Date foundationYear;

    @Column(nullable=false)
    private String headQuarters;

    @Column(nullable=false)
    private String mail;

    @Column(nullable=false)
    private String phoneNumber;

    @Column(nullable=false)
    private String address;

    @OneToMany(mappedBy = "belongingAirline", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Airplane> airplanes = new ArrayList<>();

    //TODO: sollen wir hier mit OneToMany auch die Flugzeuge speichern => eig wird das ja selten abgerufen

    public Airline() {}

    public Airline(String name, Date foundationYear, String headQuarters, String mail, String phoneNumber, String address) {
        this.name = name;
        this.foundationYear = foundationYear;
        this.headQuarters = headQuarters;
        this.mail = mail;
        this.phoneNumber=phoneNumber;
        this.address=address;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
