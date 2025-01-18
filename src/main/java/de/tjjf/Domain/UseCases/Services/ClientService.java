package de.tjjf.Domain.UseCases.Services;

import de.tjjf.Domain.UseCases.AuthenticationUseCase;
import de.tjjf.Domain.UseCases.AuthorizedUseCase;
import de.tjjf.Domain.models.MClient;
import de.tjjf.Domain.ports.DB.DataAccess;

public class ClientService extends AuthorizedUseCase {
    DataAccess.MClientRepository port;

    public ClientService(DataAccess.MClientRepository port) {
        super(AuthenticationUseCase.getInstance());
        this.port = port;
    }

    public MClient createClient(MClient entity){
        //new CancelTicketUseCase().authorize();
        return port.create(entity);
    }

    public MClient readClientByID(Long id){
        //new CancelTicketUseCase().authorize();
        return port.readById(id);
    }

    public void updateClient(MClient entity){
        //new CancelTicketUseCase().authorize();
        port.update(entity);
    }
}
