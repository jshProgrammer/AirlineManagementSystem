package de.tjjf.Infrastructure.api.mapper;

import de.tjjf.Domain.models.MPerson;
import de.tjjf.Domain.models.MTicket;
import de.tjjf.Infrastructure.api.models.APIClient;
import de.tjjf.Infrastructure.api.models.APIEmployee;
import de.tjjf.Infrastructure.api.models.APITicket;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PersonMapper {

    public MPerson toDomain(APIEmployee apiEmployee){
        /*List<MTicket> tickets = new ArrayList<>();
        for(APITicket ticket : apiEmployee.getT()){
            tickets.add(new TicketMapper().toDomain(new TicketReadImpl(ticket.getTicketId()).run().model));
        }*/

        //TODO: darf ich das wirklich auf null setzen?!
        return new MPerson(
                apiEmployee.getEmployeeId(),
                apiEmployee.getFirstName(),
                apiEmployee.getMiddleNames(),
                apiEmployee.getLastName(),
                parseDate(apiEmployee.getDateOfBirth()),
                apiEmployee.getPhoneNumber(),
                new APIAddressMapper().toDomainEntity(apiEmployee.getAddress()),
                apiEmployee.getEmail(),
                null
        );
    }

    private Date parseDate(String date){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        Date parsedDate;
        try {
            parsedDate = formatter.parse(date);
            System.out.println("Parsed date: " + date);
        } catch (ParseException e) {
            throw new RuntimeException("Error parsing date: " + e.getMessage());
        }
        return parsedDate;
    }

    public MPerson toDomain(APIClient apiClient){
        /*List<MTicket> tickets = new ArrayList<>();
        for(APITicket ticket : apiEmployee.getT()){
            tickets.add(new TicketMapper().toDomain(new TicketReadImpl(ticket.getTicketId()).run().model));
        }*/

        //TODO: darf ich das wirklich auf null setzen?!
        return new MPerson(
                apiClient.getClientId(),
                apiClient.getFirstName(),
                apiClient.getMiddleNames(),
                apiClient.getLastName(),
                parseDate(apiClient.getDateOfBirth()),
                apiClient.getPhoneNumber(),
                new APIAddressMapper().toDomainEntity(apiClient.getAddress()),
                apiClient.getEmail(),
                null
        );
    }


}
