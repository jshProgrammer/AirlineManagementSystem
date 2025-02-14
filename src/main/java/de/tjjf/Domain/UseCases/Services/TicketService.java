package de.tjjf.Domain.UseCases.Services;

import de.tjjf.Domain.Exceptions.NoSeatsAvailableException;
import de.tjjf.Domain.UseCases.*;
import de.tjjf.Domain.models.*;
import de.tjjf.Domain.ports.DB.DataAccess;

public class TicketService extends AuthorizedUseCase {
    DataAccess.MTicketRepository ticketPort;
    DataAccess.MClientRepository clientPort;
    DataAccess.MEmployeeRepository employeePort;

    public TicketService(DataAccess.MTicketRepository ticketPort) {
        super(AuthenticationUseCase.getInstance());
        this.ticketPort = ticketPort;
    }

    public TicketService(DataAccess.MTicketRepository ticketPort, DataAccess.MClientRepository clientPort, DataAccess.MEmployeeRepository employeePort) {
        super(AuthenticationUseCase.getInstance());
        this.ticketPort = ticketPort;
        this.clientPort = clientPort;
        this.employeePort = employeePort;
    }

    public DomainTicket addBooking(DomainTicket newBooking, DomainPayment mPayment) {
        //new CancelTicketUseCase().authorize();
        if(AddTicketUseCase.addTicket(newBooking, mPayment)){
            DomainTicket newTicket = ticketPort.create(newBooking);
            newBooking.getPerson().addTickets(newBooking);
            if ((newBooking.getPerson() instanceof DomainClient)) {
                clientPort.update((DomainClient) newBooking.getPerson());
            } else {
                employeePort.update((DomainEmployee) newBooking.getPerson());
            }
            return newTicket;
        }
        return null;
    }

    public DomainTicket readTicketById(long id) {
        //new CancelTicketUseCase().authorize();
        return ticketPort.readById(id);
    }

    public void upgradeSeatingClass(long ticketId, DomainTicket.SeatingClass newSeatingClass) throws NoSeatsAvailableException {
        //new CancelTicketUseCase().authorize();
        DomainTicket ticket = readTicketById(ticketId);
        new UpgradeSeatingClassUseCase(ticketPort).updateSeatingClassIfAvailable(ticket, newSeatingClass);
    }

    public void upgradeLuggageWeight(long ticketId, int newWeight) throws IllegalArgumentException {
        //new CancelTicketUseCase().authorize();
        DomainTicket ticket = ticketPort.readById(ticketId);
        new UpgradeLuggageWeightUseCase(ticketPort).upgradeLuggageWeight(ticket, newWeight);
    }

    public void cancelTicket(DomainPerson person, long flightnum){
        //new CancelTicketUseCase().authorize();
        new CancelTicketUseCase(ticketPort, clientPort, employeePort).cancelTicket(person, flightnum);
    }
}
