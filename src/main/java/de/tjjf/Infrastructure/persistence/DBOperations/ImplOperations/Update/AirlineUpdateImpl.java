package de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Update;

import de.tjjf.Infrastructure.persistence.DBOperations.AbstractOperations.AbstractUpdateOperation;
import de.tjjf.Infrastructure.persistence.entities.Airline;

public class AirlineUpdateImpl extends AbstractUpdateOperation<Airline, String> {
    public AirlineUpdateImpl(Airline modelToPersist){
        super(modelToPersist);
    }
}
