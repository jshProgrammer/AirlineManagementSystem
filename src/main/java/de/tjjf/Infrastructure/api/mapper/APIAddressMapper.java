package de.tjjf.Infrastructure.api.mapper;

import de.tjjf.Domain.models.MAddress;
import de.tjjf.Infrastructure.api.models.APIAddress;

public class APIAddressMapper extends AbstractAPIMapper<APIAddress, MAddress> {
    @Override
    public APIAddress toAPIEntity(MAddress mAddress) {
        return new APIAddress(
                mAddress.getStreet(),
                mAddress.getNumber(),
                mAddress.getZipcode(),
                mAddress.getCity(),
                mAddress.getCountry()
        );
    }

    @Override
    public MAddress toDomainEntity(APIAddress apiAddress) {
        return new MAddress(
                apiAddress.getStreet(),
                apiAddress.getNumber(),
                apiAddress.getZipcode(),
                apiAddress.getCity(),
                apiAddress.getCountry()
        );
    }
}
