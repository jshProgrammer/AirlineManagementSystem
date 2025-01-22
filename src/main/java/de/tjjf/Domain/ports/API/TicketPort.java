package de.tjjf.Domain.ports.API;

import de.tjjf.Domain.Exceptions.NoSeatsAvailableException;
import de.tjjf.Domain.models.DomainPayment;
import de.tjjf.Domain.models.DomainPerson;
import de.tjjf.Domain.models.DomainTicket;

public interface TicketPort {
    DomainTicket addBooking(DomainTicket newBooking, DomainPayment payment);
    DomainTicket readTicketById(long id);
    void upgradeSeatingClass(long ticketId, DomainTicket.SeatingClass newSeatingClass) throws NoSeatsAvailableException;
    void upgradeLuggageWeight(long ticketId, int newWeight) throws IllegalArgumentException;
    void cancelTicket(DomainPerson person, long flightnum);
}
