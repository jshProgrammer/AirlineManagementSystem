package de.tjjf.Domain.UseCases;

import de.tjjf.Domain.EmailSender;
import de.tjjf.Domain.models.MFlight;

public class CancelCompleteFlightUseCase {
    public static void cancelFlight(MFlight flight){
        flight.setStatus(MFlight.FlightStatus.canceled);
        EmailSender.sendCancelationMail(flight);
    }
}
