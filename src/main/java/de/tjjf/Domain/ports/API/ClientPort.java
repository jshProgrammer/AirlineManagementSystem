package de.tjjf.Domain.ports.API;

import de.tjjf.Domain.models.MClient;

public interface ClientPort {
    void createClient(MClient client);
    // no verification of password due to design decision of implementing employee api and not client api
    MClient readClientById(long id);
    void updateClient(MClient client);
}
