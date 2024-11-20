package de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Create;

import de.tjjf.Infrastructure.persistence.DBOperations.AbstractOperations.AbstractCreateOperation;
import de.tjjf.Infrastructure.persistence.entities.Ticket;

public class TicketCreateImpl extends AbstractCreateOperation<Ticket> {
    public TicketCreateImpl(Ticket modelToPersist){
        super(modelToPersist);
    }
}
