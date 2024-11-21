package de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Read;

import de.tjjf.Infrastructure.persistence.DBOperations.AbstractOperations.AbstractReadOperation;
import de.tjjf.Infrastructure.persistence.entities.Person;

public class PersonReadImpl extends AbstractReadOperation<Person, Integer> {
    public PersonReadImpl(int identifier){
        super(Person.class, identifier);
    }
}
