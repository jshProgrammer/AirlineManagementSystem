package de.tjjf.Infrastructure.persistence.mapper;

import de.tjjf.Domain.models.DomainAddress;
import de.tjjf.Domain.models.DomainAirline;
import de.tjjf.Infrastructure.persistence.entities.Airline;

public class AirlineMapper extends Mapper<DomainAirline, Airline> {

    public Airline toEntity(DomainAirline mAirline) {
        String address = AddressMapper.toEntity(mAirline.getAddress());
        return new Airline(
                mAirline.getName(),
                mAirline.getFoundationYear(),
                mAirline.getHeadQuarters(),
                mAirline.getEmail(),
                mAirline.getPhoneNumber(),
                address
        );
    }

    public DomainAirline toDomain(Airline airline) {
        DomainAddress object = AddressMapper.toDomain(airline.getAddress());
        return new DomainAirline(
                airline.getName(),
                airline.getFoundationYear(),
                airline.getHeadQuarters(),
                object,
                airline.getPhoneNumber(),
                airline.getMail()
        );
    }

}

