package de.tjjf.Infrastructure.api.InputModels;

import java.util.Date;

public class APIFlightInput implements APIModelInput {
    public APIFlightInput(long flightNum, int airplaneSerialNum, Date departureDateTime, String departureAirportCode, Date arrivalDateTime, String arrivalAirportCode, Date boardingTime, FlightStatus status, int duration, long pilotId, long copilotId) {
        this.flightNum = flightNum;
        this.airplaneSerialNum = airplaneSerialNum;
        this.departureDateTime = departureDateTime;
        this.departureAirportCode = departureAirportCode;
        this.arrivalDateTime = arrivalDateTime;
        this.arrivalAirportCode = arrivalAirportCode;
        this.boardingTime = boardingTime;
        this.status = status;
        this.duration = duration;
        this.pilotId = pilotId;
        this.copilotId = copilotId;
    }

    public enum FlightStatus { scheduled, in_the_air, landed, delayed, canceled }

    private long flightNum;

    private int airplaneSerialNum;

    private Date departureDateTime;

    private String departureAirportCode;

    private Date arrivalDateTime;

    private String arrivalAirportCode;

    private Date boardingTime;

    private FlightStatus status;

    private int duration;

    private long pilotId;

    private long copilotId;

    public long getFlightNum() {
        return flightNum;
    }

    public void setFlightNum(long flightNum) {
        this.flightNum = flightNum;
    }

    public int getAirplaneSerialNum() {
        return airplaneSerialNum;
    }

    public void setAirplaneSerialNum(int airplaneSerialNum) {
        this.airplaneSerialNum = airplaneSerialNum;
    }

    public Date getDepartureDateTime() {
        return departureDateTime;
    }

    public void setDepartureDateTime(Date departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    public String getDepartureAirport() {
        return departureAirportCode;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirportCode = departureAirport;
    }

    public Date getArrivalDateTime() {
        return arrivalDateTime;
    }

    public void setArrivalDateTime(Date arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }

    public String getArrivalAirport() {
        return arrivalAirportCode;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirportCode = arrivalAirport;
    }

    public Date getBoardingTime() {
        return boardingTime;
    }

    public void setBoardingTime(Date boardingTime) {
        this.boardingTime = boardingTime;
    }

    public FlightStatus getStatus() {
        return status;
    }

    public void setStatus(FlightStatus status) {
        this.status = status;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public long getPilot() {
        return pilotId;
    }

    public void setPilot(long pilot) {
        this.pilotId = pilot;
    }

    public long getCopilot() {
        return copilotId;
    }

    public void setCopilot(long copilot) {
        this.copilotId = copilot;
    }
}
