package de.tjjf.Infrastructure.api.mapper;

import de.tjjf.Domain.models.MTicket;
import de.tjjf.Infrastructure.api.DateParser;
import de.tjjf.Infrastructure.api.models.APITicket;
import de.tjjf.Adapter.APIAdapter.ClientPortImpl;
import de.tjjf.Adapter.APIAdapter.EmployeePortImpl;
import de.tjjf.Adapter.APIAdapter.FlightPortImpl;
import de.tjjf.Infrastructure.persistence.entities.Client;

public class APITicketMapper extends AbstractAPIMapper<APITicket, MTicket>{

    @Override
    public APITicket toAPIEntity(MTicket mTicket){
        return new APITicket(
                mTicket.getTicketId(),
                mTicket.getPerson().getPersonId(),
                //TODO: test if this transformation/comparison works:
                mTicket.getPerson().getClass().equals(Client.class),
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
        //TODO: macht hier vlt. das auslesen vom Client wieder Probleme => nein, system out danach funktioniert
        Long test = apiTicket.getIsClient() ? new ClientPortImpl().readClientById(apiTicket.getPersonId()).getPersonId() : new EmployeePortImpl().readEmployeeById(apiTicket.getPersonId()).getEmployeeId();
        System.out.println("TESTZZZ reading client/employee funktioniert");
        //TODO: ja auch die id funktioniert korrekt
        System.out.println("funktioniert die id: " + test);
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
