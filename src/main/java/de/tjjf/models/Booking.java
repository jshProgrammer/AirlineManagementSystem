package de.tjjf.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Booking {
    @Id
    private int personId;

    private int flightNum;

    private Date dateTimeOfBooking;

    private int totalPrice;

    private int seatNum;

    private SeatingClass seatingClass;

    private BookingStatus bookingStatus;

    private int maxWeightOfLuggage;

    public Booking(){

    }

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
