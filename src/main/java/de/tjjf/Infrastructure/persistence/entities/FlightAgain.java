package de.tjjf.Infrastructure.persistence.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class FlightAgain implements Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long flightNum;



    public FlightAgain(){}

    public long getFlightNum() {
        return flightNum;
    }

    public void setFlightNum(long flightNum) {
        this.flightNum = flightNum;
    }
}
