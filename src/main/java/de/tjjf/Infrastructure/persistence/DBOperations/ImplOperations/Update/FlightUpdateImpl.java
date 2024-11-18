package de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Update;

import de.tjjf.Infrastructure.persistence.DBOperations.AbstractOperations.AbstractUpdateOperation;
import de.tjjf.Infrastructure.persistence.entities.Flight;

public class FlightUpdateImpl extends AbstractUpdateOperation<Flight> {
    public FlightUpdateImpl(Flight modelToPersist){
        super(modelToPersist);
    }
}
