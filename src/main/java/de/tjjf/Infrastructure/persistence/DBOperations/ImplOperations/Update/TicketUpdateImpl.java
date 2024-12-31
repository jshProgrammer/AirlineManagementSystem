package de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Update;

import de.tjjf.Infrastructure.persistence.DBOperations.AbstractOperations.AbstractUpdateOperation;
import de.tjjf.Infrastructure.persistence.entities.Ticket;

public class TicketUpdateImpl extends AbstractUpdateOperation<Ticket, Integer> {
    public TicketUpdateImpl(Ticket modelToPersist, Integer ticketId){
        super(modelToPersist, ticketId);
    }
}
