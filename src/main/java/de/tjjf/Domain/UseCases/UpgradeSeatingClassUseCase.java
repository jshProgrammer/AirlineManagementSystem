package de.tjjf.Domain.UseCases;

import de.tjjf.Domain.Exceptions.NoSeatsAvailableException;
import de.tjjf.Domain.models.MTicket;
import de.tjjf.Domain.ports.DB.DataAccess;
import de.tjjf.Infrastructure.Client.ClientOperations.APIOperations.TicketAPIOperation;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Update.TicketUpdateImpl;
import de.tjjf.Infrastructure.persistence.mapper.TicketMapper;

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