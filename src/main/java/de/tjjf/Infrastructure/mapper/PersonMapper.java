package de.tjjf.Infrastructure.mapper;

import de.tjjf.Domain.models.MPerson;
import de.tjjf.Infrastructure.models.Person;

public class PersonMapper {

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
