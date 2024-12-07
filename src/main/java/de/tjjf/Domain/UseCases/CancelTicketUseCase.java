package de.tjjf.Domain.UseCases;

import de.tjjf.Domain.EmailSender;
import de.tjjf.Domain.models.MFlight;
import de.tjjf.Domain.models.MPerson;
import de.tjjf.Domain.models.MTicket;

public class CancelTicketUseCase {
    public static void cancelTicket(MPerson person, int flightnum){
        for(MTicket ticket : person.getTickets()){
            if(flightnum  == (int) ticket.getFlight().getFlightNum()){
                MFlight mFlight = ticket.getFlight();
                EmailSender.sendCancelationMailCustomer(mFlight);
                mFlight.getTickets().remove(ticket);
                ticket.setTicketStatus(MTicket.TicketStatus.canceled);
            }
        }
    }
}
