package de.tjjf.Domain.UseCases;

import de.tjjf.Domain.EmailSender;
import de.tjjf.Domain.models.MFlight;

public class CancelCompleteFlightUseCase extends AuthorizedUseCase {

    public CancelCompleteFlightUseCase() {
        super(AuthenticationUseCase.getInstance());
    }

    public static void cancelFlight(MFlight flight){
        //new CancelCompleteFlightUseCase().authorize();
        
        flight.setStatus(MFlight.FlightStatus.canceled);
        EmailSender.sendCancelationMail(flight);

    }
}
