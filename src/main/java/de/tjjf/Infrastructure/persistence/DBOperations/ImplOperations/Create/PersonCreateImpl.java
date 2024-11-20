package de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Create;

import de.tjjf.Infrastructure.persistence.DBOperations.AbstractOperations.AbstractCreateOperation;
import de.tjjf.Infrastructure.persistence.entities.Airline;
import de.tjjf.Infrastructure.persistence.entities.Person;

public class PersonCreateImpl extends AbstractCreateOperation<Person> {
    public PersonCreateImpl(Person modelToPersist){
        super(modelToPersist);
    }
}
