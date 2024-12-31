package de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Update;

import de.tjjf.Infrastructure.persistence.DBOperations.AbstractOperations.AbstractUpdateOperation;
import de.tjjf.Infrastructure.persistence.entities.Airport;

public class AirportUpdateImpl extends AbstractUpdateOperation<Airport, String> {
    public AirportUpdateImpl(Airport modelToPersist, String code){
        super(modelToPersist, code);
    }
}
