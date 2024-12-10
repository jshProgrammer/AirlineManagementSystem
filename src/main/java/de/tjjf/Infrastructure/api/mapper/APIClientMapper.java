package de.tjjf.Infrastructure.api.mapper;

import de.tjjf.Domain.models.MClient;
import de.tjjf.Domain.models.MPerson;
import de.tjjf.Infrastructure.api.models.APIClient;
import de.tjjf.Infrastructure.persistence.mapper.AddressMapper;

public class APIClientMapper extends AbstractAPIMapper<APIClient, MClient>  {
    @Override
    public APIClient toAPIEntity(MClient mClient) {
        return new APIClient(
            mClient.getPersonId(),
                mClient.getFirstName(),
                mClient.getMiddleNames(),
                mClient.getLastName(),
                mClient.getDateOfBirth(),
                mClient.getPhonenumber(),
                new APIAddressMapper().toAPIEntity(mClient.getAddress()),
                mClient.getEmail(),
                mClient.isBusinessClient()
        );
    }

    @Override
    public MClient toDomainEntity(APIClient apiClient) {
        MPerson person = new PersonMapper().toDomain(apiClient);
        return new MClient(
            person.getPersonId(),
            person.getFirstName(),
            person.getMiddleNames(),
                person.getLastName(),
                person.getDateOfBirth(),
                person.getPhonenumber(),
                new APIAddressMapper().toDomainEntity(apiClient.getAddress()), person.getEmail(),
    null,
    true
        );
    }
}
