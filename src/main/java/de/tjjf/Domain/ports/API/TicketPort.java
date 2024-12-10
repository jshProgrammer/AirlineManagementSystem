package de.tjjf.Domain.ports.API;

import de.tjjf.Domain.Exceptions.NoSeatsAvailableException;
import de.tjjf.Domain.models.MPerson;
import de.tjjf.Domain.models.MTicket;

public interface TicketPort {
    void addBooking(MTicket newBooking);
    MTicket readTicketById(int id);
    void upgradeSeatingClass(MTicket.SeatingClass newSeatingClass) throws NoSeatsAvailableException;
    void upgradeLuggageWeight(int newWeight) throws IllegalArgumentException;
    void cancelTicket(MPerson person, int flightnum);
}
