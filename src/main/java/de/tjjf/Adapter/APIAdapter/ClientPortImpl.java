package de.tjjf.Adapter.APIAdapter;

import de.tjjf.Adapter.DatabaseAdapter.MClientRepositoryImpl;
import de.tjjf.Domain.UseCases.Services.ClientService;
import de.tjjf.Domain.models.DomainClient;
import de.tjjf.Domain.ports.API.ClientPort;

public class ClientPortImpl implements ClientPort {
    @Override
    public DomainClient createClient(DomainClient client) {
        return new ClientService(new MClientRepositoryImpl()).createClient(client);
    }

    @Override
    public DomainClient readClientById(long id) {
        return new ClientService(new MClientRepositoryImpl()).readClientByID(id);
    }

    @Override
    public void updateClient(DomainClient client) {
        new ClientService(new MClientRepositoryImpl()).updateClient(client);
    }
}
