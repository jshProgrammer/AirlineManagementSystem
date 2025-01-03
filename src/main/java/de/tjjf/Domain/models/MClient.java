package de.tjjf.Domain.models;

import java.util.Date;
import java.util.List;

public class MClient extends MPerson implements MModel {

    private boolean isBusinessClient;

    public MClient(long personId, String firstName, String middleNames, String lastName, Date dateOfBirth, String phonenumber, MAddress address, String email, boolean isBusinessClient) {
        super(personId, firstName, middleNames, lastName, dateOfBirth, phonenumber, address, email, null);
        this.isBusinessClient = isBusinessClient;
    }

    public MClient(long personId, String firstName, String middleNames, String lastName, Date dateOfBirth, String phonenumber, MAddress address, String email, boolean isBusinessClient, List<MTicket> tickets) {
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
