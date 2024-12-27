package de.tjjf.Infrastructure.api.InputModels;

import java.util.Date;

public class APIAirlineInput implements APIModelInput {

    public APIAirlineInput() {}

    public APIAirlineInput(String name, Date foundationYear, APIAddressInput address, String phoneNumber, String email) {
        this.name = name;
        this.foundationYear = foundationYear;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

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

    public String getFoundationYearInRFC3339() {
        return foundationYear.getYear() + "-" +
                String.format("%02d", foundationYear.getMonth()) + "-" +
                String.format("%02d", foundationYear.getDate());
    }

    public void setFoundationYear(Date foundationYear) {
        this.foundationYear = foundationYear;
    }
}
