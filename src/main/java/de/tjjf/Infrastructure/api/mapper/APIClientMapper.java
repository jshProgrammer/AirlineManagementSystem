package de.tjjf.Infrastructure.api.mapper;

import de.tjjf.Domain.models.DomainClient;
import de.tjjf.Domain.models.DomainPerson;
import de.tjjf.Infrastructure.api.DateParser;
import de.tjjf.Infrastructure.api.models.APIClient;

import java.util.Date;

public class APIClientMapper extends AbstractAPIMapper<APIClient, DomainClient>  {
    @Override
    public APIClient toAPIEntity(DomainClient mClient) {
        return new APIClient(
            mClient.getPersonId(),
                mClient.getFirstName(),
                mClient.getMiddleNames(),
                mClient.getLastName(),
                mClient.getDateOfBirth().toString(),
                mClient.getPhonenumber(),
                new APIAddressMapper().toAPIEntity(mClient.getAddress()),
                mClient.getEmail(),
                mClient.isBusinessClient()
        );
    }

    @Override
    public DomainClient toDomainEntity(APIClient apiClient) {
        Date date = DateParser.getDateFromRFC3339(apiClient.getDateOfBirth());

        DomainPerson person = new PersonMapper().toDomain(apiClient);
        return new DomainClient(
            person.getPersonId(),
            person.getFirstName(),
            person.getMiddleNames(),
                person.getLastName(),
                date,
                person.getPhonenumber(),
                new APIAddressMapper().toDomainEntity(apiClient.getAddress()), person.getEmail(),
    true
        );
    }
}
