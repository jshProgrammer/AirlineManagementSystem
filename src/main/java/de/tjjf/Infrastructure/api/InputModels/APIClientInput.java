package de.tjjf.Infrastructure.api.InputModels;

import java.util.Date;

public class APIClientInput implements APIModelInput {
    public APIClientInput(long clientId, String firstName, String middleNames, String lastName, Date dateOfBirth, String phoneNumber, APIAddressInput address, String email, boolean isBusinessClient) {
        this.clientId = clientId;
        this.firstName = firstName;
        this.middleNames = middleNames;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
        this.isBusinessClient = isBusinessClient;
    }

    private long clientId;

    private String firstName;

    private String middleNames;

    private String lastName;

    private Date dateOfBirth;

    private String phoneNumber;

    private APIAddressInput address;

    private String email;

    private boolean isBusinessClient;

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

    public String getDateOfBirthInRFC3339() {
        return dateOfBirth.getYear() + "-" +
                String.format("%02d", dateOfBirth.getMonth()) + "-" +
                String.format("%02d", dateOfBirth.getDate());
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

    public APIAddressInput getAddress() {
        return address;
    }

    public void setAddress(APIAddressInput address) {
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
