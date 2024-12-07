package de.tjjf.Domain.UseCases;

import de.tjjf.Domain.models.MFlight;
import de.tjjf.Domain.models.MTicket;

import java.util.List;
/*
public class UpgradeSeatingClassUseCase {
    public static boolean isSeatingUpdateAvailable( MTicket ticket, MTicket.SeatingClass newDesiredSeatingClass ) {

        MFlight belongingFlight = ticket.getFlight();
        List<MTicket> bookingsOfThisFlight = belongingFlight.getTickets();

        int totalNumberOfSeats = switch(newDesiredSeatingClass) {
            case MTicket.SeatingClass .Economy -> belongingFlight.getAirplane().getAmountOfEconomySeats();
            case MTicket.SeatingClass .Business -> belongingFlight.getAirplane().getAmountOfBusinessSeats();
            case MTicket.SeatingClass .First -> belongingFlight.getAirplane().getAmountOfFirstClassSeats();
        };

        int reservedNumberOfSeats = 0;

        for(MTicket mTicketIter : bookingsOfThisFlight) {
            if(mTicketIter.getSeatingClass() == newDesiredSeatingClass) {
                reservedNumberOfSeats++;
            }
        }

        return reservedNumberOfSeats < totalNumberOfSeats;
    }
}*/
