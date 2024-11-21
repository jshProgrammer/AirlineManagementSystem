package de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Create;

import de.tjjf.Infrastructure.persistence.DBOperations.AbstractOperations.AbstractCreateOperation;
import de.tjjf.Infrastructure.persistence.entities.Airline;

import java.util.Date;

public class AirlineCreateImpl extends AbstractCreateOperation<Airline> {
    public AirlineCreateImpl(Airline modelToPersist) {
        super(modelToPersist);
    }
}
