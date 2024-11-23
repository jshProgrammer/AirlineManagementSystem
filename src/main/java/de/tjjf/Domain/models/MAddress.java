package de.tjjf.Domain.models;

public class MAddress {
    // simplification: leave out character after number (e.g. Street 12a => Street 12)
    public String street;

    public int number;

    public int zipcode;

    public String city;

    public String country;

    public MAddress(String street, int number, int zipcode, String city, String country) {
        this.street=street;
        this.number=number;
        this.zipcode=zipcode;
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

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
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
