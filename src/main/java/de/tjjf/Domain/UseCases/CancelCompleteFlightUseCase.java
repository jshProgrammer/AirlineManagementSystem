package de.tjjf.Domain.UseCases;

import de.tjjf.Domain.EmailSender;
import de.tjjf.Domain.models.DomainFlight;
import de.tjjf.Domain.ports.DB.DataAccess;

public class CancelCompleteFlightUseCase extends AuthorizedUseCase {
    DataAccess.MFlightRepository port;

    public CancelCompleteFlightUseCase(DataAccess.MFlightRepository port) {
        super(AuthenticationUseCase.getInstance());
        this.port = port;
    }


    public void cancelFlight(DomainFlight flight){
        //new CancelCompleteFlightUseCase().authorize();
        
        flight.setStatus(DomainFlight.FlightStatus.canceled);
        EmailSender.sendCancelationMail(flight);
        port.update(flight);

    }
}
