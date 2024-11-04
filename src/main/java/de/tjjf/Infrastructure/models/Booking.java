package de.tjjf.Infrastructure.models;

import jakarta.persistence.*;

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
    @ManyToOne()
    private Person personId;

    //TODO: evtl eher Flight statt int als Datentyp?
    @Column(nullable=false)
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
}
