package de.tjjf.Domain.models;

public class DomainAirplane implements DomainModel {

    private final int serialNum;

    private final String manufacturer;

    private final String model;

    private final int amountOfEconomySeats;

    private final int amountOfBusinessSeats;

    private final int amountOfFirstClassSeats;

    private DomainAirline belongingAirline;

    private boolean isOperable;

    private final int maxWeightOfLuggage;


    public DomainAirplane(int serialNum, String manufacturer, String model, int amountOfEconomySeats, int amountOfBusinessSeats, int amountOfFirstClassSeats, DomainAirline belongingAirline, boolean isOperable, int maxWeightOfLuggage) {
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

    public DomainAirline getBelongingAirline() {
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

    public void setBelongingAirline(DomainAirline belongingAirline) {
        this.belongingAirline = belongingAirline;
    }

    public void setOperable(boolean operable) {
        isOperable = operable;
    }
}
