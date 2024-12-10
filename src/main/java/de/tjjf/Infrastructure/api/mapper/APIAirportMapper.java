package de.tjjf.Infrastructure.api.mapper;

import de.tjjf.Domain.models.MAirport;
import de.tjjf.Infrastructure.api.models.APIAirport;

public class APIAirportMapper extends AbstractAPIMapper<APIAirport, MAirport>{
    @Override
    public APIAirport toAPIEntity(MAirport mAirport) {
        return new APIAirport(
                mAirport.getCode(),
                mAirport.getName(),
                mAirport.getCountry(),
                mAirport.getCity(),
                mAirport.getTimezone()
        );
    }

    @Override
    public MAirport toDomainEntity(APIAirport apiAirport) {
        return new MAirport(
                apiAirport.getCode(),
                apiAirport.getName(),
                apiAirport.getCountry(),
                apiAirport.getCity(),
                apiAirport.getTimezone()
        );
    }
}
