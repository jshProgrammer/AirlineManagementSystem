package de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Delete;

import de.tjjf.Infrastructure.persistence.DBOperations.AbstractOperations.AbstractDeleteOperation;
import de.tjjf.Infrastructure.persistence.entities.Person;

public class PersonDeleteImpl extends AbstractDeleteOperation<Person, Integer> {
    public PersonDeleteImpl(int identifier){
        super(Person.class, identifier);
    }
}
