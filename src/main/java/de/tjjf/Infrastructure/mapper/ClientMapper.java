package de.tjjf.Infrastructure.mapper;

import de.tjjf.Domain.models.MClient;
import de.tjjf.Infrastructure.models.Client;

public class ClientMapper {
    public static Client toEntity(MClient mClient){
        return new Client(
                mClient.getPersonID(),
                mClient.isBusinessClient()
        );
    }

    public static MClient toDomain(Client client){
        return new MClient(
                client.getPersonID(),
                client.isBusinessClient()
        );
    }
}
