package de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Create;

import de.tjjf.Infrastructure.persistence.DBOperations.AbstractOperations.AbstractCreateOperation;
import de.tjjf.Infrastructure.persistence.entities.Client;

public class ClientCreateImpl extends AbstractCreateOperation <Client>{
    public ClientCreateImpl(Client modelToPersist){
        super(modelToPersist);
    }
}
