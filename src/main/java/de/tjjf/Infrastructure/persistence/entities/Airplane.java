package de.tjjf.Infrastructure.persistence.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Airplane implements Model {
    @Id
    @Column(nullable=false)
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

    @ManyToOne
    @JoinColumn(name = "airline_id")
    private Airline belongingAirline;

    @Column(nullable=false)
    private boolean isOperatable;

    @Column(nullable=false)
    private int maxWeightOfLuggage;

    @OneToMany(mappedBy = "airplane")
    private List<Flight> flights;

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

    public int getAmountOfEconomySeats() {
        return amoutOfEconomySeats;
    }

    public void setAmoutOfEconomySeats(int amoutOfEconomySeats) {
        this.amoutOfEconomySeats = amoutOfEconomySeats;
    }

    public int getAmountOfBusinessSeats() {
        return amoutOfBusinessSeats;
    }

    public void setAmoutOfBusinessSeats(int amoutOfBusinessSeats) {
        this.amoutOfBusinessSeats = amoutOfBusinessSeats;
    }

    public int getAmountOfFirstClassSeats() {
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

    public boolean isOperable() {
        return isOperatable;
    }

    public void setOperable(boolean operable) {
        isOperatable = operable;
    }

    public int getMaxWeightOfLuggage() {return maxWeightOfLuggage;}

    public void setMaxWeightOfLuggage(int maxWeightOfLuggage) {}
}
