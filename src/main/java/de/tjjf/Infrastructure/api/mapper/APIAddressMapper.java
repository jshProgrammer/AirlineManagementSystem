package de.tjjf.Infrastructure.api.mapper;

import de.tjjf.Domain.models.MAddress;
import de.tjjf.Infrastructure.api.models.APIAddress;

public class APIAddressMapper extends AbstractAPIMapper<APIAddress, MAddress> {
    @Override
    public APIAddress toAPIEntity(MAddress mModel) {
        return null;
    }

    @Override
    public MAddress toDomainEntity(APIAddress model) {
        return null;
    }
}
