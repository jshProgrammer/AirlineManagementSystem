package de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Update;

import de.tjjf.Infrastructure.persistence.DBOperations.AbstractOperations.AbstractUpdateOperation;
import de.tjjf.Infrastructure.persistence.entities.Flight;
import de.tjjf.Infrastructure.persistence.entities.Ticket;

public class TicketUpdateImpl extends AbstractUpdateOperation<Ticket, Long> {
   Ticket modelToPersist;

    public TicketUpdateImpl(Ticket modelToPersist, Long ticketId){
        super(modelToPersist, ticketId);
        this.modelToPersist = modelToPersist;
    }

    protected void prePersist() {
        Flight managedFlight = em.find(Flight.class, modelToPersist.getFlight().getFlightNum());
        if (managedFlight == null) {
            throw new RuntimeException("Flight not found");
        }
        modelToPersist.setFlightNum(managedFlight);

        //Client managedClient = em.find(Client.class, modelToPersist.getClient().getPersonId());
        //modelToPersist.setClient(managedClient);
    }

    protected void postPersist() {
        em.close();
    }
}
