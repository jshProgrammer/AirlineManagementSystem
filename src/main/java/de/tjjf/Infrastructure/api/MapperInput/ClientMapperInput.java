package de.tjjf.Infrastructure.api.MapperInput;

import de.tjjf.Infrastructure.api.InputModels.APIAddressInput;
import de.tjjf.Infrastructure.api.InputModels.APIClientInput;
import de.tjjf.Infrastructure.api.models.APIAddress;
import de.tjjf.Infrastructure.api.models.APIClient;

public class ClientMapperInput {

    public APIClientInput toClient(APIClient client) {
        APIAddressInput apiAddress = new AddressMapperInput().toClient(client.getAddress());
        return new APIClientInput(
                client.getFirstName(),
                client.getMiddleNames(),
                client.getLastName(),
                client.getDateOfBirth(),
                client.getPhoneNumber(),
                apiAddress,
                client.getEmail(),
                client.getIsBusinessClient()
        );
    }
    public APIClient toDomain(Long clientId, APIClientInput client) {
        APIAddress apiAddress = new AddressMapperInput().toDomain(client.getAddress());
        return new APIClient(
                clientId,
                client.getFirstName(),
                client.getMiddleNames(),
                client.getLastName(),
                client.getDateOfBirth(),
                client.getPhoneNumber(),
                apiAddress,
                client.getEmail(),
                client.isBusinessClient()
        );
    }
}
