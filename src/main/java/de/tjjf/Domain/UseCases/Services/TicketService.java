package de.tjjf.Domain.UseCases.Services;

import de.tjjf.Domain.Exceptions.NoSeatsAvailableException;
import de.tjjf.Domain.UseCases.AddBookingUseCase;
import de.tjjf.Domain.UseCases.CancelTicketUseCase;
import de.tjjf.Domain.models.MPayment;
import de.tjjf.Domain.models.MPerson;
import de.tjjf.Domain.models.MTicket;
import de.tjjf.Domain.ports.DB.DataAccess;

public class TicketService {
    DataAccess.MTicketRepository port;

    public TicketService(DataAccess.MTicketRepository port) {
        this.port = port;
    }

    //TODO: Muss hier nicht AddBooking Use Case dranhängen
    public void addBooking(MTicket newBooking, MPayment mPayment) {
        AddBookingUseCase.addBooking(newBooking, mPayment);
        port.create(newBooking);
    }

    public MTicket readTicketById(int id) {
        return port.readById(id);
    }

    public void upgradeSeatingClass(int ticketId, MTicket.SeatingClass newSeatingClass) throws NoSeatsAvailableException {
        MTicket ticket = readTicketById(ticketId);
        //TODO: So ungefähr
        upgradeSeatingClass(ticketId, newSeatingClass);
        //TODO => s. usecase

    }

    public void upgradeLuggageWeight(int ticketId, int newWeight) throws IllegalArgumentException {
        MTicket ticket = port.readById(ticketId);
        ticket.upgradeLuggageWeight(newWeight);
        port.update(ticket);
    }

    public void cancelTicket(MPerson person, int flightnum){
        CancelTicketUseCase.cancelTicket(person, flightnum);
    }
}
