package de.tjjf.Domain.UseCases.Services;

import de.tjjf.Domain.UseCases.CancelCompleteFlightUseCase;
import de.tjjf.Domain.UseCases.CancelTicketUseCase;
import de.tjjf.Domain.models.MFlight;
import de.tjjf.Domain.ports.DB.DataAccess;

public class FlightService {
    DataAccess.MFlightRepository port;
    public FlightService(DataAccess.MFlightRepository port) {this.port = port;}

    public void createFlight(MFlight toEntity){
        port.create(toEntity);
    }

    public MFlight readFlightByNum(long num){
        return port.readById(num);
    }

    public void updateFlight(MFlight toEntity){
        port.update(toEntity);
    }

    public void cancelFlight(MFlight toEntity){
        toEntity.setStatus(MFlight.FlightStatus.canceled);
        CancelCompleteFlightUseCase.cancelFlight(toEntity);
        port.update(toEntity);
    }
}
