package de.tjjf.Domain.models;

import de.tjjf.Domain.NoSeatsLeftException;

import java.util.Date;

public class MBooking implements MModel {
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

    private MFlight flight;

    private Date dateTimeOfBooking;

    private int totalPrice;

    private int seatNum;

    private SeatingClass seatingClass;

    private BookingStatus bookingStatus;

    private int maxWeightOfLuggage;

    public MBooking(int bookingId, int personId, MFlight flight, Date dateTimeOfBooking, int totalPrice, int seatNum, SeatingClass seatingClass, BookingStatus bookingStatus, int maxWeightOfLuggage) {

        // check whether there is still a place for customer
        if(! (isSeatingUpdateAvailable(seatingClass))) throw new NoSeatsLeftException("Flight cannot be booked any more due to restricted amount");

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

    public void setFlightNum(MFlight flight) {
        this.flight = flight;
    }

    public void setMaxWeightOfLuggage(int maxWeightOfLuggage) {
        this.maxWeightOfLuggage = maxWeightOfLuggage;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public void upgradeSeatingClass(SeatingClass newSeatingClass) {
        if(isSeatingUpdateAvailable(seatingClass)) {
            this.seatingClass = newSeatingClass;
        } else {
            throw new NoSeatsLeftException("No upgrade available as all seats of the desired class are reserved");
        }
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

    public MFlight getFlight() {
        return flight;
    }

    public Date getDateTimeOfBooking() {
        return dateTimeOfBooking;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public int getBookingId() {
        return bookingId;
    }


    private boolean isSeatingUpdateAvailable( MBooking.SeatingClass newDesiredSeatingClass ) {

        MFlight belongingFlight = this.getFlight();
        MBooking[] bookingsOfThisFlight = belongingFlight.getBookings();

        int totalNumberOfSeats = switch(newDesiredSeatingClass) {
            case MBooking.SeatingClass .Economy -> belongingFlight.getAirplane().getAmoutOfEconomySeats();
            case MBooking.SeatingClass .Business -> belongingFlight.getAirplane().getAmoutOfBusinessSeats();
            case MBooking.SeatingClass .First -> belongingFlight.getAirplane().getAmoutOfFirstClassSeats();
        };

        int reservedNumberOfSeats = 0;

        for(MBooking mBookingIter : bookingsOfThisFlight) {
            if(mBookingIter.getSeatingClass() == newDesiredSeatingClass) {
                reservedNumberOfSeats++;
            }
        }

        return reservedNumberOfSeats < totalNumberOfSeats;
    }

}
