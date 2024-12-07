package de.tjjf.Infrastructure.api.mapper;

import de.tjjf.Domain.models.MAirline;
import de.tjjf.Infrastructure.api.models.APIAirline;
import de.tjjf.Infrastructure.persistence.entities.Airline;
import de.tjjf.Infrastructure.persistence.mapper.AddressMapper;

public class APIAirlineMapper extends AbstractAPIMapper<APIAirline, MAirline> {

    @Override
    public APIAirline toAPIEntity(MAirline mAirline) {
        return new APIAirline(
                mAirline.getName(),
                mAirline.getFoundationYear(),
                new APIAddressMapper().toAPIEntity(mAirline.getAddress()),
                mAirline.getPhoneNumber(),
                mAirline.getEmail()
        );
    }

    @Override
    public MAirline toDomainEntity(APIAirline model) {
        //TODO: wenn headquarters entfernt
        return null;
    }
}
