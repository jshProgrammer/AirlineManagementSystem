package de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Delete;

import de.tjjf.Infrastructure.persistence.DBOperations.AbstractOperations.AbstractDeleteOperation;
import de.tjjf.Infrastructure.persistence.entities.Client;

public class ClientDeleteImpl extends AbstractDeleteOperation<Client, Long> {
    public ClientDeleteImpl(long identifier){
        super(Client.class, identifier);
    }
}
