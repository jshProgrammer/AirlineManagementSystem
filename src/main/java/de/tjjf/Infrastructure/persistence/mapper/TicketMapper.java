package de.tjjf.Infrastructure.persistence.mapper;


import de.tjjf.Domain.models.MClient;
import de.tjjf.Domain.models.MEmployee;
import de.tjjf.Domain.models.MPerson;
import de.tjjf.Domain.models.MTicket;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Read.ClientReadImpl;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Read.EmployeeReadImpl;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Read.FlightReadImpl;
import de.tjjf.Infrastructure.persistence.entities.Client;
import de.tjjf.Infrastructure.persistence.entities.Employee;
import de.tjjf.Infrastructure.persistence.entities.Flight;
import de.tjjf.Infrastructure.persistence.entities.Ticket;


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

    public MTicket toDomain(Ticket booking){
        MPerson mPerson;

        if (booking.getEmployee() != null) {
            mPerson = new PersonMapper().toDomain(new EmployeeReadImpl(booking.getClient().getPersonId()).execute().model);
        } else {
            mPerson = new PersonMapper().toDomain(new ClientReadImpl(booking.getClient().getPersonId()).execute().model);
        }
        System.out.println("Hallowerda");
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
