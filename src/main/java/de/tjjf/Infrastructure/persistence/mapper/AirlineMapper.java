package de.tjjf.Infrastructure.persistence.mapper;

import de.tjjf.Domain.models.MAdress;
import de.tjjf.Domain.models.MAirline;
import de.tjjf.Infrastructure.persistence.entities.Airline;

public class AirlineMapper extends Mapper<MAirline, Airline> {

    public Airline toEntity(MAirline mAirline) {
        String adress = AdressMapper.toEntity(mAirline.getAdress());
        return new Airline(
                mAirline.getName(),
                mAirline.getFoundationYear(),
                mAirline.getHeadQuarters(),
                mAirline.geteMail(),
                mAirline.getPhoneNumber(),
                adress
        );
    }

    public MAirline toDomain(Airline airline) {
        MAdress object = AdressMapper.toDomain(airline.getAdress());
        return new MAirline(
                airline.getName(),
                airline.getFoundationYear(),
                airline.getHeadQuarters(),
                object,
                airline.getPhoneNumber(),
                airline.geteMail()
        );
    }

}

