package de.tjjf.Infrastructure.persistence.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Ticket implements Model {
   @Column(nullable=false)
    @Id
    private int ticketId;

    private long personId;

    //TODO: evtl eher Flight statt int als Datentyp?
    //Umbenennung der Variable
    @ManyToOne()
    private Flight flightNum;

    @Column(nullable=false)
    private Date dateTimeOfBooking;

    @Column(nullable=false)
    private int totalPrice;

    @Column(nullable=false)
    private int seatNum;

    @Column(nullable=false)
    private String seatingClass;

    @Column(nullable=false)
    private String ticketStatus;

    @Column(nullable=false)
    private int maxWeightOfLuggage;

    public Ticket(){}

    public Ticket(int ticketId, long personId, Flight flightNum, Date dateTimeOfBooking, int totalPrice, int seatNum, String seatingClass, String ticketStatus, int maxWeightOfLuggage) {
        this.ticketId = ticketId;
        this.personId = personId;
        this.flightNum = flightNum;
        this.dateTimeOfBooking = dateTimeOfBooking;
        this.totalPrice = totalPrice;
        this.seatNum = seatNum;
        this.seatingClass = seatingClass;
        this.ticketStatus = ticketStatus;
        this.maxWeightOfLuggage = maxWeightOfLuggage;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public Flight getFlight() {
        return flightNum;
    }

    public void setFlightNum(Flight flightNum) {
        this.flightNum = flightNum;
    }

    public Date getDateTimeOfBooking() {
        return dateTimeOfBooking;
    }

    public void setDateTimeOfBooking(Date dateTimeOfBooking) {
        this.dateTimeOfBooking = dateTimeOfBooking;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(int seatNum) {
        this.seatNum = seatNum;
    }

    public String getSeatingClass() {
        return seatingClass;
    }

    public void setSeatingClass(String seatingClass) {
        this.seatingClass = seatingClass;
    }

    public String getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public int getMaxWeightOfLuggage() {
        return maxWeightOfLuggage;
    }

    public void setMaxWeightOfLuggage(int maxWeightOfLuggage) {
        this.maxWeightOfLuggage = maxWeightOfLuggage;
    }
}
