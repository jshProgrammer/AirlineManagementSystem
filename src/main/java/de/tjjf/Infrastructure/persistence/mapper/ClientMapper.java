package de.tjjf.Infrastructure.persistence.mapper;


import de.tjjf.Domain.models.MClient;
import de.tjjf.Infrastructure.persistence.entities.Client;
/*
public class ClientMapper extends Mapper<MClient, Client>{
    public Client toEntity(MClient mClient){
        return new Client(
                mClient.getPersonId(),
                mClient.isBusinessClient()
        );
    }

    public MClient toDomain(Client client){
        return new MClient(
                client.getPersonID(),
                client.isBusinessClient()
        );
    }
}
*/