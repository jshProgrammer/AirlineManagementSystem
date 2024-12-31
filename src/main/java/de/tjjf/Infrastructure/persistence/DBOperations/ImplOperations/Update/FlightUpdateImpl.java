package de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Update;

import de.tjjf.Infrastructure.persistence.DBOperations.AbstractOperations.AbstractUpdateOperation;
import de.tjjf.Infrastructure.persistence.entities.Flight;

public class FlightUpdateImpl extends AbstractUpdateOperation<Flight, Long> {
    public FlightUpdateImpl(Flight modelToPersist, Long flightNum){
        super(modelToPersist, flightNum);
    }
}
