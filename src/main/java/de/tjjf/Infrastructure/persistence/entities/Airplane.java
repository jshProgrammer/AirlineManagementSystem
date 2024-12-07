package de.tjjf.Infrastructure.persistence.entities;

import jakarta.persistence.*;

@Entity
public class Airplane implements Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(nullable=false)
    private int maxWeightOfLuggage;

    public Airplane() {}

    public Airplane(int serialNum, String manufacturer, String model, int amoutOfEconomySeats, int amoutOfBusinessSeats, int amoutOfFirstClassSeats, Airline belongingAirline, boolean isOperatable, int maxWeightOfLuggage) {
        this.serialNum = serialNum;
        this.manufacturer = manufacturer;
        this.model = model;
        this.amoutOfEconomySeats = amoutOfEconomySeats;
        this.amoutOfBusinessSeats = amoutOfBusinessSeats;
        this.amoutOfFirstClassSeats = amoutOfFirstClassSeats;
        this.belongingAirline = belongingAirline;
        this.isOperatable = isOperatable;
        this.maxWeightOfLuggage = maxWeightOfLuggage;
    }

    public int getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(int serialNum) {
        this.serialNum = serialNum;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getAmoutOfEconomySeats() {
        return amoutOfEconomySeats;
    }

    public void setAmoutOfEconomySeats(int amoutOfEconomySeats) {
        this.amoutOfEconomySeats = amoutOfEconomySeats;
    }

    public int getAmoutOfBusinessSeats() {
        return amoutOfBusinessSeats;
    }

    public void setAmoutOfBusinessSeats(int amoutOfBusinessSeats) {
        this.amoutOfBusinessSeats = amoutOfBusinessSeats;
    }

    public int getAmoutOfFirstClassSeats() {
        return amoutOfFirstClassSeats;
    }

    public void setAmoutOfFirstClassSeats(int amoutOfFirstClassSeats) {
        this.amoutOfFirstClassSeats = amoutOfFirstClassSeats;
    }

    public Airline getBelongingAirline() {
        return belongingAirline;
    }

    public void setBelongingAirline(Airline belongingAirline) {
        this.belongingAirline = belongingAirline;
    }

    public boolean isOperatable() {
        return isOperatable;
    }

    public void setOperatable(boolean operatable) {
        isOperatable = operatable;
    }

    public int getMaxWeightOfLuggage() {return maxWeightOfLuggage;}

    public void setMaxWeightOfLuggage(int maxWeightOfLuggage) {}
}
