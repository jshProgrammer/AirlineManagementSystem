package de.tjjf.Infrastructure.models;

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
}
