package de.tjjf.Infrastructure.api.MapperInput;

import de.tjjf.Infrastructure.api.InputModels.APITicketInput;
import de.tjjf.Infrastructure.api.models.APITicket;

public class TicketMapperInput {

    public APITicketInput toClient(APITicket ticket) {
        APITicketInput.SeatingClass seatingClass = APITicketInput.SeatingClass.valueOf(ticket.getSeatingClass().name());
        APITicketInput.TicketStatus ticketStatus = APITicketInput.TicketStatus.valueOf(ticket.getTicketStatus().name());
        return new APITicketInput(
                ticket.getTicketId(),
                ticket.getPersonId(),
                ticket.isClient(),
                ticket.getFlightNum(),
                ticket.getDateTimeOfBooking(),
                ticket.getTotalPrice(),
                ticket.getSeatNum(),
                seatingClass,
                ticketStatus,
                ticket.getWeightOfLuggage()
        );
    }

    public APITicket toDomain(APITicketInput ticket) {
        APITicket.SeatingClass seatingClass = APITicket.SeatingClass.valueOf(ticket.getSeatingClass().name());
        APITicket.TicketStatus ticketStatus = APITicket.TicketStatus.valueOf(ticket.getTicketStatus().name());
        return new APITicket(
                ticket.getTicketId(),
                ticket.getPersonId(),
                ticket.isClient(),
                ticket.getFlightNum(),
                ticket.getDateTimeOfBooking(),
                ticket.getTotalPrice(),
                ticket.getSeatNum(),
                seatingClass,
                ticketStatus,
                ticket.getWeightOfLuggage()
        );
    }
}