package de.tjjf.Domain.UseCases.Services;

import de.tjjf.Domain.UseCases.AuthenticationUseCase;
import de.tjjf.Domain.UseCases.AuthorizedUseCase;
import de.tjjf.Domain.models.DomainAirline;
import de.tjjf.Domain.ports.DB.DataAccess;


public class AirlineService extends AuthorizedUseCase {
    DataAccess.MAirlineRepository port;

    public AirlineService(DataAccess.MAirlineRepository port) {
        super(AuthenticationUseCase.getInstance());
        this.port = port;
    }

    public DomainAirline create(DomainAirline entity) {
        //new CancelTicketUseCase().authorize();
        return port.create(entity);
    }

    public DomainAirline readById(String s) {
        //new CancelTicketUseCase().authorize();
        return port.readById(s);
    }

    public void update(DomainAirline entity) {
        //new CancelTicketUseCase().authorize();
        port.update(entity);
    }

    public void delete(String s) {
        //new CancelTicketUseCase().authorize();
        port.delete(s);
    }
}
