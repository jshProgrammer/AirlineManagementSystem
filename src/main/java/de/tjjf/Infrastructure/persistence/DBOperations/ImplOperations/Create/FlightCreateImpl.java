package de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Create;

import de.tjjf.Infrastructure.persistence.DBOperations.AbstractOperations.AbstractCreateOperation;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Read.EmployeeReadImpl;
import de.tjjf.Infrastructure.persistence.EntityManagerFactorySingleton;
import de.tjjf.Infrastructure.persistence.entities.Employee;
import de.tjjf.Infrastructure.persistence.entities.Flight;
import jakarta.persistence.EntityManager;

public class FlightCreateImpl extends AbstractCreateOperation<Flight> {
    Flight modelToPersist;

    public FlightCreateImpl(Flight modelToPersist){
        super(modelToPersist);
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
