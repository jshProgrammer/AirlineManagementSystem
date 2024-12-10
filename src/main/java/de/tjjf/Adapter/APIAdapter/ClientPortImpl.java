package de.tjjf.Adapter.APIAdapter;

import de.tjjf.Domain.models.MClient;
import de.tjjf.Domain.ports.API.ClientPort;

public class ClientPortImpl implements ClientPort {
    @Override
    public void createClient(MClient client) {}

    @Override
    public MClient readClientById(long id) {
        return null;
    }

    @Override
    public MClient updateClient(MClient client) {
        return null;
    }
}
