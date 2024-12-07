package de.tjjf.Infrastructure.api.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class APIClient implements APIModel {
    private long clientId;

    private String firstName;

    private String middleNames;

    private String lastName;

    private Date dateOfBirth;

    private String phoneNumber;

    private APIAddress address;

    private String email;

    private boolean isBusinessClient;


    public APIClient(){}

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleNames() {
        return middleNames;
    }

    public void setMiddleNames(String middleNames) {
        this.middleNames = middleNames;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public APIAddress getAddress() {
        return address;
    }

    public void setAddress(APIAddress address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isBusinessClient() {
        return isBusinessClient;
    }

    public void setBusinessClient(boolean businessClient) {
        isBusinessClient = businessClient;
    }
}
