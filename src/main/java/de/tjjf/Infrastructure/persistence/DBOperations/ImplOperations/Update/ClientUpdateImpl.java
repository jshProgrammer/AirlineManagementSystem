package de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Update;

import de.tjjf.Infrastructure.persistence.DBOperations.AbstractOperations.AbstractUpdateOperation;
import de.tjjf.Infrastructure.persistence.entities.Client;

public class ClientUpdateImpl extends AbstractUpdateOperation<Client> {
    public ClientUpdateImpl(Client modelToPersist){
        super(modelToPersist);
    }
}
