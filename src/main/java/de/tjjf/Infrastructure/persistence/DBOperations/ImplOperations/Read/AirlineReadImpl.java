package de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Read;

import de.tjjf.Infrastructure.persistence.DBOperations.AbstractOperations.AbstractReadOperation;
import de.tjjf.Infrastructure.persistence.entities.Airline;

public class AirlineReadImpl extends AbstractReadOperation<Airline, String> {
    public AirlineReadImpl(Class<Airline> type, String identifier){
        super(type, identifier);
    }
}
