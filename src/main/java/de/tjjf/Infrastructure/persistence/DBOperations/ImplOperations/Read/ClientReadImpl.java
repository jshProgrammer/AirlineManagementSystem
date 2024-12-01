package de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Read;

import de.tjjf.Infrastructure.persistence.DBOperations.AbstractOperations.AbstractReadOperation;
import de.tjjf.Infrastructure.persistence.entities.Client;

public class ClientReadImpl extends AbstractReadOperation<Client, Long> {
    public ClientReadImpl(long identifier){
        super(Client.class, identifier);
    }
}
