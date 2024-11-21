package de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Create;

import de.tjjf.Infrastructure.persistence.DBOperations.AbstractOperations.AbstractCreateOperation;
import de.tjjf.Infrastructure.persistence.entities.Airline;
import de.tjjf.Infrastructure.persistence.entities.Airplane;

import java.util.Date;

public class AirplaneCreateImpl extends AbstractCreateOperation<Airplane> {

        public AirplaneCreateImpl(Airplane modelToPersist) {
            super(modelToPersist);
        }

        public static void main(String[] args) {
            Airline a = new Airline("Lufthansa", new Date(1990), "München", "test;1;34534;Berlin;Germany", "0160123456", "testmail");
            new AirlineCreateImpl(a).execute();
            new AirplaneCreateImpl(new Airplane(123, "Boeing", "Test",200, 80, 50, a, true)).execute();
        }


}
