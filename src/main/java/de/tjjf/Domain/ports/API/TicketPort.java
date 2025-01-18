package de.tjjf.Domain.ports.API;

import de.tjjf.Domain.Exceptions.NoSeatsAvailableException;
import de.tjjf.Domain.models.MPayment;
import de.tjjf.Domain.models.MPerson;
import de.tjjf.Domain.models.MTicket;

public interface TicketPort {
    MTicket addBooking(MTicket newBooking, MPayment payment);
    MTicket readTicketById(long id);
    void upgradeSeatingClass(long ticketId, MTicket.SeatingClass newSeatingClass) throws NoSeatsAvailableException;
    void upgradeLuggageWeight(long ticketId, int newWeight) throws IllegalArgumentException;
    void cancelTicket(MPerson person, long flightnum);
}
