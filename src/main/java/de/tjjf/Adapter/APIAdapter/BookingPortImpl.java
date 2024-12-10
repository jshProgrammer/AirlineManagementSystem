package de.tjjf.Adapter.APIAdapter;

import de.tjjf.Domain.Exceptions.NoSeatsAvailableException;
import de.tjjf.Domain.models.MPayment;
import de.tjjf.Domain.models.MPerson;
import de.tjjf.Domain.models.MTicket;
import de.tjjf.Domain.ports.API.TicketPort;

public class BookingPortImpl implements TicketPort {
    @Override
    public boolean addBooking(MTicket newBooking) {
        return true;
    }

    @Override
    public MTicket readTicketById(int id) {
        return null;
    }

    @Override
    public void upgradeSeatingClass(MTicket.SeatingClass newSeatingClass) throws NoSeatsAvailableException{

    }

    @Override
    public void upgradeLuggageWeight(int newWeight) throws IllegalArgumentException {

    }

    @Override
    public void cancelTicket(MPerson person, int flightnum){

    }
}
