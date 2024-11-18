package de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Update;

import de.tjjf.Infrastructure.persistence.DBOperations.AbstractOperations.AbstractUpdateOperation;
import de.tjjf.Infrastructure.persistence.entities.Person;

public class PersonUpdateImpl extends AbstractUpdateOperation<Person> {
    public PersonUpdateImpl(Person modelToPersist){
        super(modelToPersist);
    }
}
