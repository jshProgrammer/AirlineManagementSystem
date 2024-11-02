package de.tjjf.models;

import jakarta.persistence.*;

@Entity
public class Client {
    //TODO: hier evtl. mapped-Attribut nötig
    @Column(nullable=false)
    @Id
    @JoinColumn(name = "personId", referencedColumnName = "personID s")
    private int personID;

    @Column(nullable=false)
    private boolean isBusinessClient;

    public Client() {}

    public Client(int personID, boolean isBusinessClient) {
        this.personID = personID;
        this.isBusinessClient = isBusinessClient;
    }

    public int getPersonID() {
        return personID;
    }

    public boolean isBusinessClient() {
        return isBusinessClient;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public void setBusinessClient(boolean businessClient) {
        isBusinessClient = businessClient;
    }
}
