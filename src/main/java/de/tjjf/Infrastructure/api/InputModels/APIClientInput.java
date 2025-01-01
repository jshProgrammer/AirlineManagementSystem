package de.tjjf.Infrastructure.api.InputModels;

import de.tjjf.Infrastructure.api.DateParser;

public class APIClientInput implements APIModelInput {

    public APIClientInput() {}

    public APIClientInput(String firstName, String middleNames, String lastName, String dateOfBirth, String phoneNumber, APIAddressInput address, String email, Boolean isBusinessClient) {
        this.firstName = firstName;
        this.middleNames = middleNames;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
        this.isBusinessClient = isBusinessClient;
    }

    private String firstName;

    private String middleNames;

    private String lastName;

    private String dateOfBirth;

    private String phoneNumber;

    private APIAddressInput address;

    private String email;

    private Boolean isBusinessClient;

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

    public String getDateOfBirthInRFC3339() {
        return DateParser.getDateFromDBInRFC3339(dateOfBirth);
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

    public Boolean isBusinessClient() {
        return isBusinessClient;
    }

    public void setIsBusinessClient(Boolean isBusinessClient) {
        isBusinessClient = isBusinessClient;
    }
}
