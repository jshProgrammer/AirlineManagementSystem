package de.tjjf.Adapter.APIAdapter;

import de.tjjf.Adapter.DatabaseAdapter.MClientRepositoryImpl;
import de.tjjf.Adapter.DatabaseAdapter.MEmployeeRepositoryImpl;
import de.tjjf.Adapter.DatabaseAdapter.MTicketRepositoryImpl;
import de.tjjf.Domain.Exceptions.NoSeatsAvailableException;
import de.tjjf.Domain.UseCases.Services.TicketService;
import de.tjjf.Domain.models.DomainPayment;
import de.tjjf.Domain.models.DomainPerson;
import de.tjjf.Domain.models.DomainTicket;
import de.tjjf.Domain.ports.API.TicketPort;

public class BookingPortImpl implements TicketPort {
    @Override
    public DomainTicket addBooking(DomainTicket newBooking, DomainPayment mPayment) {
        return new TicketService(new MTicketRepositoryImpl(), new MClientRepositoryImpl(), new MEmployeeRepositoryImpl()).addBooking(newBooking, mPayment);

    }

    @Override
    public DomainTicket readTicketById(long id) {
        return new TicketService(new MTicketRepositoryImpl()).readTicketById(id);
    }

    @Override
    public void upgradeSeatingClass(long ticketId, DomainTicket.SeatingClass newSeatingClass) throws NoSeatsAvailableException{
        new TicketService(new MTicketRepositoryImpl()).upgradeSeatingClass(ticketId, newSeatingClass);
    }

    @Override
    public void upgradeLuggageWeight(long ticketId, int newWeight) throws IllegalArgumentException {
        new TicketService(new MTicketRepositoryImpl()).upgradeLuggageWeight(ticketId, newWeight);
    }

    @Override
    public void cancelTicket(DomainPerson person, long flightnum){
        new TicketService(new MTicketRepositoryImpl(), new MClientRepositoryImpl(), new MEmployeeRepositoryImpl()).cancelTicket(person, flightnum);
    }
}
