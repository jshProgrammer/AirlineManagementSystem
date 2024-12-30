package de.tjjf.Infrastructure.api.mapper;

import de.tjjf.Domain.models.MClient;
import de.tjjf.Domain.models.MPerson;
import de.tjjf.Infrastructure.api.models.APIClient;
import de.tjjf.Infrastructure.persistence.mapper.AddressMapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class APIClientMapper extends AbstractAPIMapper<APIClient, MClient>  {
    @Override
    public APIClient toAPIEntity(MClient mClient) {
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
    public MClient toDomainEntity(APIClient apiClient) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        Date date;
        try {
            date = formatter.parse(apiClient.getDateOfBirth());
            System.out.println("Parsed date: " + date);
        } catch (ParseException e) {
            throw new RuntimeException("Error parsing date: " + e.getMessage());
        }
        MPerson person = new PersonMapper().toDomain(apiClient);
        return new MClient(
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
