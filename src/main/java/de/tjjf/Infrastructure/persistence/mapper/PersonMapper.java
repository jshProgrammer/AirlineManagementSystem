package de.tjjf.Infrastructure.persistence.mapper;

import de.tjjf.Domain.models.MPerson;
import de.tjjf.Infrastructure.persistence.entities.Person;

public class PersonMapper extends Mapper<MPerson, Person>{

    public Person toEntity(MPerson mPerson){
        return new Person(
                mPerson.getPersonId(),
                mPerson.getFirstName(),
                mPerson.getMiddleNames(),
                mPerson.getLastName(),
                mPerson.getDateOfBirth(),
                mPerson.getPhonenumber(),
                mPerson.getAddress(),
                mPerson.getEmail(),
                mPerson.getPassword()
        );
    }

    public MPerson toDomain(Person person){
        return new MPerson(
                person.getPersonId(),
                person.getFirstName(),
                person.getMiddleNames(),
                person.getLastName(),
                person.getDateOfBirth(),
                person.getPhonenumber(),
                person.getAddress(),
                person.getEmail(),
                person.getPassword()
        );
    }
}
