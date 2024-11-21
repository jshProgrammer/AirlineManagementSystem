package de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Delete;

import de.tjjf.Infrastructure.persistence.DBOperations.AbstractOperations.AbstractDeleteOperation;
import de.tjjf.Infrastructure.persistence.entities.Client;

public class ClientDeleteImpl extends AbstractDeleteOperation<Client, Integer> {
    public ClientDeleteImpl(int identifier){
        super(Client.class, identifier);
    }
}
