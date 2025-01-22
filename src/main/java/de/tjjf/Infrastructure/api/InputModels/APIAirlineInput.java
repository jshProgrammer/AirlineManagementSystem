package de.tjjf.Infrastructure.api.InputModels;

import java.util.Date;

public class APIAirlineInput implements APIModelInput {

    public APIAirlineInput() {}

    public APIAirlineInput(String name, Date foundationYear, APIAddressInput address, String phoneNumber, String email) {
        this.name = name;
        this.foundationYear = foundationYear.toString();
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public APIAirlineInput(String name, String foundationYear, APIAddressInput address, String phoneNumber, String email) {
        this.name = name;
        this.foundationYear = foundationYear;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    private String name;

    private String foundationYear;

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

    public String getFoundationYear() {
        return foundationYear;
    }

    public String getFoundationYearInRFC3339() {
        String[] dateArr = foundationYear.split(" ");

        String month = switch (dateArr[1]) {
            case "Jan" -> "01";
            case "Feb" -> "02";
            case "Mar" -> "03";
            case "Apr" -> "04";
            case "May" -> "05";
            case "Jun" -> "06";
            case "Jul" -> "07";
            case "Aug" -> "08";
            case "Sep" -> "09";
            case "Oct" -> "10";
            case "Nov" -> "11";
            case "Dec" -> "12";
            default -> "00";
        };

        return dateArr[5] + "-" + month + "-" + dateArr[2];
    }

    public void setFoundationYear(String foundationYear) {
        this.foundationYear = foundationYear;
    }
}
