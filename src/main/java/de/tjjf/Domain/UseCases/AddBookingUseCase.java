package de.tjjf.Domain.UseCases;

import de.tjjf.Domain.EmailSender;
import de.tjjf.Domain.models.MTicket;

public class AddBookingUseCase {
    public static boolean addBooking(MTicket newBooking) {
        boolean bookable = false;
        if(newBooking.getFlight().getTickets().size() < newBooking.getFlight().getAirplane().getTotalNumberOfSeats()){
            bookable = true;
            newBooking.getFlight().getTickets().add(newBooking);
            EmailSender.sendInvoice(newBooking);
        }

        return bookable;
    }
}
