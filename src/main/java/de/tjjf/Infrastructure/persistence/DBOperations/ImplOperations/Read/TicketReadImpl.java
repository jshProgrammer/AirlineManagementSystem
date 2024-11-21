package de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Read;

import de.tjjf.Infrastructure.persistence.DBOperations.AbstractOperations.AbstractReadOperation;
import de.tjjf.Infrastructure.persistence.entities.Ticket;

public class TicketReadImpl extends AbstractReadOperation<Ticket, Integer> {
    public TicketReadImpl(int identifier){
        super(Ticket.class, identifier);
    }
}
