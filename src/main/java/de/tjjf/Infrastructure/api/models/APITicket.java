package de.tjjf.Infrastructure.api.models;

import de.tjjf.Domain.Exceptions.NoSeatsAvailableException;
import de.tjjf.Domain.UseCases.AddBookingUseCase;

import java.util.Date;
import java.util.List;

public class APITicket implements APIModel {
    public enum SeatingClass { Economy, Business, First }

    public enum TicketStatus { paid, unpaid, canceled }

    private int ticketId;

    // in order to store clientId or employeeId
    private long personId;
    private boolean isClient;

    private long flightNum;

    private Date dateTimeOfBooking;

    private int totalPrice;

    private int seatNum;

    private SeatingClass seatingClass;

    private TicketStatus ticketStatus;

    private int weightOfLuggage;


    public APITicket(){}

    public APITicket(int ticketId, long personId, boolean isClient, long flightNum, Date dateTimeOfBooking, int totalPrice, int seatNum, SeatingClass seatingClass, TicketStatus ticketStatus, int weightOfLuggage) {
        this.ticketId = ticketId;
        this.personId = personId;
        this.isClient = isClient;
        this.flightNum = flightNum;
        this.dateTimeOfBooking = dateTimeOfBooking;
        this.totalPrice = totalPrice;
        this.seatNum = seatNum;
        this.seatingClass = seatingClass;
        this.ticketStatus = ticketStatus;
        this.weightOfLuggage = weightOfLuggage;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getTicketId() { return this.ticketId; }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public boolean isClient() {
        return isClient;
    }

    public void setClient(boolean client) {
        isClient = client;
    }

    public long getFlightNum() {
        return flightNum;
    }

    public void setFlightNum(long flightNum) {
        this.flightNum = flightNum;
    }

    public void setDateTimeOfBooking(Date dateTimeOfBooking) {
        this.dateTimeOfBooking = dateTimeOfBooking;
    }

    public void setSeatingClass(SeatingClass seatingClass) {
        this.seatingClass = seatingClass;
    }

    public void setWeightOfLuggage(int weightOfLuggage) {
        this.weightOfLuggage = weightOfLuggage;
    }

    public void setSeatNum(int seatNum) {
        this.seatNum = seatNum;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public int getSeatNum() {
        return seatNum;
    }

    public SeatingClass getSeatingClass() {
        return seatingClass;
    }

    public int getWeightOfLuggage() {
        return weightOfLuggage;
    }

    public Date getDateTimeOfBooking() {
        return dateTimeOfBooking;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

}
