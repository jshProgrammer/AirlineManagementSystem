package de.tjjf.Domain.UseCases.Services;

import de.tjjf.Domain.UseCases.AuthenticationUseCase;
import de.tjjf.Domain.UseCases.AuthorizedUseCase;
import de.tjjf.Domain.UseCases.CancelCompleteFlightUseCase;
import de.tjjf.Domain.UseCases.CancelTicketUseCase;
import de.tjjf.Domain.models.MFlight;
import de.tjjf.Domain.ports.DB.DataAccess;

import java.util.List;

public class FlightService extends AuthorizedUseCase {
    DataAccess.MFlightRepository port;

    public FlightService(DataAccess.MFlightRepository port) {
        super(AuthenticationUseCase.getInstance());
        this.port = port;
    }

    public MFlight createFlight(MFlight toEntity){
        //new CancelTicketUseCase().authorize();
        return port.create(toEntity);
    }

    public MFlight readFlightByNum(long num){
        //new CancelTicketUseCase().authorize();
        return port.readById(num);
    }

    public void updateFlight(MFlight toEntity){
        //new CancelTicketUseCase().authorize();
        port.update(toEntity);
    }

    public void cancelFlight(MFlight toEntity){
        //new CancelTicketUseCase().authorize();
        new CancelCompleteFlightUseCase(port).cancelFlight(toEntity);
    }

    public List<MFlight> getAllFlights(int pageNumber, int pageSize) {
        return port.getAllFlights(pageNumber, pageSize);
    }
}
