package de.tjjf.Domain.models;

public class MAirplane implements MModel {
    private final int serialNum;

    private final String manufacturer;

    private final String model;

    private final int amountOfEconomySeats;

    private final int amountOfBusinessSeats;

    private final int amountOfFirstClassSeats;

    private MAirline belongingAirline;

    private boolean isOperable;

    private final int maxWeightOfLuggage;

    public MAirplane(int serialNum, String manufacturer, String model, int amountOfEconomySeats, int amountOfBusinessSeats, int amountOfFirstClassSeats, MAirline belongingAirline, boolean isOperable, int maxWeightOfLuggage) {
        this.serialNum = serialNum;
        this.manufacturer = manufacturer;
        this.model = model;
        this.amountOfEconomySeats = amountOfEconomySeats;
        this.amountOfBusinessSeats = amountOfBusinessSeats;
        this.amountOfFirstClassSeats = amountOfFirstClassSeats;
        this.belongingAirline = belongingAirline;
        this.isOperable = isOperable;
        this.maxWeightOfLuggage = maxWeightOfLuggage;
    }

    public int getTotalNumberOfSeats(){ return this.amountOfBusinessSeats + this.amountOfEconomySeats + this.amountOfFirstClassSeats; }
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

    public boolean isOperable() {
        return isOperable;
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

    public void setBelongingAirline(MAirline belongingAirline) {
        this.belongingAirline = belongingAirline;
    }

    public void setOperable(boolean operable) {
        isOperable = operable;
    }
}
