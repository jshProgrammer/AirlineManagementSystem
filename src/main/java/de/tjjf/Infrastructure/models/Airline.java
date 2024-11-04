package de.tjjf.Infrastructure.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;
@Entity
public class Airline {
    @Id
    private String name;

    private Date foundationYear;

    private String headQuarters;

    //TODO: sollen wir hier mit OneToMany auch die Flugzeuge speichern => eig wird das ja selten abgerufen

    public Airline() {}

    public Airline(String name, Date foundationYear, String headQuarters) {
        this.name = name;
        this.foundationYear = foundationYear;
        this.headQuarters = headQuarters;
    }
}
