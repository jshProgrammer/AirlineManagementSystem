package de.tjjf.Adapter.APIAdapter;

import de.tjjf.Adapter.DatabaseAdapter.MClientRepositoryImpl;
import de.tjjf.Domain.UseCases.Services.ClientService;
import de.tjjf.Domain.models.MClient;
import de.tjjf.Domain.ports.API.ClientPort;

public class ClientPortImpl implements ClientPort {
    @Override
    public MClient createClient(MClient client) {
        return new ClientService(new MClientRepositoryImpl()).createClient(client);
    }

    @Override
    public MClient readClientById(long id) {
        return new ClientService(new MClientRepositoryImpl()).readClientByID(id);
    }

    @Override
    public void updateClient(MClient client) {
        new ClientService(new MClientRepositoryImpl()).updateClient(client);
    }
}
