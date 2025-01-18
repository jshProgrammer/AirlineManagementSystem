package de.tjjf.Infrastructure.persistence.mapper;

import de.tjjf.Domain.models.MClient;
import de.tjjf.Domain.models.MEmployee;
import de.tjjf.Domain.models.MPerson;
import de.tjjf.Domain.models.MTicket;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Read.ClientReadImpl;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Read.EmployeeReadImpl;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Read.FlightReadImpl;
import de.tjjf.Infrastructure.persistence.entities.Flight;
import de.tjjf.Infrastructure.persistence.entities.Ticket;

import java.util.HashSet;
import java.util.Set;


public class TicketMapper extends Mapper<MTicket, Ticket> {

    public Ticket toEntity(MTicket mTicket){

        Ticket ticket = new Ticket(
                new FlightMapper().toEntityWithFlightNum(mTicket.getFlight()),
                mTicket.getDateTimeOfBooking(),
                mTicket.getTotalPrice(),
                mTicket.getSeatNum(),
                mTicket.getSeatingClass().name(),
                mTicket.getTicketStatus().name(),
                mTicket.getWeightOfLuggage()
        );


        if (mTicket.getPerson() instanceof MClient) {
            ticket.setClient(new ClientMapper().toEntityWithId((MClient) mTicket.getPerson(), false));
        } else if (mTicket.getPerson() instanceof MEmployee) {
            ticket.setEmployee(new EmployeeMapper().toEntityWithId((MEmployee) mTicket.getPerson(), false));
        }

        return ticket;
    }

    public MTicket toDomain(Ticket booking) {
        return this.toDomain(booking, new HashSet<>());
    }

    public MTicket toDomain(Ticket booking, Set<Long> processedTickets) {
        MPerson mPerson;

        if (booking.getEmployee() != null) {
            mPerson = new PersonMapper().toDomain(new EmployeeReadImpl(booking.getEmployee().getPersonId()).execute().model, processedTickets);
        } else {
            mPerson = new PersonMapper().toDomain(new ClientReadImpl(booking.getClient().getPersonId()).execute().model, processedTickets);
        }

        Flight flight = new FlightReadImpl(booking.getFlight().getFlightNum()).execute().model;

        return new MTicket(
                booking.getTicketId(),
                mPerson,
                new FlightMapper().toDomain(flight),
                booking.getDateTimeOfBooking(),
                booking.getTotalPrice(),
                booking.getSeatNum(),
                MTicket.SeatingClass.valueOf(booking.getSeatingClass()),
                MTicket.TicketStatus.valueOf(booking.getTicketStatus()),
                booking.getMaxWeightOfLuggage()
        );
    }
}
