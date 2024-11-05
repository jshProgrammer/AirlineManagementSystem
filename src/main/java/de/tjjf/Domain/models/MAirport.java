package de.tjjf.Domain.models;

public class MAirport implements MModel {

    private String code;

    private String name;

    private String country;

    private String city;

    private String timezone;

    public MAirport(String code, String name, String country, String city, String timezone) {
        this.code = code;
        this.name = name;
        this.country = country;
        this.city = city;
        this.timezone = timezone;
    }

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

    public void setCode(String code) {
        this.code = code;
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
