package de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Read;

import de.tjjf.Infrastructure.persistence.DBOperations.AbstractOperations.AbstractReadOperation;
import de.tjjf.Infrastructure.persistence.entities.Flight;

public class FlightReadImpl extends AbstractReadOperation<Flight, Long> {
    public FlightReadImpl(long identifier){
        super(Flight.class, identifier);
    }
}
