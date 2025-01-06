package de.tjjf.Domain.UseCases.Services;

import de.tjjf.Domain.Exceptions.NoSeatsAvailableException;
import de.tjjf.Domain.UseCases.AddBookingUseCase;
import de.tjjf.Domain.UseCases.AuthenticationUseCase;
import de.tjjf.Domain.UseCases.AuthorizedUseCase;
import de.tjjf.Domain.UseCases.CancelTicketUseCase;
import de.tjjf.Domain.models.MPayment;
import de.tjjf.Domain.models.MPerson;
import de.tjjf.Domain.models.MTicket;
import de.tjjf.Domain.ports.DB.DataAccess;

public class TicketService extends AuthorizedUseCase {
    DataAccess.MTicketRepository port;

    public TicketService(DataAccess.MTicketRepository port) {
        super(AuthenticationUseCase.getInstance());
        this.port = port;
    }

    //TODO: Muss hier nicht AddBooking Use Case dranhängen
    public MTicket addBooking(MTicket newBooking, MPayment mPayment) {
        //new CancelTicketUseCase().authorize();
        if(AddBookingUseCase.addBooking(newBooking, mPayment)){
            return port.create(newBooking);
        }
        return null;
    }

    public MTicket readTicketById(long id) {
        //new CancelTicketUseCase().authorize();
        return port.readById(id);
    }

    public void upgradeSeatingClass(long ticketId, MTicket.SeatingClass newSeatingClass) throws NoSeatsAvailableException {
        //new CancelTicketUseCase().authorize();
        MTicket ticket = readTicketById(ticketId);
        //TODO: So ungefähr
        upgradeSeatingClass(ticketId, newSeatingClass);
        //TODO => s. usecase

    }

    public void upgradeLuggageWeight(long ticketId, int newWeight) throws IllegalArgumentException {
        //new CancelTicketUseCase().authorize();
        MTicket ticket = port.readById(ticketId);
        ticket.upgradeLuggageWeight(newWeight);
        port.update(ticket);
    }

    public void cancelTicket(MPerson person, int flightnum){
        //new CancelTicketUseCase().authorize();
        CancelTicketUseCase.cancelTicket(person, flightnum);
    }
}
