package de.tjjf.Domain.UseCases;

import de.tjjf.Domain.EmailSender;
import de.tjjf.Domain.models.DomainPayment;
import de.tjjf.Domain.models.DomainTicket;

public class AddBookingUseCase extends AuthorizedUseCase {

    public AddBookingUseCase() {
        super(AuthenticationUseCase.getInstance());
    }

    //4242424242424242 erfolgreiche Zahlung
    //4000000000000069 abgelaufene Karte/erfloglose Zahlung
    public static boolean addBooking(DomainTicket newBooking, DomainPayment mPayment) {
        //new CancelTicketUseCase().authorize();
        boolean bookable = false;
        boolean paid = PaymentUseCase.paymentCall(newBooking.getTotalPrice(), mPayment);
        if (paid) {
            if (newBooking.getFlight().getTickets().size() < newBooking.getFlight().getAirplane().getTotalNumberOfSeats()) {
                bookable = true;
                newBooking.getFlight().getTickets().add(newBooking);
                EmailSender.sendInvoice(newBooking);
            }
        }
        return bookable;
    }
}
