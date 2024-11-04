package de.tjjf.Infrastructure.models;

import jakarta.persistence.*;

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
}
