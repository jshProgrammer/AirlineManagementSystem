package de.tjjf.Adapter.APIAdapter;

import de.tjjf.Adapter.DatabaseAdapter.MClientRepositoryImpl;
import de.tjjf.Adapter.DatabaseAdapter.MEmployeeRepositoryImpl;
import de.tjjf.Adapter.DatabaseAdapter.MTicketRepositoryImpl;
import de.tjjf.Domain.Exceptions.NoSeatsAvailableException;
import de.tjjf.Domain.UseCases.Services.TicketService;
import de.tjjf.Domain.models.MPayment;
import de.tjjf.Domain.models.MPerson;
import de.tjjf.Domain.models.MTicket;
import de.tjjf.Domain.ports.API.TicketPort;

public class BookingPortImpl implements TicketPort {
    @Override
    public MTicket addBooking(MTicket newBooking, MPayment mPayment) {
        return new TicketService(new MTicketRepositoryImpl(), new MClientRepositoryImpl(), new MEmployeeRepositoryImpl()).addBooking(newBooking, mPayment);

    }

    @Override
    public MTicket readTicketById(long id) {
        return new TicketService(new MTicketRepositoryImpl()).readTicketById(id);
    }

    @Override
    public void upgradeSeatingClass(long ticketId, MTicket.SeatingClass newSeatingClass) throws NoSeatsAvailableException{
        new TicketService(new MTicketRepositoryImpl()).upgradeSeatingClass(ticketId, newSeatingClass);
    }

    @Override
    public void upgradeLuggageWeight(long ticketId, int newWeight) throws IllegalArgumentException {
        new TicketService(new MTicketRepositoryImpl()).upgradeLuggageWeight(ticketId, newWeight);
    }

    @Override
    public void cancelTicket(MPerson person, long flightnum){
        new TicketService(new MTicketRepositoryImpl(), new MClientRepositoryImpl(), new MEmployeeRepositoryImpl()).cancelTicket(person, flightnum);
    }
}
