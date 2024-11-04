package de.tjjf.Infrastructure.mapper;

import de.tjjf.Domain.models.MAirline;
import de.tjjf.Infrastructure.models.Airline;

public class AirlineMapper {

    public static Airline toEntity(MAirline mAirline) {
        return new Airline(
                mAirline.getName(),
                mAirline.getFoundationYear(),
                mAirline.getHeadQuarters()
        );
    }

    public static MAirline toDomain(Airline airline) {
        return new MAirline(
                airline.getName(),
                airline.getFoundationYear(),
                airline.getHeadQuarters()
        );
    }
}

