package de.tjjf.Domain.UseCases.Services;

import de.tjjf.Domain.UseCases.AuthenticationUseCase;
import de.tjjf.Domain.UseCases.AuthorizedUseCase;
import de.tjjf.Domain.UseCases.CancelTicketUseCase;
import de.tjjf.Domain.models.MAirport;
import de.tjjf.Domain.ports.DB.DataAccess;

public class AirportService extends AuthorizedUseCase{
    DataAccess.MAirportRepository port;

    public AirportService(DataAccess.MAirportRepository port) {
        super(AuthenticationUseCase.getInstance());
        this.port = port;
    }

    public MAirport createAirport(MAirport airport){
        new CancelTicketUseCase().authorize();
        return port.create(airport);
    }

    public MAirport readAirportByCode(String code) {
        new CancelTicketUseCase().authorize();
        return port.readById(code);
    }
}
