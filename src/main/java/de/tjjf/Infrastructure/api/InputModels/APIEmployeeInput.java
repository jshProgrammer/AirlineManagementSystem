package de.tjjf.Infrastructure.api.InputModels;

import de.tjjf.Infrastructure.api.models.APIEmployee;

import java.util.Date;

public class APIEmployeeInput implements APIModelInput {

    public APIEmployeeInput() {}

    public APIEmployeeInput(String firstName, String middleNames, String lastName, Date dateOfBirth, String phoneNumber, APIAddressInput address, String email, String airlineName) {
        this.firstName = firstName;
        this.middleNames = middleNames;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
        this.airlineName = airlineName;
    }

    private String firstName;

    private String middleNames;

    private String lastName;

    private Date dateOfBirth;

    private String phoneNumber;

    private APIAddressInput address;

    private String email;

    private String airlineName;

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

    public String getAirline() {
        return airlineName;
    }
    public void setAirline(String airline) {
        this.airlineName = airline;
    }
}
