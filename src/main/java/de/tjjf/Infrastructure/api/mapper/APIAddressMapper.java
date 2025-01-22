package de.tjjf.Infrastructure.api.mapper;

import de.tjjf.Domain.models.DomainAddress;
import de.tjjf.Infrastructure.api.models.APIAddress;

public class APIAddressMapper extends AbstractAPIMapper<APIAddress, DomainAddress> {
    @Override
    public APIAddress toAPIEntity(DomainAddress mAddress) {
        return new APIAddress(
                mAddress.getStreet(),
                mAddress.getNumber(),
                mAddress.getZipcode(),
                mAddress.getCity(),
                mAddress.getCountry()
        );
    }

    @Override
    public DomainAddress toDomainEntity(APIAddress apiAddress) {
        return new DomainAddress(
                apiAddress.getStreet(),
                apiAddress.getNumber(),
                apiAddress.getZipCode(),
                apiAddress.getCity(),
                apiAddress.getCountry()
        );
    }
}
