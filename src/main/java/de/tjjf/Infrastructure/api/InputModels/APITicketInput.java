package de.tjjf.Infrastructure.api.InputModels;

public class APITicketInput implements APIModelInput {

    public APITicketInput(){}

    public APITicketInput(long personId, boolean isClient, long flightNum, String dateTimeOfBooking, int totalPrice, int seatNum, SeatingClass seatingClass, TicketStatus ticketStatus, int weightOfLuggage) {
        this.personId = personId;
        this.isClient = isClient;
        this.flightNum = flightNum;
        this.dateTimeOfBooking = dateTimeOfBooking;
        this.totalPrice = totalPrice;
        this.seatNum = seatNum;
        this.seatingClass = seatingClass;
        this.ticketStatus = ticketStatus;
        this.weightOfLuggage = weightOfLuggage;
    }


    //TODO: sollen die enums hier wirklich drin bleiben?
    public enum SeatingClass { Economy, Business, First }

    public enum TicketStatus { paid, unpaid, canceled }

    // in order to store clientId or employeeId
    private long personId;
    private boolean isClient;

    private long flightNum;

    private String dateTimeOfBooking;

    private int totalPrice;

    private int seatNum;

    private SeatingClass seatingClass;

    private TicketStatus ticketStatus;

    private int weightOfLuggage;

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public boolean getIsClient() {
        return isClient;
    }

    public void setIsClient(boolean client) {
        isClient = client;
    }

    public long getFlightNum() {
        return flightNum;
    }

    public void setFlightNum(long flightNum) {
        this.flightNum = flightNum;
    }

    public void setDateTimeOfBooking(String dateTimeOfBooking) {
        this.dateTimeOfBooking = dateTimeOfBooking;
    }

    public void setSeatingClass(SeatingClass seatingClass) {
        this.seatingClass = seatingClass;
    }

    public void setWeightOfLuggage(int weightOfLuggage) {
        this.weightOfLuggage = weightOfLuggage;
    }

    public void setSeatNum(int seatNum) {
        this.seatNum = seatNum;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public int getSeatNum() {
        return seatNum;
    }

    public SeatingClass getSeatingClass() {
        return seatingClass;
    }

    public int getWeightOfLuggage() {
        return weightOfLuggage;
    }

    public String getDateTimeOfBooking() {
        return dateTimeOfBooking;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

}
