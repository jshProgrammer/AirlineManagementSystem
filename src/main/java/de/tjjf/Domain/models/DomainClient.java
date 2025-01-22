package de.tjjf.Domain.models;

import java.util.Date;
import java.util.List;

public class DomainClient extends DomainPerson implements DomainModel {

    private boolean isBusinessClient;

    public DomainClient(long personId, String firstName, String middleNames, String lastName, Date dateOfBirth, String phonenumber, DomainAddress address, String email, boolean isBusinessClient) {
        super(personId, firstName, middleNames, lastName, dateOfBirth, phonenumber, address, email, null);
        this.isBusinessClient = isBusinessClient;
    }

    public DomainClient(long personId, String firstName, String middleNames, String lastName, Date dateOfBirth, String phonenumber, DomainAddress address, String email, boolean isBusinessClient, List<DomainTicket> tickets) {
        super(personId, firstName, middleNames, lastName, dateOfBirth, phonenumber, address, email, tickets);
        this.isBusinessClient = isBusinessClient;
    }


    public boolean isBusinessClient() {
        return isBusinessClient;
    }

    public void setBusinessClient(boolean businessClient) {
        isBusinessClient = businessClient;
    }
}
