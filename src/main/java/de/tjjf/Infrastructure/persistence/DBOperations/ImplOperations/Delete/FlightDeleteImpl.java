package de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Delete;

import de.tjjf.Infrastructure.persistence.DBOperations.AbstractOperations.AbstractDeleteOperation;
import de.tjjf.Infrastructure.persistence.entities.Flight;

public class FlightDeleteImpl extends AbstractDeleteOperation<Flight, Long> {
    public FlightDeleteImpl(Long identifier){
        super(Flight.class, identifier);
    }
}
