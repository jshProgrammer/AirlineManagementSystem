package de.tjjf.Infrastructure.persistence.mapper;

import de.tjjf.Domain.models.MAdress;
import de.tjjf.Domain.models.MPerson;
import de.tjjf.Infrastructure.persistence.entities.Person;

public class PersonMapper extends Mapper<MPerson, Person>{

    public Person toEntity(MPerson mPerson){
        String adress = AdressMapper.toEntity(mPerson.getAddress());
        return new Person(
                mPerson.getPersonId(),
                mPerson.getFirstName(),
                mPerson.getMiddleNames(),
                mPerson.getLastName(),
                mPerson.getDateOfBirth(),
                mPerson.getPhonenumber(),
                adress,
                mPerson.getEmail(),
                mPerson.getHashedPassword()
        );
    }

    public MPerson toDomain(Person person){
        MAdress object = AdressMapper.toDomain(person.getAddress());
        return new MPerson(
                person.getPersonId(),
                person.getFirstName(),
                person.getMiddleNames(),
                person.getLastName(),
                person.getDateOfBirth(),
                person.getPhonenumber(),
                object,
                person.getEmail(),
                person.getPassword()
        );
    }
}
