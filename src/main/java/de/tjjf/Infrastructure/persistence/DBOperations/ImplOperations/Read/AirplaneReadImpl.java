package de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Read;

import de.tjjf.Infrastructure.persistence.DBOperations.AbstractOperations.AbstractReadOperation;
import de.tjjf.Infrastructure.persistence.entities.Airplane;

public class AirplaneReadImpl extends AbstractReadOperation<Airplane, Integer> {
    public AirplaneReadImpl(int identifier){
        super(Airplane.class, identifier);
    }
}
