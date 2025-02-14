package de.tjjf.Domain.models;

import de.tjjf.Domain.Exceptions.NoSeatsAvailableException;
import java.util.Date;
import java.util.List;

public class DomainTicket implements DomainModel {
    public enum SeatingClass { Economy, Business, First }

    public enum TicketStatus { paid, unpaid, canceled }

    private final long ticketId;

    private DomainPerson person;

    private DomainFlight flight;

    private final Date dateTimeOfBooking;

    private int totalPrice;

    private int seatNum;

    private SeatingClass seatingClass;

    private TicketStatus ticketStatus;

    private int weightOfLuggage;

    // use exceptions instead of boolean, in order to be able to differ between the two problems (NoSeatsLeft, NotEnoughLuggageWeightAvailable => IllegalArgumentException)
    public DomainTicket(long ticketId, DomainPerson person, DomainFlight flight, Date dateTimeOfBooking, int totalPrice, int seatNum, SeatingClass seatingClass, TicketStatus ticketStatus, int weightOfLuggage) throws NoSeatsAvailableException, IllegalArgumentException {

        this.flight = flight;

        if(!isSeatingUpdateAvailable(seatingClass)) throw new NoSeatsAvailableException("Flight cannot be booked any more due to restricted amount");

        this.ticketId = ticketId;
        this.person = person;
        this.dateTimeOfBooking = dateTimeOfBooking;
        this.totalPrice = totalPrice;
        this.seatNum = seatNum;
        this.seatingClass = seatingClass;
        this.ticketStatus = ticketStatus;

        setLuggageWeight(weightOfLuggage);

        flight.addTicket(this);
        person.addTickets(this);
    }

    public void upgradeSeatingClass(SeatingClass newSeatingClass) throws NoSeatsAvailableException {
        if(isSeatingUpdateAvailable(newSeatingClass)) {
            this.seatingClass = newSeatingClass;

        } else {
            throw new NoSeatsAvailableException("Seat could not be upgraded");
        }
    }

    public boolean isSeatingUpdateAvailable(DomainTicket.SeatingClass newDesiredSeatingClass ) {

        DomainFlight belongingFlight = this.flight;
        List<DomainTicket> bookingsOfThisFlight = belongingFlight.getTickets();

        int totalNumberOfSeats = switch(newDesiredSeatingClass) {
            case DomainTicket.SeatingClass.Economy -> belongingFlight.getAirplane().getAmountOfEconomySeats();
            case DomainTicket.SeatingClass.Business -> belongingFlight.getAirplane().getAmountOfBusinessSeats();
            case DomainTicket.SeatingClass.First -> belongingFlight.getAirplane().getAmountOfFirstClassSeats();
        };

        int reservedNumberOfSeats = 0;

        for(DomainTicket mTicketIter : bookingsOfThisFlight) {
            if(mTicketIter.getSeatingClass() == newDesiredSeatingClass) {
                reservedNumberOfSeats++;
            }
        }

        return reservedNumberOfSeats < totalNumberOfSeats;
    }

    public void upgradeLuggageWeight(int newWeight) throws IllegalArgumentException {
        //Use only 25% of maximum luggage weight for luggage upgrade, the rest is reserved for standard bookings
        //Simplification: Added weight cannot be removed from booking anymore
        if((this.flight.getAirplane().getMaxWeightOfLuggage() * 0.25) >= this.flight.getCurrentUpgradeLuggageWeight() + newWeight ){

            this.weightOfLuggage = this.weightOfLuggage + newWeight;
            this.flight.addCurrentUpgradeLuggageWeight(this.flight.getCurrentUpgradeLuggageWeight() + newWeight);

            this.totalPrice = this.totalPrice + (newWeight * 5);
        }else{
            throw new IllegalArgumentException("Not enough available luggage weight. Only " + (this.flight.getAirplane().getMaxWeightOfLuggage() * 0.25 - this.flight.getCurrentUpgradeLuggageWeight()) + "kg upgradeable luggageweight available");
        }

    }

    private void setLuggageWeight(int wishedLuggageWeight) throws IllegalArgumentException{
        if(this.flight.getAirplane().getMaxWeightOfLuggage() * 0.75 / this.flight.getAirplane().getTotalNumberOfSeats() >= wishedLuggageWeight){

            this.weightOfLuggage = wishedLuggageWeight;
            this.flight.addCurrentInitialLuggageWeight(this.flight.getCurrentInitialLuggageWeight() + weightOfLuggage);

            this.totalPrice = this.totalPrice + (wishedLuggageWeight * 4);
        }
        else {
            throw new IllegalArgumentException("Luggage weight is to heavy, please upgrade after booking.");
        }
    }


    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public void setFlightNum(DomainFlight flight) {
        this.flight = flight;
    }

    public void setPerson(DomainPerson person) {
        this.person = person;
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

    public DomainPerson getPerson() {
        return person;
    }

    public int getWeightOfLuggage() {
        return weightOfLuggage;
    }

    public DomainFlight getFlight() {
        return flight;
    }

    public Date getDateTimeOfBooking() {
        return dateTimeOfBooking;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public long getTicketId() {
        return ticketId;
    }
}
