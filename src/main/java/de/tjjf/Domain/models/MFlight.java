package de.tjjf.Domain.models;

import java.util.Date;
public class MFlight implements MModel {

    public enum FlyStatus {
        scheduled,
        in_the_air,
        landed,
        delayed,
        canceled
    }

    private long flightNum;

    private MAirplane airplane;

    private Date departureDateTime;

    private MAirport departureAirport;

    private Date arrivalDateTime;

    private MAirport arrivalAirport;

    private Date boardingTime;

    private FlyStatus status;

    private int duration;

    MBooking[] bookings;

    private MEmployee pilot;

    private MEmployee copilot;

    private int currentInitialLuggageWeight = 0;

    private int currentUpgradeLuggageWeight = 0;

    public MFlight(long flightNum, MAirplane airplane, Date departureDateTime, MAirport departureAirport, Date arrivalDateTime, MAirport arrivalAirport, Date boardingTime, FlyStatus status, int duration, MEmployee pilot, MEmployee copilot) {
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
        this.bookings = new MBooking[airplane.getAmountOfBusinessSeats() + airplane.getAmountOfEconomySeats() + airplane.getAmountOfFirstClassSeats()];

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

    public void setFlightNum(long flightNum) {
        this.flightNum = flightNum;
    }

    public void setPilot(MEmployee pilot) {
        this.pilot = pilot;
    }

    public void setStatus(FlyStatus status) {
        this.status = status;
    }

    public MAirplane getAirplane() {
        return airplane;
    }

    public MAirport getArrivalAirport() {
        return arrivalAirport;
    }

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

    public FlyStatus getStatus() {
        return status;
    }

    public MBooking[] getBookings() {
        return bookings;
    }

    public int getCurrentInitialLuggageWeight() { return currentInitialLuggageWeight;  }

    public void addCurrentInitialLuggageWeight(int currentInitialLuggageWeight) {
        if(currentInitialLuggageWeight > 0){
            this.currentInitialLuggageWeight += currentInitialLuggageWeight;
        }else{
            //Rather boolean or exceptions?
            throw new IllegalArgumentException("Please enter a positive number, negative ones are prohibited");
        }
    }

    public int getCurrentUpgradeLuggageWeight() { return currentUpgradeLuggageWeight; }

    public void addCurrentUpgradeLuggageWeight(int currentUpgradeLuggageWeight) {
        if(currentUpgradeLuggageWeight > 0){
            this.currentUpgradeLuggageWeight += currentUpgradeLuggageWeight;
        }else{
            //Rather boolean or exceptions?
            throw new IllegalArgumentException("Please enter a positive number, negative ones are prohibited");
        }
    }


    public void addBooking(MBooking newBooking) {
       for(int i=0; i<bookings.length; i++) {
           if(bookings[i] == null) {
               bookings[i] = newBooking;
               break;
           }
       }
    }
}
