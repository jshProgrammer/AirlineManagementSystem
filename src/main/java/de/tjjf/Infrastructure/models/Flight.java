package de.tjjf.Infrastructure.models;

import jakarta.persistence.*;

import java.util.Date;
@Entity
public class Flight implements Model {

    public enum FlyStatus {
        scheduled,
        in_the_air,
        landed,
        delayed,
        canceled
    }

    //TODO: evtl @JoinColumn damit Anzeigen aller Buchungen
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

    public FlyStatus getStatus() {
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

    public void setStatus(FlyStatus status) {
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
