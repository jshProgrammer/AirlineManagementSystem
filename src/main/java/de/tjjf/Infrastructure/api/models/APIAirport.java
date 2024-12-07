package de.tjjf.Infrastructure.api.models;

public class APIAirport implements APIModel {

    private String code;

    private String name;

    private String country;

    private String city;

    private String timezone;

    public APIAirport(){}

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }
}
