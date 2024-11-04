package de.tjjf.Infrastructure.mapper;

import de.tjjf.Domain.models.MAirport;
import de.tjjf.Infrastructure.models.Airport;

public class AirportMapper {

    public static Airport toEntity(MAirport mAirport){
        return new Airport(
                mAirport.getCode(),
                mAirport.getName(),
                mAirport.getCountry(),
                mAirport.getCity(),
                mAirport.getTimezone()
        );
    }

    public static MAirport toDomain(Airport airport){
        return new MAirport(
                airport.getCode(),
                airport.getName(),
                airport.getCountry(),
                airport.getCity(),
                airport.getTimezone()
        );
    }
}
