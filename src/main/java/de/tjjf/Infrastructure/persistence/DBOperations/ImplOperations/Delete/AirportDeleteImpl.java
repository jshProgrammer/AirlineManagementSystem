package de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Delete;

import de.tjjf.Infrastructure.persistence.DBOperations.AbstractOperations.AbstractDeleteOperation;
import de.tjjf.Infrastructure.persistence.entities.Airport;

public class AirportDeleteImpl extends AbstractDeleteOperation<Airport, String> {
    public AirportDeleteImpl(String identifier){
        super(Airport.class, identifier);
    }
}
