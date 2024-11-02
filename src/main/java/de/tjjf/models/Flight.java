package de.tjjf.models;

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

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public void setArrivalAirport(Airport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public void setArrivalDateTime(Date arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }

    public void setBoardingTime(Date boardingTime) {
        this.boardingTime = boardingTime;
    }

    public void setCopilot(Employee copilot) {
        this.copilot = copilot;
    }

    public void setDepartureAirport(Airport departureAirport) {
        this.departureAirport = departureAirport;
    }

    public void setDepartureDateTime(Date departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setFlightNum(long flightNum) {
        this.flightNum = flightNum;
    }

    public void setPilot(Employee pilot) {
        this.pilot = pilot;
    }

    public void setStatus(FlyStatus status) {
        this.status = status;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public Airport getArrivalAirport() {
        return arrivalAirport;
    }

    public Date getArrivalDateTime() {
        return arrivalDateTime;
    }

    public Date getBoardingTime() {
        return boardingTime;
    }

    public Employee getCopilot() {
        return copilot;
    }

    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public Date getDepartureDateTime() {
        return departureDateTime;
    }

    public int getDuration() {
        return duration;
    }

    public long getFlightNum() {
        return flightNum;
    }

    public Employee getPilot() {
        return pilot;
    }

    public FlyStatus getStatus() {
        return status;
    }
}
