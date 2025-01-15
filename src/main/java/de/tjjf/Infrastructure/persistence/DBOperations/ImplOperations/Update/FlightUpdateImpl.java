package de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Update;

import de.tjjf.Infrastructure.persistence.DBOperations.AbstractOperations.AbstractUpdateOperation;
import de.tjjf.Infrastructure.persistence.entities.Employee;
import de.tjjf.Infrastructure.persistence.entities.Flight;

public class FlightUpdateImpl extends AbstractUpdateOperation<Flight, Long> {
    Flight modelToPersist;

    public FlightUpdateImpl(Flight modelToPersist, Long flightNum){
        super(modelToPersist, flightNum);
        this.modelToPersist = modelToPersist;
    }

    protected void prePersist() {

        Employee copilot = em.find( Employee.class, modelToPersist.getCopilot().getPersonId());
        Employee pilot = em.find( Employee.class, modelToPersist.getPilot().getPersonId());

        if (pilot == null) {
            throw new RuntimeException("Pilot with ID " + modelToPersist.getPilot().getPersonId() + " not found");
        }
        if (copilot == null) {
            throw new RuntimeException("Copilot with ID " + modelToPersist.getCopilot().getPersonId() + " not found");
        }

        modelToPersist.setPilot(pilot);
        modelToPersist.setCopilot(copilot);
    }

    protected void postPersist() {
        em.close();
    }
}
