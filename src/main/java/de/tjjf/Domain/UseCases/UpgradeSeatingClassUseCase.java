package de.tjjf.Domain.UseCases;

import de.tjjf.Domain.models.MTicket;

public class UpgradeSeatingClassUseCase {
    public static boolean isSeatingUpdateAvailable( MTicket ticket, MTicket.SeatingClass newDesiredSeatingClass ) {

        if (ticket.isSeatingUpdateAvailable(newDesiredSeatingClass)) {
            //TODO: database update
        }

        return true;


    }
}