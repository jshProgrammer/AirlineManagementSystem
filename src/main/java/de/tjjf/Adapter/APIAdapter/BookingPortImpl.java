package de.tjjf.Adapter.APIAdapter;

import de.tjjf.Adapter.DatabaseAdapter.MAirplaneRepositoryImpl;
import de.tjjf.Adapter.DatabaseAdapter.MTicketRepositoryImpl;
import de.tjjf.Domain.Exceptions.NoSeatsAvailableException;
import de.tjjf.Domain.UseCases.Services.AirplaneService;
import de.tjjf.Domain.UseCases.Services.TicketService;
import de.tjjf.Domain.models.MPayment;
import de.tjjf.Domain.models.MPerson;
import de.tjjf.Domain.models.MTicket;
import de.tjjf.Domain.ports.API.TicketPort;

public class BookingPortImpl implements TicketPort {
    @Override
    public MTicket addBooking(MTicket newBooking, MPayment mPayment) {
        return new TicketService(new MTicketRepositoryImpl()).addBooking(newBooking, mPayment);

    }

    @Override
    public MTicket readTicketById(int id) {
        return new TicketService(new MTicketRepositoryImpl()).readTicketById(id);
    }

    //TODO: müssen wir hier nicht auch noch die Ticket-Nr/ das Ticket-Objekt übergeben
    @Override
    public void upgradeSeatingClass(int ticketId, MTicket.SeatingClass newSeatingClass) throws NoSeatsAvailableException{
        new TicketService(new MTicketRepositoryImpl()).upgradeSeatingClass(ticketId, newSeatingClass);
    }

    @Override
    public void upgradeLuggageWeight(int ticketId, int newWeight) throws IllegalArgumentException {
        new TicketService(new MTicketRepositoryImpl()).upgradeLuggageWeight(ticketId, newWeight);
    }

    @Override
    public void cancelTicket(MPerson person, int flightnum){
        new TicketService(new MTicketRepositoryImpl()).cancelTicket(person, flightnum);
    }
}
