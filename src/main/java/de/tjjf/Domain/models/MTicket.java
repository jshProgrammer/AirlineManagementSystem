package de.tjjf.Domain.models;

import de.tjjf.Domain.Exceptions.NoSeatsAvailableException;
import de.tjjf.Domain.UseCases.AddBookingUseCase;
import java.util.Date;
import java.util.List;

public class MTicket implements MModel {
    public enum SeatingClass { Economy, Business, First }

    public enum TicketStatus { paid, unpaid, canceled }

    private final long ticketId;

    private MPerson person;

    private MFlight flight;

    private final Date dateTimeOfBooking;

    private int totalPrice;

    private int seatNum;

    private SeatingClass seatingClass;

    private TicketStatus ticketStatus;

    private int weightOfLuggage;

    // use exceptions instead of boolean, in order to be able to differ between the two problems (NoSeatsLeft, NotEnoughLuggageWeightAvailable => IllegalArgumentException)
    public MTicket(long ticketId, MPerson person, MFlight flight, Date dateTimeOfBooking, int totalPrice, int seatNum, SeatingClass seatingClass, TicketStatus ticketStatus, int weightOfLuggage) throws NoSeatsAvailableException, IllegalArgumentException {

        this.flight = flight;

        // check whether there is still a seat for customer
        if(!isSeatingUpdateAvailable(seatingClass)) throw new NoSeatsAvailableException("Flight cannot be booked any more due to restricted amount");

        this.ticketId = ticketId;
        this.person = person;
        this.dateTimeOfBooking = dateTimeOfBooking;
        this.totalPrice = totalPrice;
        this.seatNum = seatNum;
        this.seatingClass = seatingClass;
        this.ticketStatus = ticketStatus;

        setLuggageWeight(weightOfLuggage);
        //AddBookingUseCase.addBooking(this);

        flight.addTicket(this);
        person.addTickets(this);
    }

    //TODO: sollte eigentlich in Use-Case, aber dann fehlt uns die Funktion setSeating-class, die wir hier ja aber nicht auf public setzen dürfen?!
    public void upgradeSeatingClass(SeatingClass newSeatingClass) throws NoSeatsAvailableException {
        if(isSeatingUpdateAvailable(newSeatingClass)) {
            this.seatingClass = newSeatingClass;
        } else {
            throw new NoSeatsAvailableException("Seat could not be upgraded");
        }
    }

    public boolean isSeatingUpdateAvailable(MTicket.SeatingClass newDesiredSeatingClass ) {

        MFlight belongingFlight = this.flight;
        List<MTicket> bookingsOfThisFlight = belongingFlight.getTickets();

        int totalNumberOfSeats = switch(newDesiredSeatingClass) {
            case MTicket.SeatingClass.Economy -> belongingFlight.getAirplane().getAmountOfEconomySeats();
            case MTicket.SeatingClass.Business -> belongingFlight.getAirplane().getAmountOfBusinessSeats();
            case MTicket.SeatingClass.First -> belongingFlight.getAirplane().getAmountOfFirstClassSeats();
        };

        int reservedNumberOfSeats = 0;

        for(MTicket mTicketIter : bookingsOfThisFlight) {
            if(mTicketIter.getSeatingClass() == newDesiredSeatingClass) {
                reservedNumberOfSeats++;
            }
        }

        return reservedNumberOfSeats < totalNumberOfSeats;
    }

    //TODO: gleiches Problem wie oben => dann müssten wir eine Methode setLuggageWeight bereitstellen
    public void upgradeLuggageWeight(int newWeight) throws IllegalArgumentException {
        //Use only 25% of maximum luggage weight for luggage upgrade, the rest is reserved for standard bookings
        //Simplification: Added weight cannot be removed from booking anymore
        if((this.flight.getAirplane().getMaxWeightOfLuggage() * 0.25) >= this.flight.getCurrentUpgradeLuggageWeight() + newWeight ){

            this.weightOfLuggage = this.weightOfLuggage + newWeight;
            this.flight.addCurrentUpgradeLuggageWeight(this.flight.getCurrentUpgradeLuggageWeight() + newWeight);

            //Increasing the total price in addition to be able to bring more luggage
            this.totalPrice = this.totalPrice + (newWeight * 5);
        }else{
            throw new IllegalArgumentException("Not enough available luggage weight. Only " + (this.flight.getAirplane().getMaxWeightOfLuggage() * 0.25 - this.flight.getCurrentUpgradeLuggageWeight()) + "kg upgradeable luggageweight available");
        }

    }

    private void setLuggageWeight(int wishedLuggageWeight) throws IllegalArgumentException{
        //checking if wishedLuggageWeight is suitable for standard booking
        if(this.flight.getAirplane().getMaxWeightOfLuggage() * 0.75 / this.flight.getAirplane().getTotalNumberOfSeats() >= wishedLuggageWeight){

            this.weightOfLuggage = wishedLuggageWeight;
            this.flight.addCurrentInitialLuggageWeight(this.flight.getCurrentInitialLuggageWeight() + weightOfLuggage);

            //Increasing the total price in addition to bring more luggage. Here only 4 because it's at the initial booking
            this.totalPrice = this.totalPrice + (wishedLuggageWeight * 4);
        }
        else {
            throw new IllegalArgumentException("Luggage weight is to heavy, please upgrade after booking.");
        }
    }


    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public void setFlightNum(MFlight flight) {
        this.flight = flight;
    }

    public void setPerson(MPerson person) {
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

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public long getTicketId() {
        return ticketId;
    }
}
