package de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Delete;

import de.tjjf.Infrastructure.persistence.DBOperations.AbstractOperations.AbstractDeleteOperation;
import de.tjjf.Infrastructure.persistence.entities.Airplane;

public class AirplaneDeleteImpl extends AbstractDeleteOperation<Airplane, Integer> {
    public AirplaneDeleteImpl(Class<Airplane> type, int identifier){
        super(type, identifier);
    }
}
