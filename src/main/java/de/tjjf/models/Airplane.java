package de.tjjf.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;
@Entity
public class Airplane {
    @Id
    private int serialNum;

    private char manufacturer;

    private char model;

    private int amountOfSeats;

    private Date dateOfLastMaintenace;

    private int flightHours;

    public Airplane() {

    }

    public void setAmountOfSeats(int amountOfSeats) {
        this.amountOfSeats = amountOfSeats;
    }

    public void setDateOfLastMaintenace(Date dateOfLastMaintenace) {
        this.dateOfLastMaintenace = dateOfLastMaintenace;
    }

    public void setFlightHours(int flightHours) {
        this.flightHours = flightHours;
    }

    public void setManufacturer(char manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setModel(char model) {
        this.model = model;
    }

    public void setSerialNum(int serialNum) {
        this.serialNum = serialNum;
    }

    public int getAmountOfSeats() {
        return amountOfSeats;
    }

    public Date getDateOfLastMaintenace() {
        return dateOfLastMaintenace;
    }

    public int getFlightHours() {
        return flightHours;
    }

    public char getManufacturer() {
        return manufacturer;
    }

    public char getModel() {
        return model;
    }

    public int getSerialNum() {
        return serialNum;
    }
}
