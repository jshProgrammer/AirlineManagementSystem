package de.tjjf.Infrastructure.persistence.mapper;

import de.tjjf.Domain.models.MAirport;
import de.tjjf.Infrastructure.persistence.entities.Airport;

public class AirportMapper extends Mapper <MAirport, Airport>{

    public Airport toEntity(MAirport mAirport){
        return new Airport(
                mAirport.getCode(),
                mAirport.getName(),
                mAirport.getCountry(),
                mAirport.getCity(),
                mAirport.getTimezone()
        );
    }

    public MAirport toDomain(Airport airport){
        return new MAirport(
                airport.getCode(),
                airport.getName(),
                airport.getCountry(),
                airport.getCity(),
                airport.getTimezone()
        );
    }
}
