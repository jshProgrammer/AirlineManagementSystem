package de.tjjf.Infrastructure.api.mapper;

import de.tjjf.Domain.models.DomainAirport;
import de.tjjf.Infrastructure.api.models.APIAirport;

public class APIAirportMapper extends AbstractAPIMapper<APIAirport, DomainAirport>{
    @Override
    public APIAirport toAPIEntity(DomainAirport mAirport) {
        return new APIAirport(
                mAirport.getCode(),
                mAirport.getName(),
                mAirport.getCountry(),
                mAirport.getCity(),
                mAirport.getTimezone()
        );
    }

    @Override
    public DomainAirport toDomainEntity(APIAirport apiAirport) {
        return new DomainAirport(
                apiAirport.getCode(),
                apiAirport.getName(),
                apiAirport.getCountry(),
                apiAirport.getCity(),
                apiAirport.getTimezone()
        );
    }
}
