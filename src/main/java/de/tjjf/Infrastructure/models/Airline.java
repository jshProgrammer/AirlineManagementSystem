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

    public String getName() {
        return name;
    }

    public Date getFoundationYear() {
        return foundationYear;
    }

    public String getHeadQuarters() {
        return headQuarters;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFoundationYear(Date foundationYear) {
        this.foundationYear = foundationYear;
    }

    public void setHeadQuarters(String headQuarters) {
        this.headQuarters = headQuarters;
    }
}
