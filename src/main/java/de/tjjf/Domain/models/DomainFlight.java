package de.tjjf.Domain.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DomainFlight implements DomainModel {

    public enum FlightStatus { scheduled, in_the_air, landed, delayed, canceled }

    private final long flightNum;

    private DomainAirplane airplane;

    private Date departureDateTime;

    private DomainAirport departureAirport;

    private Date arrivalDateTime;

    private DomainAirport arrivalAirport;

    private Date boardingTime;

    private FlightStatus status;

    private int duration;

    List<DomainTicket> tickets = new ArrayList<>();

    private DomainEmployee pilot;

    private DomainEmployee copilot;

    private int currentInitialLuggageWeight = 0;

    private int currentUpgradeLuggageWeight = 0;

    public DomainFlight(long flightNum, DomainAirplane airplane, Date departureDateTime, DomainAirport departureAirport, Date arrivalDateTime, DomainAirport arrivalAirport, Date boardingTime, FlightStatus status, int duration, DomainEmployee pilot, DomainEmployee copilot) {
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


    public void addCurrentInitialLuggageWeight(int currentInitialLuggageWeight) {
        if(currentInitialLuggageWeight > 0){
            this.currentInitialLuggageWeight += currentInitialLuggageWeight;
        } else{
            throw new IllegalArgumentException("Please enter a positive number, negative ones are prohibited");
        }
    }

    public void addCurrentUpgradeLuggageWeight(int currentUpgradeLuggageWeight) {
        if(currentUpgradeLuggageWeight > 0){
            this.currentUpgradeLuggageWeight += currentUpgradeLuggageWeight;
        }else{
            throw new IllegalArgumentException("Please enter a positive number, negative ones are prohibited");
        }
    }

    public void addTicket(DomainTicket ticket) {
        tickets.add(ticket);
    }

    public void setAirplane(DomainAirplane airplane) {
        this.airplane = airplane;
    }

    public void setArrivalAirport(DomainAirport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public void setArrivalDateTime(Date arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }

    public void setBoardingTime(Date boardingTime) {
        this.boardingTime = boardingTime;
    }

    public void setCopilot(DomainEmployee copilot) {
        this.copilot = copilot;
    }

    public void setDepartureAirport(DomainAirport departureAirport) {
        this.departureAirport = departureAirport;
    }

    public void setDepartureDateTime(Date departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setPilot(DomainEmployee pilot) {
        this.pilot = pilot;
    }

    public void setStatus(FlightStatus status) {
        this.status = status;
    }

    public DomainAirplane getAirplane() {
        return airplane;
    }

    public DomainAirport getArrivalAirport() {
        return arrivalAirport;
    }

    public int getCurrentUpgradeLuggageWeight() { return currentUpgradeLuggageWeight; }

    public Date getArrivalDateTime() {
        return arrivalDateTime;
    }

    public Date getBoardingTime() {
        return boardingTime;
    }

    public DomainEmployee getCopilot() {
        return copilot;
    }

    public DomainAirport getDepartureAirport() {
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

    public DomainEmployee getPilot() {
        return pilot;
    }

    public FlightStatus getStatus() {
        return status;
    }

    public List<DomainTicket> getTickets() {
        return tickets;
    }

    public int getCurrentInitialLuggageWeight() { return currentInitialLuggageWeight;  }
}
