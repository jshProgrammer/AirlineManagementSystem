package de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Update;

import de.tjjf.Infrastructure.persistence.DBOperations.AbstractOperations.AbstractUpdateOperation;
import de.tjjf.Infrastructure.persistence.entities.Airplane;

public class AirplaneUpdateImpl extends AbstractUpdateOperation<Airplane> {
    public AirplaneUpdateImpl(Airplane modelToPersist){
        super(modelToPersist);
    }
}
