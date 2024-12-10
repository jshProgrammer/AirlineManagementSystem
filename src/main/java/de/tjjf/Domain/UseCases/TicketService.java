package de.tjjf.Domain.UseCases;

import de.tjjf.Domain.Exceptions.NoSeatsAvailableException;
import de.tjjf.Domain.models.MPayment;
import de.tjjf.Domain.models.MPerson;
import de.tjjf.Domain.models.MTicket;
import de.tjjf.Domain.ports.DB.DataAccess;

public class TicketService {
    DataAccess.MTicketRepository port;

    public TicketService(DataAccess.MTicketRepository port) {
        this.port = port;
    }

    public void addBooking(MTicket newBooking, MPayment mPayment) {
        port.create(newBooking);
    }

    public MTicket readTicketById(int id) {
        return port.readById(id);
    }

    public void upgradeSeatingClass(int ticketId, MTicket.SeatingClass newSeatingClass) throws NoSeatsAvailableException {
        MTicket ticket = readTicketById(ticketId);
        //TODO => s. usecase

    }

    public void upgradeLuggageWeight(int newWeight) throws IllegalArgumentException {
        //TODO => s. usecase
    }

    public void cancelTicket(MPerson person, int flightnum){
        //TODO => s. usecase
    }
}
