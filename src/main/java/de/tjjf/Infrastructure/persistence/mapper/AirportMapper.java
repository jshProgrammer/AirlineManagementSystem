package de.tjjf.Infrastructure.persistence.mapper;

import de.tjjf.Domain.models.DomainAirport;
import de.tjjf.Infrastructure.persistence.entities.Airport;

public class AirportMapper extends Mapper <DomainAirport, Airport>{

    public Airport toEntity(DomainAirport mAirport){
        return new Airport(
                mAirport.getCode(),
                mAirport.getName(),
                mAirport.getCountry(),
                mAirport.getCity(),
                mAirport.getTimezone()
        );
    }

    public DomainAirport toDomain(Airport airport){
        return new DomainAirport(
                airport.getCode(),
                airport.getName(),
                airport.getCountry(),
                airport.getCity(),
                airport.getTimezone()
        );
    }
}
