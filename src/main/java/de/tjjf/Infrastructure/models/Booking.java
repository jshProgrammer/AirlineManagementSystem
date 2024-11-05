package de.tjjf.Infrastructure.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Booking implements Model {
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

    @ManyToOne()
    private Person personId;

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
    private SeatingClass seatingClass;

    @Column(nullable=false)
    private BookingStatus bookingStatus;

    @Column(nullable=false)
    private int maxWeightOfLuggage;

    public Booking(){}

    public Booking(int bookingId, Person personId, Flight flightNum, Date dateTimeOfBooking, int totalPrice, int seatNum, SeatingClass seatingClass, BookingStatus bookingStatus, int maxWeightOfLuggage) {
        this.bookingId = bookingId;
        this.personId = personId;
        this.flightNum = flightNum;
        this.dateTimeOfBooking = dateTimeOfBooking;
        this.totalPrice = totalPrice;
        this.seatNum = seatNum;
        this.seatingClass = seatingClass;
        this.bookingStatus = bookingStatus;
        this.maxWeightOfLuggage = maxWeightOfLuggage;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public Person getPersonId() {
        return personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
    }

    public Flight getFlightNum() {
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

    public SeatingClass getSeatingClass() {
        return seatingClass;
    }

    public void setSeatingClass(SeatingClass seatingClass) {
        this.seatingClass = seatingClass;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public int getMaxWeightOfLuggage() {
        return maxWeightOfLuggage;
    }

    public void setMaxWeightOfLuggage(int maxWeightOfLuggage) {
        this.maxWeightOfLuggage = maxWeightOfLuggage;
    }
}
