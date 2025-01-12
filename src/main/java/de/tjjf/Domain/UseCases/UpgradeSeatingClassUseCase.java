package de.tjjf.Domain.UseCases;

import de.tjjf.Domain.Exceptions.NoSeatsAvailableException;
import de.tjjf.Domain.models.MTicket;
import de.tjjf.Infrastructure.Client.ClientOperations.APIOperations.TicketAPIOperation;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Update.TicketUpdateImpl;
import de.tjjf.Infrastructure.persistence.mapper.TicketMapper;

public class UpgradeSeatingClassUseCase {
    public static boolean isSeatingUpdateAvailable( MTicket ticket, MTicket.SeatingClass newDesiredSeatingClass ) throws NoSeatsAvailableException {

        try{
            ticket.upgradeSeatingClass(newDesiredSeatingClass);
        }catch (NoSeatsAvailableException e){
            return false;
        }
        new TicketUpdateImpl(new TicketMapper().toEntity(ticket), ticket.getTicketId()).execute();
        return true;
    }
}