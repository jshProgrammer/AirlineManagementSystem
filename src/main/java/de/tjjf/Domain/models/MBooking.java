package de.tjjf.Domain.models;

import de.tjjf.Infrastructure.models.Flight;
import java.util.Date;

public class MBooking {
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

    private int bookingId;

    private int personId;

    private Flight flight;

    private Date dateTimeOfBooking;

    private int totalPrice;

    private int seatNum;

    private SeatingClass seatingClass;

    private BookingStatus bookingStatus;

    private int maxWeightOfLuggage;

    public MBooking(int bookingId, int personId, Flight flight, Date dateTimeOfBooking, int totalPrice, int seatNum, SeatingClass seatingClass, BookingStatus bookingStatus, int maxWeightOfLuggage) {
        this.bookingId = bookingId;
        this.personId = personId;
        this.flight = flight;
        this.dateTimeOfBooking = dateTimeOfBooking;
        this.totalPrice = totalPrice;
        this.seatNum = seatNum;
        this.seatingClass = seatingClass;
        this.bookingStatus = bookingStatus;
        this.maxWeightOfLuggage = maxWeightOfLuggage;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public void setDateTimeOfBooking(Date dateTimeOfBooking) {
        this.dateTimeOfBooking = dateTimeOfBooking;
    }

    public void setFlightNum(Flight flight) {
        this.flight = flight;
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

    public Flight getFlight() {
        return flight;
    }

    public Date getDateTimeOfBooking() {
        return dateTimeOfBooking;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }
}
