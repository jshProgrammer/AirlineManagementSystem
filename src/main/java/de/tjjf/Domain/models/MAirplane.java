package de.tjjf.Domain.models;

public class MAirplane implements MModel {
    private int serialNum;

    private String manufacturer;

    private String model;

    private int amoutOfEconomySeats;

    private int amoutOfBusinessSeats;

    private int amoutOfFirstClassSeats;

    private MAirline belongingAirline;

    private boolean isOperatable;

    public MAirplane(int serialNum, String manufacturer, String model, int amoutOfEconomySeats, int amoutOfBusinessSeats, int amoutOfFirstClassSeats, MAirline belongingAirline, boolean isOperatable) {
        this.serialNum = serialNum;
        this.manufacturer = manufacturer;
        this.model = model;
        this.amoutOfEconomySeats = amoutOfEconomySeats;
        this.amoutOfBusinessSeats = amoutOfBusinessSeats;
        this.amoutOfFirstClassSeats = amoutOfFirstClassSeats;
        this.belongingAirline = belongingAirline;
        this.isOperatable = isOperatable;
    }

    public int getAmoutOfEconomySeats() {
        return amoutOfEconomySeats;
    }

    public int getAmoutOfBusinessSeats() {
        return amoutOfBusinessSeats;
    }

    public int getAmoutOfFirstClassSeats() {
        return amoutOfFirstClassSeats;
    }

    public MAirline getBelongingAirline() {
        return belongingAirline;
    }

    public boolean isOperatable() {
        return isOperatable;
    }

    public void setAmoutOfEconomySeats(int amoutOfEconomySeats) {
        this.amoutOfEconomySeats = amoutOfEconomySeats;
    }

    public void setAmoutOfBusinessSeats(int amoutOfBusinessSeats) {
        this.amoutOfBusinessSeats = amoutOfBusinessSeats;
    }

    public void setAmoutOfFirstClassSeats(int amoutOfFirstClassSeats) {
        this.amoutOfFirstClassSeats = amoutOfFirstClassSeats;
    }

    public void setBelongingAirline(MAirline belongingAirline) {
        this.belongingAirline = belongingAirline;
    }

    public void setOperatable(boolean operatable) {
        isOperatable = operatable;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setSerialNum(int serialNum) {
        this.serialNum = serialNum;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public int getSerialNum() {
        return serialNum;
    }
}
