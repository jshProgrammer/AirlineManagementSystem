package de.tjjf.Infrastructure.api.models;

public class APIAddress implements APIModel {
    // simplification: leave out character after number (e.g. Street 12a => Street 12)
    public String street;

    public int number;

    public int zipCode;

    public String city;

    public String country;

    public APIAddress(){}

    public APIAddress(String street, int number, int zipCode, String city, String country) {
        this.street=street;
        this.number=number;
        this.zipCode =zipCode;
        this.city=city;
        this.country=country;
    }


    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
