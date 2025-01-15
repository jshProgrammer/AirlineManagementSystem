package de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Create;

import de.tjjf.Infrastructure.persistence.DBOperations.AbstractOperations.AbstractCreateOperation;
import de.tjjf.Infrastructure.persistence.entities.Client;
import de.tjjf.Infrastructure.persistence.entities.Employee;
import de.tjjf.Infrastructure.persistence.entities.Flight;
import de.tjjf.Infrastructure.persistence.entities.Ticket;

public class TicketCreateImpl extends AbstractCreateOperation<Ticket> {
    Ticket modelToPersist;

    public TicketCreateImpl(Ticket modelToPersist){
        super(modelToPersist);

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
