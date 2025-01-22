package de.tjjf.Domain.ports.API;

import de.tjjf.Domain.models.DomainClient;

public interface ClientPort {
    DomainClient createClient(DomainClient client);
    // no verification of password due to design decision of implementing employee api and not client api
    DomainClient readClientById(long id);
    void updateClient(DomainClient client);
}
