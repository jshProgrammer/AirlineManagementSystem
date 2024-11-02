package de.tjjf.models;

import jakarta.persistence.*;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Booking {
    //TODO: enums in der Klasse lassen?
    public enum SeatingClass {
        Economy,
        Business,
        First
    }

    public enum BookingStatus {
        Paid,
        Unpaid,
        Canceled
    }

    @Column(nullable=false)
    @Id
    private int bookingId;

    @Column(nullable=false)
    @OneToMany()
    private int personId;

    //TODO: evtl eher Flight statt int als Datentyp?
    @Column(nullable=false)
    @OneToMany()
    private int flightNum;

    @Column(nullable=false)
    private Date dateTimeOfBooking;

    @Column(nullable=false)
    private int totalPrice;

    @Column(nullable=false)
    private int seatNum;

    @Column(nullable=false)
    private SeatingClass seatingClass;

    @Column(nullable=false)
    private BookingStatus bookingStatus;

    @Column(nullable=false)
    private int maxWeightOfLuggage;

    public Booking(){}

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public void setDateTimeOfBooking(Date dateTimeOfBooking) {
        this.dateTimeOfBooking = dateTimeOfBooking;
    }

    public void setFlightNum(int flightNum) {
        this.flightNum = flightNum;
    }

    public void setMaxWeightOfLuggage(int maxWeightOfLuggage) {
        this.maxWeightOfLuggage = maxWeightOfLuggage;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public void setSeatingClass(SeatingClass seatingClass) {
        this.seatingClass = seatingClass;
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

    public int getPersonId() {
        return personId;
    }

    public int getMaxWeightOfLuggage() {
        return maxWeightOfLuggage;
    }

    public int getFlightNum() {
        return flightNum;
    }

    public Date getDateTimeOfBooking() {
        return dateTimeOfBooking;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }
}
