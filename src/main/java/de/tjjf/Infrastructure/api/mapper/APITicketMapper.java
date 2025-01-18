package de.tjjf.Infrastructure.api.mapper;

import de.tjjf.Domain.models.MClient;
import de.tjjf.Domain.models.MTicket;
import de.tjjf.Infrastructure.api.DateParser;
import de.tjjf.Infrastructure.api.models.APITicket;
import de.tjjf.Adapter.APIAdapter.ClientPortImpl;
import de.tjjf.Adapter.APIAdapter.EmployeePortImpl;
import de.tjjf.Adapter.APIAdapter.FlightPortImpl;

public class APITicketMapper extends AbstractAPIMapper<APITicket, MTicket>{

    @Override
    public APITicket toAPIEntity(MTicket mTicket){
        return new APITicket(
                mTicket.getTicketId(),
                mTicket.getPerson().getPersonId(),
                mTicket.getPerson().getClass().equals(MClient.class),
                mTicket.getFlight().getFlightNum(),
                mTicket.getDateTimeOfBooking().toString(),
                mTicket.getTotalPrice(),
                mTicket.getSeatNum(),
                APITicket.SeatingClass.valueOf(mTicket.getSeatingClass().name()),
                APITicket.TicketStatus.valueOf(mTicket.getTicketStatus().name()),
                mTicket.getWeightOfLuggage()
        );
    }

    @Override
    public MTicket toDomainEntity(APITicket apiTicket){
         return new MTicket(
                apiTicket.getTicketId(),
                apiTicket.getIsClient() ? new ClientPortImpl().readClientById(apiTicket.getPersonId()) : new EmployeePortImpl().readEmployeeById(apiTicket.getPersonId()),
                new FlightPortImpl().readFlightByNum(apiTicket.getFlightNum()),
                DateParser.getDateTimeFromRFC3339(apiTicket.getDateTimeOfBooking()),
                apiTicket.getTotalPrice(),
                apiTicket.getSeatNum(),
                MTicket.SeatingClass.valueOf(apiTicket.getSeatingClass().name()),
                MTicket.TicketStatus.valueOf(apiTicket.getTicketStatus().name()),
                apiTicket.getWeightOfLuggage()
        );
    }
}
