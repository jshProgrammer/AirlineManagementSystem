package de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Read;

import de.tjjf.Infrastructure.persistence.DBOperations.AbstractOperations.AbstractReadOperation;
import de.tjjf.Infrastructure.persistence.entities.Airport;

public class AirportReadImpl extends AbstractReadOperation<Airport, String> {
    public AirportReadImpl(String identifier){
        super(Airport.class, identifier);
    }
}
