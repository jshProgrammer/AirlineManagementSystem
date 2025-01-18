package de.tjjf.Infrastructure.api.models;

public class APIClient implements APIModel {
    private long clientId;

    private String firstName;

    private String middleNames;

    private String lastName;

    private String dateOfBirth;

    private String phoneNumber;

    private APIAddress address;

    private String email;

    private Boolean isBusinessClient;


    public APIClient(){}

    public APIClient(long clientId, String firstName, String middleNames, String lastName, String dateOfBirth, String phoneNumber, APIAddress address, String email, Boolean isBusinessClient) {
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
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

    public Boolean getIsBusinessClient() {
        return isBusinessClient;
    }

    public void setIsBusinessClient(Boolean isBusinessClient) {
        this.isBusinessClient = isBusinessClient;
    }
}
