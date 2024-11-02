package de.tjjf.models;

import jakarta.persistence.Id;

import java.util.Date;

public class Flight {
    @Id
    private long flightNum;

    private long airplane;

    private Date departureDateTime;

    private char departureAirport;

    private Date arrivalDateTime;

    private char arrivalAirport;

    private Date boardingTime;

    private FlyStatus status;

    private int duration;

    private personId pilot;

    private personId copilot;


    public Flight(){

    }
    public Flight( String firstName, String lastName )
    {
        this.firstName = firstName;
        this.lastName = lastName;
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

    public void setCopilot(personId copilot) {
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

    public void setPilot(personId pilot) {
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

    public personId getCopilot() {
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

    public personId getPilot() {
        return pilot;
    }

    public FlyStatus getStatus() {
        return status;
    }
}
