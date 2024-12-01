package de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Create;

import de.tjjf.Infrastructure.persistence.DBOperations.AbstractOperations.AbstractCreateOperation;
import de.tjjf.Infrastructure.persistence.entities.Airline;
import de.tjjf.Infrastructure.persistence.entities.Airplane;

import java.util.Date;

public class AirplaneCreateImpl extends AbstractCreateOperation<Airplane> {

        public AirplaneCreateImpl(Airplane modelToPersist) {
            super(modelToPersist);
        }



}
