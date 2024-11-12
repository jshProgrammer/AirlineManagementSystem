package de.tjjf.Infrastructure.persistence.mapper;

import de.tjjf.Domain.models.MAirline;
import de.tjjf.Infrastructure.persistence.entities.Airline;

public class AirlineMapper extends Mapper<MAirline, Airline> {

    public Airline toEntity(MAirline mAirline) {
        return new Airline(
                mAirline.getName(),
                mAirline.getFoundationYear(),
                mAirline.getHeadQuarters()
        );
    }

    public MAirline toDomain(Airline airline) {
        return new MAirline(
                airline.getName(),
                airline.getFoundationYear(),
                airline.getHeadQuarters()
        );
    }

}

