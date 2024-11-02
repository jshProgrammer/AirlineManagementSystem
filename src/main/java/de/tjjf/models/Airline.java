package de.tjjf.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;
@Entity
public class Airline {
    @Id
    private String name;

    private Date foundationYear;

    private String headQuarters;
}
