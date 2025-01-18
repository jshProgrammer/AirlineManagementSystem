package de.tjjf.Domain.UseCases;

import de.tjjf.Domain.EmailSender;
import de.tjjf.Domain.models.MFlight;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Update.FlightUpdateImpl;
import de.tjjf.Infrastructure.persistence.mapper.FlightMapper;

public class CancelCompleteFlightUseCase extends AuthorizedUseCase {

    public CancelCompleteFlightUseCase() {
        super(AuthenticationUseCase.getInstance());
    }

    public static void cancelFlight(MFlight flight){
        //new CancelCompleteFlightUseCase().authorize();
        
        flight.setStatus(MFlight.FlightStatus.canceled);
        EmailSender.sendCancelationMail(flight);
        new FlightUpdateImpl(new FlightMapper().toEntity(flight), flight.getFlightNum()).execute();

    }
}
