package de.tjjf.Infrastructure.persistence.mapper;

import de.tjjf.Domain.models.MAddress;
import de.tjjf.Domain.models.MAirline;
import de.tjjf.Infrastructure.persistence.entities.Airline;

public class AirlineMapper extends Mapper<MAirline, Airline> {

    public Airline toEntity(MAirline mAirline) {
        String adress = AdressMapper.toEntity(mAirline.getAddress());
        return new Airline(
                mAirline.getName(),
                mAirline.getFoundationYear(),
                mAirline.getHeadQuarters(),
                mAirline.getEmail(),
                mAirline.getPhoneNumber(),
                adress
        );
    }

    public MAirline toDomain(Airline airline) {
        MAddress object = AdressMapper.toDomain(airline.getAddress());
        return new MAirline(
                airline.getName(),
                airline.getFoundationYear(),
                airline.getHeadQuarters(),
                object,
                airline.getPhoneNumber(),
                airline.getMail()
        );
    }

}

