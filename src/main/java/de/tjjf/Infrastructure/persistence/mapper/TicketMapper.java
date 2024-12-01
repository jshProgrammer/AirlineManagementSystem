package de.tjjf.Infrastructure.persistence.mapper;


import de.tjjf.Domain.models.MPerson;
import de.tjjf.Domain.models.MTicket;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Read.ClientReadImpl;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Read.FlightReadImpl;
import de.tjjf.Infrastructure.persistence.entities.Client;
import de.tjjf.Infrastructure.persistence.entities.Flight;
import de.tjjf.Infrastructure.persistence.entities.Ticket;


public class TicketMapper extends Mapper<MTicket, Ticket> {

    public Ticket toEntity(MTicket mTicket){
        return new Ticket(
                mTicket.getTicketId(),
                mTicket.getPerson().getPersonId(),
                new FlightMapper().toEntity(mTicket.getFlight()),
                mTicket.getDateTimeOfBooking(),
                mTicket.getTotalPrice(),
                mTicket.getSeatNum(),
                mTicket.getSeatingClass().name(),
                mTicket.getTicketStatus().name(),
                mTicket.getWeightOfLuggage()
        );
    }

    public MTicket toDomain(Ticket booking){
        Client person = new ClientReadImpl(booking.getPersonId()).run().model;
        MPerson mPerson = new PersonMapper().toDomain(person);

        Flight flight = new FlightReadImpl(booking.getFlight().getFlightNum()).run().model;

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
