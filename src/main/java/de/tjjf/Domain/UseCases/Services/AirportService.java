package de.tjjf.Domain.UseCases.Services;

import de.tjjf.Domain.UseCases.AuthenticationUseCase;
import de.tjjf.Domain.UseCases.AuthorizedUseCase;
import de.tjjf.Domain.models.DomainAirport;
import de.tjjf.Domain.ports.DB.DataAccess;

public class AirportService extends AuthorizedUseCase{
    DataAccess.MAirportRepository port;

    public AirportService(DataAccess.MAirportRepository port) {
        super(AuthenticationUseCase.getInstance());
        this.port = port;
    }

    public DomainAirport createAirport(DomainAirport airport){
        //new CancelTicketUseCase().authorize();
        return port.create(airport);
    }

    public DomainAirport readAirportByCode(String code) {
        //new CancelTicketUseCase().authorize();
        return port.readById(code);
    }
}
