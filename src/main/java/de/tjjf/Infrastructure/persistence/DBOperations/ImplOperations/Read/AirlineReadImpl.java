package de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Read;

import de.tjjf.Infrastructure.persistence.DBOperations.AbstractOperations.AbstractReadOperation;
import de.tjjf.Infrastructure.persistence.entities.Airline;

public class AirlineReadImpl extends AbstractReadOperation<Airline, String> {
    public AirlineReadImpl(String identifier){
        super(Airline.class, identifier);
    }
}
