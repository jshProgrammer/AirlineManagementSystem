package de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Create;

import de.tjjf.Infrastructure.persistence.DBOperations.AbstractOperations.AbstractCreateOperation;
import de.tjjf.Infrastructure.persistence.entities.Airport;

public class AirportCreateImpl extends AbstractCreateOperation<Airport> {
    public AirportCreateImpl(Airport modelToPersist){
        super(modelToPersist);
    }
}
