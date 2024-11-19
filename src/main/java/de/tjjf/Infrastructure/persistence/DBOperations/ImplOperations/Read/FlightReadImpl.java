package de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Read;

import de.tjjf.Infrastructure.persistence.DBOperations.AbstractOperations.AbstractReadOperation;
import de.tjjf.Infrastructure.persistence.entities.Flight;

public class FlightReadImpl extends AbstractReadOperation<Flight, Long> {
    public FlightReadImpl(Class<Flight> type, long identifier){
        super(type, identifier);
    }
}
