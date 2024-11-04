package de.tjjf.Infrastructure.models;

import jakarta.persistence.*;

@Entity
public class Client {
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
}
