package de.tjjf.Domain.UseCases;

import de.tjjf.Domain.EmailSender;
import de.tjjf.Domain.Exceptions.UnauthorizedException;
import de.tjjf.Domain.models.*;
import de.tjjf.Infrastructure.Client.ClientOperations.APIOperations.TicketAPIOperation;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Update.ClientUpdateImpl;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Update.EmployeeUpdateImpl;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Update.FlightUpdateImpl;
import de.tjjf.Infrastructure.persistence.entities.Employee;
import de.tjjf.Infrastructure.persistence.mapper.ClientMapper;
import de.tjjf.Infrastructure.persistence.mapper.EmployeeMapper;
import de.tjjf.Infrastructure.persistence.mapper.FlightMapper;

public class CancelTicketUseCase extends AuthorizedUseCase {
    public CancelTicketUseCase() {
        super(AuthenticationUseCase.getInstance());
    }

    public static void cancelTicket(MPerson person, int flightnum) throws UnauthorizedException {
        //10.01.2025: Gespräch mit Prof. Dr. Braun: Authorization nicht notwendig da Error Weitergabe von Resolver zu Client in GraphQL kaum umsetzbar
        //new CancelTicketUseCase().authorize();
        //Alternativ Variante falls getEmployeeId() keine Exception wirft
        for (MTicket ticket : person.getTickets()) {
            if (flightnum == (int) ticket.getFlight().getFlightNum()) {
                MFlight mFlight = ticket.getFlight();
                EmailSender.sendCancelationMailCustomer(mFlight);
                mFlight.getTickets().remove(ticket);
                ticket.setTicketStatus(MTicket.TicketStatus.canceled);
            }
        }

        if(person instanceof MClient){
            MClient client = (MClient) person;
            new ClientUpdateImpl(new ClientMapper().toEntity(client), person.getPersonId()).execute();
        }else{
            MEmployee employee = (MEmployee) person;
            new EmployeeUpdateImpl(new EmployeeMapper().toEntity(employee), person.getPersonId()).execute();
        }

    }
}
