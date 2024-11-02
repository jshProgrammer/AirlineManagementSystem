package de.tjjf.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;

import java.util.Date;
@Entity
public class Flight {

    enum FlyStatus {
        scheduled,
        in_the_air,
        landed,
        delayed,
        canceled
    }

    @Id
    private long flightNum;

    //TODO: Beziehung hinzufügen
    private long airplane;

    private Date departureDateTime;

    //TODO: Beziehung hinzufügen
    private char departureAirport;

    private Date arrivalDateTime;

    //TODO: Beziehung hinzufügen
    private char arrivalAirport;

    private Date boardingTime;

    private FlyStatus status;

    private int duration;

    //TODO: Beziehung hinzufügen
    private int pilot;

    //TODO: Beziehung hinzufügen
    private int copilot;


    public Flight(){

    }

    public Flight(long flightNum, long airplane, Date departureDateTime, char departureAirport, Date arrivalDateTime, char arrivalAirport, Date boardingTime, FlyStatus status, int duration, int pilot, int copilot) {
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

    public void setAirplane(long airplane) {
        this.airplane = airplane;
    }

    public void setArrivalAirport(char arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public void setArrivalDateTime(Date arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }

    public void setBoardingTime(Date boardingTime) {
        this.boardingTime = boardingTime;
    }

    public void setCopilot(int copilot) {
        this.copilot = copilot;
    }

    public void setDepartureAirport(char departureAirport) {
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

    public void setPilot(int pilot) {
        this.pilot = pilot;
    }

    public void setStatus(FlyStatus status) {
        this.status = status;
    }

    public long getAirplane() {
        return airplane;
    }

    public char getArrivalAirport() {
        return arrivalAirport;
    }

    public Date getArrivalDateTime() {
        return arrivalDateTime;
    }

    public Date getBoardingTime() {
        return boardingTime;
    }

    public int getCopilot() {
        return copilot;
    }

    public char getDepartureAirport() {
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

    public int getPilot() {
        return pilot;
    }

    public FlyStatus getStatus() {
        return status;
    }
}
