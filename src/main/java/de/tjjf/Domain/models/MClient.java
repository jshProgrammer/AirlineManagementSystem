package de.tjjf.Domain.models;

public class MClient {
    private int personID;

    private boolean isBusinessClient;

    public MClient() {}

    public MClient(int personID, boolean isBusinessClient) {
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
