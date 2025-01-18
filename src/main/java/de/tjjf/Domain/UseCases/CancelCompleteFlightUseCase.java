package de.tjjf.Domain.UseCases;

import de.tjjf.Domain.EmailSender;
import de.tjjf.Domain.models.MFlight;
import de.tjjf.Domain.ports.DB.DataAccess;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Update.FlightUpdateImpl;
import de.tjjf.Infrastructure.persistence.mapper.FlightMapper;

public class CancelCompleteFlightUseCase extends AuthorizedUseCase {
    DataAccess.MFlightRepository port;

    public CancelCompleteFlightUseCase(DataAccess.MFlightRepository port) {
        super(AuthenticationUseCase.getInstance());
        this.port = port;
    }


    public void cancelFlight(MFlight flight){
        //new CancelCompleteFlightUseCase().authorize();
        
        flight.setStatus(MFlight.FlightStatus.canceled);
        EmailSender.sendCancelationMail(flight);
        port.update(flight);

    }
}
