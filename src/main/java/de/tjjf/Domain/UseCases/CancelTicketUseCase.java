package de.tjjf.Domain.UseCases;

import de.tjjf.Domain.EmailSender;
import de.tjjf.Domain.Exceptions.UnauthorizedException;
import de.tjjf.Domain.models.*;
import de.tjjf.Infrastructure.Client.ClientOperations.APIOperations.TicketAPIOperation;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Update.ClientUpdateImpl;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Update.EmployeeUpdateImpl;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Update.FlightUpdateImpl;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Update.TicketUpdateImpl;
import de.tjjf.Infrastructure.persistence.entities.Employee;
import de.tjjf.Infrastructure.persistence.mapper.ClientMapper;
import de.tjjf.Infrastructure.persistence.mapper.EmployeeMapper;
import de.tjjf.Infrastructure.persistence.mapper.FlightMapper;
import de.tjjf.Infrastructure.persistence.mapper.TicketMapper;

public class CancelTicketUseCase extends AuthorizedUseCase {
    public CancelTicketUseCase() {
        super(AuthenticationUseCase.getInstance());
    }

    public static void cancelTicket(MPerson person, int flightnum) {
        cancelTicket(person, flightnum, true);
    }

    public static void cancelTicket(MPerson person, int flightnum, boolean changeInDB) throws UnauthorizedException {
        //10.01.2025: Gespräch mit Prof. Dr. Braun: Authorization nicht notwendig da Error Weitergabe von Resolver zu Client in GraphQL kaum umsetzbar
        //new CancelTicketUseCase().authorize();

        for (MTicket ticket : person.getTickets()) {
            if (flightnum == (int) ticket.getFlight().getFlightNum()) {
                MFlight mFlight = ticket.getFlight();
                EmailSender.sendCancelationMailCustomer(mFlight);
                mFlight.getTickets().remove(ticket);
                ticket.setTicketStatus(MTicket.TicketStatus.canceled);
                if(changeInDB) new TicketUpdateImpl(new TicketMapper().toEntity(ticket), ticket.getTicketId()).execute();
            }
        }

        if(person instanceof MClient){
            MClient client = (MClient) person;
            if(changeInDB) new ClientUpdateImpl(new ClientMapper().toEntity(client), person.getPersonId()).execute();
        }else{
            MEmployee employee = (MEmployee) person;
            if(changeInDB) new EmployeeUpdateImpl(new EmployeeMapper().toEntity(employee), person.getPersonId()).execute();
        }


    }
}
