package de.tjjf.Infrastructure.api.InputModels;

public class APIFlightInput implements APIModelInput {

    public APIFlightInput() {}

    public APIFlightInput(int airplaneSerialNum, String departureDateTime, String departureAirportCode, String arrivalDateTime, String arrivalAirportCode, String boardingTime, FlightStatus status, int duration, long pilotId, long copilotId) {
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

    private int airplaneSerialNum;

    private String departureDateTime;

    private String departureAirportCode;

    private String arrivalDateTime;

    private String arrivalAirportCode;

    private String boardingTime;

    private FlightStatus status;

    private int duration;

    private long pilotId;

    private long copilotId;

    public int getAirplaneSerialNum() {
        return airplaneSerialNum;
    }

    public void setAirplaneSerialNum(int airplaneSerialNum) {
        this.airplaneSerialNum = airplaneSerialNum;
    }

    public String getDepartureDateTime() {
        return departureDateTime;
    }

    public void setDepartureDateTime(String departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    public String getDepartureAirportCode() {
        return departureAirportCode;
    }

    public void setDepartureAirportCode(String departureAirport) {
        this.departureAirportCode = departureAirport;
    }

    public String getArrivalDateTime() {
        return arrivalDateTime;
    }

    public void setArrivalDateTime(String arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }

    public String getArrivalAirportCode() {
        return arrivalAirportCode;
    }

    public void setArrivalAirportCode(String arrivalAirport) {
        this.arrivalAirportCode = arrivalAirport;
    }

    public String getBoardingTime() {
        return boardingTime;
    }

    public void setBoardingTime(String boardingTime) {
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

    public long getPilotId() {
        return pilotId;
    }

    public void setPilotId(long pilotId) {
        this.pilotId = pilotId;
    }

    public long getCopilotId() {
        return copilotId;
    }

    public void setCopilotId(long copilotId) {
        this.copilotId = copilotId;
    }
}
