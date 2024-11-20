package de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Delete;

import de.tjjf.Infrastructure.persistence.DBOperations.AbstractOperations.AbstractDeleteOperation;
import de.tjjf.Infrastructure.persistence.entities.Airport;

public class AirportDeleteImpl extends AbstractDeleteOperation<Airport, String> {
    public AirportDeleteImpl(Class<Airport> type, String identifier){
        super(type, identifier);
    }
}
