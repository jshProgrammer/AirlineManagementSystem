package de.tjjf.Domain.models;

public class MAirplane implements MModel {
    private int serialNum;

    private String manufacturer;

    private String model;

    private int amountOfEconomySeats;

    private int amountOfBusinessSeats;

    private int amountOfFirstClassSeats;

    private MAirline belongingAirline;

    private boolean isOperatable;

    final private int maxWeightOfLuggage;

    public MAirplane(int serialNum, String manufacturer, String model, int amountOfEconomySeats, int amoutOfBusinessSeats, int amoutOfFirstClassSeats, MAirline belongingAirline, boolean isOperatable, int maxWeightOfLuggage) {
        this.serialNum = serialNum;
        this.manufacturer = manufacturer;
        this.model = model;
        this.amountOfEconomySeats = amountOfEconomySeats;
        this.amountOfBusinessSeats = amoutOfBusinessSeats;
        this.amountOfFirstClassSeats = amoutOfFirstClassSeats;
        this.belongingAirline = belongingAirline;
        this.isOperatable = isOperatable;
        this.maxWeightOfLuggage = maxWeightOfLuggage;
    }

    public int getTotalNumberOfSeats(){
        return this.amountOfBusinessSeats + this.amountOfEconomySeats + this.amountOfFirstClassSeats;
    }
    public int getAmountOfEconomySeats() {
        return amountOfEconomySeats;
    }

    public int getAmountOfBusinessSeats() {
        return amountOfBusinessSeats;
    }

    public int getAmountOfFirstClassSeats() {
        return amountOfFirstClassSeats;
    }

    public MAirline getBelongingAirline() {
        return belongingAirline;
    }

    public boolean isOperatable() {
        return isOperatable;
    }

    public void setAmountOfEconomySeats(int amountOfEconomySeats) {
        this.amountOfEconomySeats = amountOfEconomySeats;
    }

    public void setAmountOfBusinessSeats(int amountOfBusinessSeats) {
        this.amountOfBusinessSeats = amountOfBusinessSeats;
    }

    public void setAmountOfFirstClassSeats(int amountOfFirstClassSeats) {
        this.amountOfFirstClassSeats = amountOfFirstClassSeats;
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

    public int getMaxWeightOfLuggage() {
        return maxWeightOfLuggage;
    }
}
