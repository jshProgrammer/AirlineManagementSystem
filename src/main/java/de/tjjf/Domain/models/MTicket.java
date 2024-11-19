package de.tjjf.Domain.models;

import de.tjjf.Domain.Exceptions.NoAvailableLuggageWeightException;
import de.tjjf.Domain.Exceptions.NoSeatsLeftException;

import java.util.Date;
import java.util.List;

public class MTicket implements MModel {
    //TODO: enums in der Klasse lassen?
    public enum SeatingClass {
        Economy,
        Business,
        First
    }

    public enum BookingStatus {
        Paid,
        Unpaid,
        Canceled
    }

    private int ticketId;

    private MPerson person;

    private MFlight flight;

    private Date dateTimeOfBooking;

    private int totalPrice;

    private int seatNum;

    private SeatingClass seatingClass;

    private BookingStatus ticketStatus;

    private int weightOfLuggage;

    public MTicket(int ticketId, MPerson person, MFlight flight, Date dateTimeOfBooking, int totalPrice, int seatNum, SeatingClass seatingClass, BookingStatus ticketStatus, int weightOfLuggage) {

        this.flight = flight;

        // check whether there is still a place for customer
        if(! (isSeatingUpdateAvailable(seatingClass))) throw new NoSeatsLeftException("Flight cannot be booked any more due to restricted amount");

        this.ticketId = ticketId;
        this.person = person;

        this.dateTimeOfBooking = dateTimeOfBooking;
        this.totalPrice = totalPrice;
        this.seatNum = seatNum;
        this.seatingClass = seatingClass;
        this.ticketStatus = ticketStatus;
        setLuggageWeight(weightOfLuggage);
    }

    public void setTicketStatus(BookingStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public void setDateTimeOfBooking(Date dateTimeOfBooking) {
        this.dateTimeOfBooking = dateTimeOfBooking;
    }

    public void setFlightNum(MFlight flight) {
        this.flight = flight;
    }

    public void setPerson(MPerson person) {
        this.person = person;
    }

    public boolean upgradeSeatingClass(SeatingClass newSeatingClass) {
        boolean upgradeable;
        if(isSeatingUpdateAvailable(seatingClass)) {
            upgradeable = true;
            this.seatingClass = newSeatingClass;
        } else {
            upgradeable = false;
        }
        return upgradeable;
    }

    public boolean upgradeLuggageWeight(int newWeight) {
        boolean upgradeable;
        //Use only 25% of maximum luggage weight for luggage upgrade, the rest is reserved for standard bookings
        //Simplification: Added weight cannot be removed from booking anymore
        if((this.flight.getAirplane().getMaxWeightOfLuggage() * 0.25) >= this.flight.getCurrentUpgradeLuggageWeight() + newWeight ){
            upgradeable = true;

            this.weightOfLuggage = this.weightOfLuggage + newWeight;
            this.flight.addCurrentUpgradeLuggageWeight(this.flight.getCurrentUpgradeLuggageWeight() + newWeight);

            //Increasing the total price in addition to be able to bring more luggage
            this.totalPrice = this.totalPrice + (newWeight * 5);
        }else{
            //Rather boolean or exceptions?
            //throw new NoAvailableLuggageWeightException("Not enough available luggage weight. Only " + (this.flight.getAirplane().getMaxWeightOfLuggage() * 0.25 - this.flight.getCurrentUpgradeLuggageWeight()) + "kg upgradeable luggageweight available");
            upgradeable = false;
        }
        return upgradeable;
    }

    private boolean setLuggageWeight(int wishedLuggageWeight){
        boolean suitableWeight;
        //checking if wishedLuggageWeight is suitable for standard booking
        if(this.flight.getAirplane().getMaxWeightOfLuggage() * 0.75 / this.flight.getAirplane().getTotalNumberOfSeats() >= wishedLuggageWeight){
            suitableWeight = true;

            this.weightOfLuggage = wishedLuggageWeight;
            this.flight.addCurrentInitialLuggageWeight(this.flight.getCurrentInitialLuggageWeight() + weightOfLuggage);

            //Increasing the total price in addition to bring more luggage. Here only 4 because it's at the initial booking
            this.totalPrice = this.totalPrice + (wishedLuggageWeight * 4);
        }else{
            //throw new IllegalArgumentException("Luggage weight is to heavy, please upgrade after booking.");
            suitableWeight = false;
        }
        return suitableWeight;
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

    public MPerson getPerson() {
        return person;
    }

    public int getWeightOfLuggage() {
        return weightOfLuggage;
    }

    public MFlight getFlight() {
        return flight;
    }

    public Date getDateTimeOfBooking() {
        return dateTimeOfBooking;
    }

    public BookingStatus getTicketStatus() {
        return ticketStatus;
    }

    public int getTicketId() {
        return ticketId;
    }

    private boolean isSeatingUpdateAvailable( MTicket.SeatingClass newDesiredSeatingClass ) {

        MFlight belongingFlight = this.getFlight();
        List<MTicket> bookingsOfThisFlight = belongingFlight.getTickets();

        int totalNumberOfSeats = switch(newDesiredSeatingClass) {
            case MTicket.SeatingClass .Economy -> belongingFlight.getAirplane().getAmountOfEconomySeats();
            case MTicket.SeatingClass .Business -> belongingFlight.getAirplane().getAmountOfBusinessSeats();
            case MTicket.SeatingClass .First -> belongingFlight.getAirplane().getAmountOfFirstClassSeats();
        };

        int reservedNumberOfSeats = 0;

        for(MTicket mTicketIter : bookingsOfThisFlight) {
            if(mTicketIter.getSeatingClass() == newDesiredSeatingClass) {
                reservedNumberOfSeats++;
            }
        }

        return reservedNumberOfSeats < totalNumberOfSeats;
    }

    public void cancelTicket(){
        this.ticketStatus = BookingStatus.Canceled;
    }

}
