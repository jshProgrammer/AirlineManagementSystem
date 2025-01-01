package de.tjjf.Infrastructure.persistence.entities;

import de.tjjf.Domain.models.MFlight;
import jakarta.persistence.*;
import jakarta.persistence.Entity;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "flights")
public class Flight implements Model {
    //TODO: evtl @JoinColumn damit Anzeigen aller Buchungen
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long flightNum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "airplane_id", referencedColumnName = "serialNum")
    private Airplane airplane;

    @Column
    private Date departureDateTime;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departure_airport_id", referencedColumnName = "code")
    private Airport departureAirport;

    @Column
    private Date arrivalDateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "arrival_airport_id", referencedColumnName = "code")
    private Airport arrivalAirport;

    @Column(nullable = false)
    private Date boardingTime;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private int duration;

    @ManyToOne(fetch = FetchType.EAGER)
    //TODO: hier veränderungen vorgenommen für api
    //@JoinColumn(name = "copilot_id", referencedColumnName = "employeeId")
    private Employee pilot;

    @ManyToOne(fetch = FetchType.EAGER)
    //@JoinColumn(name = "copilot_id", referencedColumnName = "employeeId")
    private Employee copilot;




    public Flight(){}


    //TODO: boardingTime has to be DateTime
    public Flight(Airplane airplane, Date departureDateTime, Airport departureAirport, Date arrivalDateTime, Airport arrivalAirport, Date boardingTime, String status, int duration, Employee pilot, Employee copilot) {
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

    public long getFlightNum() {
        return flightNum;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public Date getDepartureDateTime() {
        return departureDateTime;
    }

    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public Date getArrivalDateTime() {
        return arrivalDateTime;
    }

    public Airport getArrivalAirport() {
        return arrivalAirport;
    }

    public Date getBoardingTime() {
        return boardingTime;
    }

    public String getStatus() {
        return status;
    }

    public int getDuration() {
        return duration;
    }

    public Employee getPilot() {
        return pilot;
    }

    public Employee getCopilot() {
        return copilot;
    }

    public void setFlightNum(long flightNum) {
        this.flightNum = flightNum;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public void setDepartureDateTime(Date departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    public void setDepartureAirport(Airport departureAirport) {
        this.departureAirport = departureAirport;
    }

    public void setArrivalDateTime(Date arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }

    public void setArrivalAirport(Airport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public void setBoardingTime(Date boardingTime) {
        this.boardingTime = boardingTime;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setPilot(Employee pilot) {
        this.pilot = pilot;
    }

    public void setCopilot(Employee copilot) {
        this.copilot = copilot;
    }
}
