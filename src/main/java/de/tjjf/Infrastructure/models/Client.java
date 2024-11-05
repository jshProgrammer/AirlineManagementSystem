package de.tjjf.Infrastructure.models;

import jakarta.persistence.*;

@Entity
public class Client implements Model {
    //TODO: hier evtl. mapped-Attribut nötig
    @Id
    @OneToOne
    //@JoinColumn(name = "personId", referencedColumnName = "personID s")
    private Person personID;

    @Column(nullable=false)
    private boolean isBusinessClient;

    public Client() {}

    public Client(Person personID, boolean isBusinessClient) {
        this.personID = personID;
        this.isBusinessClient = isBusinessClient;
    }

    public Person getPersonID() {
        return personID;
    }

    public void setPersonID(Person personID) {
        this.personID = personID;
    }

    public boolean isBusinessClient() {
        return isBusinessClient;
    }

    public void setBusinessClient(boolean businessClient) {
        isBusinessClient = businessClient;
    }
}
