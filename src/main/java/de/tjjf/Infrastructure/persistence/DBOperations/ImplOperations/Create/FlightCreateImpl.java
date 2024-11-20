package de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Create;

import de.tjjf.Infrastructure.persistence.DBOperations.AbstractOperations.AbstractCreateOperation;
import de.tjjf.Infrastructure.persistence.entities.Flight;

public class FlightCreateImpl extends AbstractCreateOperation<Flight> {
    public FlightCreateImpl(Flight modelToPersist){
        super(modelToPersist);
    }
}
