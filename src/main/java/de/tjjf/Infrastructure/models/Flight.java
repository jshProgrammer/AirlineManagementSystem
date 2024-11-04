package de.tjjf.Infrastructure.models;

import jakarta.persistence.*;

import java.util.Date;
@Entity
public class Flight {

    public enum FlyStatus {
        scheduled,
        in_the_air,
        landed,
        delayed,
        canceled
    }

    //TODO: evtl @JoinColumn damit Anzeigen aller Buchungen
    @Column(nullable = false)
    @Id
    private long flightNum;


    @ManyToOne()
    private Airplane airplane;

    private Date departureDateTime;

    @OneToOne
    private Airport departureAirport;

    private Date arrivalDateTime;

    @OneToOne
    private Airport arrivalAirport;

    @Column(nullable = false)
    private Date boardingTime;

    @Column(nullable = false)
    private FlyStatus status;

    @Column(nullable = false)
    private int duration;

    //TODO: evtl ManyToOne-Beziehung?
    @OneToOne()
    private Employee pilot;

    @OneToOne()
    private Employee copilot;


    public Flight(){}

    public Flight(long flightNum, Airplane airplane, Date departureDateTime, Airport departureAirport, Date arrivalDateTime, Airport arrivalAirport, Date boardingTime, FlyStatus status, int duration, Employee pilot, Employee copilot) {
        this.flightNum = flightNum;
        this.airplane = airplane;
        this.departureDateTime = departureDateTime;
        this.departureAirport = departureAirport;
        this.arrivalDateTime = arrivalDateTime;
        this.arrivalAirport = arrivalAirport;
        this.boardingTime = boardingTime;
        this.status = status;
        this.duration = duration;
        this.pilot = pilot;
        this.copilot = copilot;
    }
}
