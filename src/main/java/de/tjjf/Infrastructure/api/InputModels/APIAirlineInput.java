package de.tjjf.Infrastructure.api.InputModels;

import java.util.Date;

public class APIAirlineInput implements APIModelInput {

    private String name;

    private Date foundationYear;

    private APIAddressInput address;

    private String phoneNumber;

    private String email;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public APIAddressInput getAddress() {
        return address;
    }

    public void setAddress(APIAddressInput address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFoundationYear() {
        return foundationYear;
    }

    public void setFoundationYear(Date foundationYear) {
        this.foundationYear = foundationYear;
    }
}
