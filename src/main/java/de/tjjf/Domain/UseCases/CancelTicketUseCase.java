package de.tjjf.Domain.UseCases;

import de.tjjf.Domain.EmailSender;
import de.tjjf.Domain.Exceptions.UnauthorizedException;
import de.tjjf.Domain.models.*;
import de.tjjf.Domain.ports.DB.DataAccess;

public class CancelTicketUseCase extends AuthorizedUseCase {
    DataAccess.MTicketRepository ticketPort;
    DataAccess.MClientRepository clientPort;
    DataAccess.MEmployeeRepository employeePort;

    public CancelTicketUseCase(DataAccess.MTicketRepository ticketPort, DataAccess.MClientRepository clientPort, DataAccess.MEmployeeRepository employeePort) {
        super(AuthenticationUseCase.getInstance());
        this.ticketPort = ticketPort;
        this.clientPort = clientPort;
        this.employeePort = employeePort;
    }

    public void cancelTicket(DomainPerson person, long flightnum) {
        cancelTicket(person, flightnum, true);
    }

    public void cancelTicket(DomainPerson person, long flightnum, boolean changeInDB) throws UnauthorizedException {
        //10.01.2025: Gespräch mit Prof. Dr. Braun: Authorization nicht notwendig da Error Weitergabe von Resolver zu Client in GraphQL kaum umsetzbar
        //new CancelTicketUseCase().authorize();

        for (DomainTicket ticket : person.getTickets()) {
            if (flightnum == (int) ticket.getFlight().getFlightNum()) {
                DomainFlight mFlight = ticket.getFlight();
                EmailSender.sendCancelationMailCustomer(mFlight);
                mFlight.getTickets().remove(ticket);
                ticket.setTicketStatus(DomainTicket.TicketStatus.canceled);
                if(changeInDB) {
                    ticketPort.update(ticket);
                }
            }
        }

        if(person instanceof DomainClient){
            DomainClient client = (DomainClient) person;
            if(changeInDB) clientPort.update(client);
        }else{
            DomainEmployee employee = (DomainEmployee) person;
            if(changeInDB) employeePort.update(employee);
        }

    }
}
