package de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Delete;

import de.tjjf.Infrastructure.persistence.DBOperations.AbstractOperations.AbstractDeleteOperation;
import de.tjjf.Infrastructure.persistence.entities.Airline;

public class AirlineDeleteImpl extends AbstractDeleteOperation<Airline, String> {
    public AirlineDeleteImpl(String identifier){
        super(Airline.class, identifier);
    }
}
