package de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Delete;

import de.tjjf.Infrastructure.persistence.DBOperations.AbstractOperations.AbstractDeleteOperation;
import de.tjjf.Infrastructure.persistence.entities.Ticket;

public class TicketDeleteImpl extends AbstractDeleteOperation<Ticket, Integer> {
    public TicketDeleteImpl(int identifier){
        super(Ticket.class, identifier);
    }
}
