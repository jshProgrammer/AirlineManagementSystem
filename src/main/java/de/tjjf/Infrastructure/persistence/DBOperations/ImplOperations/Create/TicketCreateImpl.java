package de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Create;

import de.tjjf.Infrastructure.persistence.DBOperations.AbstractOperations.AbstractCreateOperation;
import de.tjjf.Infrastructure.persistence.entities.Client;
import de.tjjf.Infrastructure.persistence.entities.Employee;
import de.tjjf.Infrastructure.persistence.entities.Ticket;

public class TicketCreateImpl extends AbstractCreateOperation<Ticket> {
    Ticket modelToPersist;

    public TicketCreateImpl(Ticket modelToPersist){
        super(modelToPersist);
        this.modelToPersist = modelToPersist;
    }

    protected void prePersist() {
        Client client = null;
        Employee employee = null;

        if(modelToPersist.getEmployee() == null) {
            client = em.find(Client.class, modelToPersist.getClient().getPersonId());
        } else {
            employee = em.find(Employee.class, modelToPersist.getEmployee().getPersonId());
        }

        if (client == null && employee == null) {
            throw new RuntimeException("Pilot with ID " + modelToPersist.getClient().getPersonId() + " not found");
        }

        if(client != null) modelToPersist.setClient(client);
        else modelToPersist.setEmployee(employee);
    }

    protected void postPersist() {
        em.close();
    }
}
