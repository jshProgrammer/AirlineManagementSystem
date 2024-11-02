package de.tjjf.models;

import jakarta.persistence.*;

import java.util.Date;
@Entity
public class Airplane {
    @Id
    private int serialNum;

    @Column(nullable=false)
    private String manufacturer;

    @Column(nullable=false)
    private String model;

    @Column(nullable=false)
    private int amoutOfEconomySeats;

    @Column(nullable=false)
    private int amoutOfBusinessSeats;

    @Column(nullable=false)
    private int amoutOfFirstClassSeats;

    @ManyToOne()
    private Airline belongingAirline;

    @Column(nullable=false)
    private boolean isOperatable;

    public Airplane() {}

    public Airplane(int serialNum, String manufacturer, String model, int amoutOfEconomySeats, int amoutOfBusinessSeats, int amoutOfFirstClassSeats, Airline belongingAirline, boolean isOperatable) {
        this.serialNum = serialNum;
        this.manufacturer = manufacturer;
        this.model = model;
        this.amoutOfEconomySeats = amoutOfEconomySeats;
        this.amoutOfBusinessSeats = amoutOfBusinessSeats;
        this.amoutOfFirstClassSeats = amoutOfFirstClassSeats;
        this.belongingAirline = belongingAirline;
        this.isOperatable = isOperatable;
    }

    public int getAmoutOfEconomySeats() {
        return amoutOfEconomySeats;
    }

    public int getAmoutOfBusinessSeats() {
        return amoutOfBusinessSeats;
    }

    public int getAmoutOfFirstClassSeats() {
        return amoutOfFirstClassSeats;
    }

    public Airline getBelongingAirline() {
        return belongingAirline;
    }

    public boolean isOperatable() {
        return isOperatable;
    }

    public void setAmoutOfEconomySeats(int amoutOfEconomySeats) {
        this.amoutOfEconomySeats = amoutOfEconomySeats;
    }

    public void setAmoutOfBusinessSeats(int amoutOfBusinessSeats) {
        this.amoutOfBusinessSeats = amoutOfBusinessSeats;
    }

    public void setAmoutOfFirstClassSeats(int amoutOfFirstClassSeats) {
        this.amoutOfFirstClassSeats = amoutOfFirstClassSeats;
    }

    public void setBelongingAirline(Airline belongingAirline) {
        this.belongingAirline = belongingAirline;
    }

    public void setOperatable(boolean operatable) {
        isOperatable = operatable;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setSerialNum(int serialNum) {
        this.serialNum = serialNum;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public int getSerialNum() {
        return serialNum;
    }
}
