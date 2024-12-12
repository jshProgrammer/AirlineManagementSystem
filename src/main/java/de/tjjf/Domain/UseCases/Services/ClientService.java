package de.tjjf.Domain.UseCases.Services;

import de.tjjf.Domain.models.MClient;
import de.tjjf.Domain.ports.DB.DataAccess;

public class ClientService {
    DataAccess.MClientRepository port;
    public ClientService(DataAccess.MClientRepository port) {this.port = port;}

    public void createClient(MClient entity){
        port.create(entity);
    }

    public MClient readClientByID(Long id){
        return port.readById(id);
    }

    public void updateClient(MClient entity){
        port.update(entity);
    }
}
