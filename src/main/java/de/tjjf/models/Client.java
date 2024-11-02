package de.tjjf.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Client {
    @Id
    private int personID;
    private boolean isBusinessClient;
}
