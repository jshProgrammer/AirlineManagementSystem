package de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Read;

import de.tjjf.Infrastructure.persistence.DBOperations.AbstractOperations.AbstractReadOperation;
import de.tjjf.Infrastructure.persistence.entities.Airport;

public class AirportCreateImpl extends AbstractReadOperation<Airport, String> {
    public AirportCreateImpl(Class<Airport> type, String identifier){
        super(type, identifier);
    }
}
