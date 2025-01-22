package de.tjjf.Infrastructure.persistence.mapper;

import de.tjjf.Domain.models.DomainClient;
import de.tjjf.Domain.models.DomainEmployee;
import de.tjjf.Domain.models.DomainPerson;
import de.tjjf.Domain.models.DomainTicket;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Read.ClientReadImpl;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Read.EmployeeReadImpl;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Read.FlightReadImpl;
import de.tjjf.Infrastructure.persistence.entities.Flight;
import de.tjjf.Infrastructure.persistence.entities.Ticket;

import java.util.HashSet;
import java.util.Set;


public class TicketMapper extends Mapper<DomainTicket, Ticket> {

    public Ticket toEntity(DomainTicket mTicket){

        Ticket ticket = new Ticket(
                new FlightMapper().toEntityWithFlightNum(mTicket.getFlight()),
                mTicket.getDateTimeOfBooking(),
                mTicket.getTotalPrice(),
                mTicket.getSeatNum(),
                mTicket.getSeatingClass().name(),
                mTicket.getTicketStatus().name(),
                mTicket.getWeightOfLuggage()
        );


        if (mTicket.getPerson() instanceof DomainClient) {
            ticket.setClient(new ClientMapper().toEntityWithId((DomainClient) mTicket.getPerson(), false));
        } else if (mTicket.getPerson() instanceof DomainEmployee) {
            ticket.setEmployee(new EmployeeMapper().toEntityWithId((DomainEmployee) mTicket.getPerson(), false));
        }

        return ticket;
    }

    public DomainTicket toDomain(Ticket booking) {
        return this.toDomain(booking, new HashSet<>());
    }

    public DomainTicket toDomain(Ticket booking, Set<Long> processedTickets) {
        DomainPerson mPerson;

        if (booking.getEmployee() != null) {
            mPerson = new PersonMapper().toDomain(new EmployeeReadImpl(booking.getEmployee().getPersonId()).execute().model, processedTickets);
        } else {
            mPerson = new PersonMapper().toDomain(new ClientReadImpl(booking.getClient().getPersonId()).execute().model, processedTickets);
        }

        Flight flight = new FlightReadImpl(booking.getFlight().getFlightNum()).execute().model;

        return new DomainTicket(
                booking.getTicketId(),
                mPerson,
                new FlightMapper().toDomain(flight),
                booking.getDateTimeOfBooking(),
                booking.getTotalPrice(),
                booking.getSeatNum(),
                DomainTicket.SeatingClass.valueOf(booking.getSeatingClass()),
                DomainTicket.TicketStatus.valueOf(booking.getTicketStatus()),
                booking.getMaxWeightOfLuggage()
        );
    }
}
