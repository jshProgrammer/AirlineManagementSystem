package de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Delete;

import de.tjjf.Infrastructure.persistence.DBOperations.AbstractOperations.AbstractDeleteOperation;
import de.tjjf.Infrastructure.persistence.entities.Airline;

public class AirlineDeleteImpl extends AbstractDeleteOperation<Airline, String> {
    public AirlineDeleteImpl(Class<Airline> type, String identifier){
        super(type, identifier);
    }
}
