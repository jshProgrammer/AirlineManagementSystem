package de.tjjf.Domain.UseCases;

import de.tjjf.Domain.Exceptions.NoSeatsAvailableException;
import de.tjjf.Domain.models.MTicket;
import de.tjjf.Domain.ports.DB.DataAccess;

public class UpgradeSeatingClassUseCase {
    DataAccess.MTicketRepository ticketPort;

    public UpgradeSeatingClassUseCase(DataAccess.MTicketRepository ticketPort) {
        this.ticketPort = ticketPort;
    }

    public boolean updateSeatingClassIfAvailable( MTicket ticket, MTicket.SeatingClass newDesiredSeatingClass ) throws NoSeatsAvailableException {

        try{
            ticket.upgradeSeatingClass(newDesiredSeatingClass);
        }catch (NoSeatsAvailableException e){
            return false;
        }
        ticketPort.update(ticket);
        return true;
    }
}