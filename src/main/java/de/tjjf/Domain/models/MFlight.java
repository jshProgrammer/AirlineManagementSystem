package de.tjjf.Domain.models;

import de.tjjf.Domain.EmailSender;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MFlight implements MModel {

    public enum FlightStatus { scheduled, in_the_air, landed, delayed, canceled }

    private final long flightNum;

    private MAirplane airplane;

    private Date departureDateTime;

    private MAirport departureAirport;

    private Date arrivalDateTime;

    private MAirport arrivalAirport;

    private Date boardingTime;

    private FlightStatus status;

    private int duration;

    List<MTicket> tickets = new ArrayList<>();

    private MEmployee pilot;

    private MEmployee copilot;

    private int currentInitialLuggageWeight = 0;

    private int currentUpgradeLuggageWeight = 0;

    public MFlight(long flightNum, MAirplane airplane, Date departureDateTime, MAirport departureAirport, Date arrivalDateTime, MAirport arrivalAirport, Date boardingTime, FlightStatus status, int duration, MEmployee pilot, MEmployee copilot) {
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


    public boolean addBooking(MTicket newBooking) {
        boolean bookable = false;
        if(tickets.size() < this.airplane.getTotalNumberOfSeats()){
            bookable = true;
            tickets.add(newBooking);
            EmailSender.sendInvoice(newBooking);
        }

        return bookable;
    }

    public void cancelFlight(){
        this.status = FlightStatus.canceled;
        EmailSender.sendCancelationMail(this);
    }


    //TODO
    public List<MFlight> showAlternativeFlights(int flightNum) {
        List<MFlight> alternativeFlights = new ArrayList<>();

        // Flight originalFlight = ;

        //TODO: hier müsste ich ja auf Datenbank zugreifen?!
        List<MFlight> allFlights = new ArrayList<>();

        // search for flights that have the same destination and departure
        for(MFlight alternativeFlight : allFlights) {

        }

        return  alternativeFlights;
    }

    public void setAirplane(MAirplane airplane) {
        this.airplane = airplane;
    }

    public void setArrivalAirport(MAirport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public void setArrivalDateTime(Date arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }

    public void setBoardingTime(Date boardingTime) {
        this.boardingTime = boardingTime;
    }

    public void setCopilot(MEmployee copilot) {
        this.copilot = copilot;
    }

    public void setDepartureAirport(MAirport departureAirport) {
        this.departureAirport = departureAirport;
    }

    public void setDepartureDateTime(Date departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setPilot(MEmployee pilot) {
        this.pilot = pilot;
    }

    public void setStatus(FlightStatus status) {
        this.status = status;
    }

    public MAirplane getAirplane() {
        return airplane;
    }

    public MAirport getArrivalAirport() {
        return arrivalAirport;
    }

    public int getCurrentUpgradeLuggageWeight() { return currentUpgradeLuggageWeight; }

    public Date getArrivalDateTime() {
        return arrivalDateTime;
    }

    public Date getBoardingTime() {
        return boardingTime;
    }

    public MEmployee getCopilot() {
        return copilot;
    }

    public MAirport getDepartureAirport() {
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

    public MEmployee getPilot() {
        return pilot;
    }

    public FlightStatus getStatus() {
        return status;
    }

    public List<MTicket> getTickets() {
        return tickets;
    }

    public int getCurrentInitialLuggageWeight() { return currentInitialLuggageWeight;  }
}
