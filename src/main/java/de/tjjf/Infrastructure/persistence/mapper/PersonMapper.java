package de.tjjf.Infrastructure.persistence.mapper;

import de.tjjf.Domain.models.MAddress;
import de.tjjf.Domain.models.MEmployee;
import de.tjjf.Domain.models.MPerson;
import de.tjjf.Domain.models.MTicket;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Read.TicketReadImpl;
import de.tjjf.Infrastructure.persistence.entities.Client;
import de.tjjf.Infrastructure.persistence.entities.Employee;
import de.tjjf.Infrastructure.persistence.entities.Ticket;

import java.util.ArrayList;
import java.util.List;

public class PersonMapper {

    public MPerson toDomain(Employee employee){
        List<MTicket> tickets = new ArrayList<>();
        for(Ticket ticket : employee.getTickets()){
            tickets.add(new TicketMapper().toDomain(new TicketReadImpl(ticket.getTicketId()).execute().model));
        }
        return new MPerson(
                employee.getPersonId(),
                employee.getFirstName(),
                employee.getMiddleName(),
                employee.getLastName(),
                employee.getDateOfBirth(),
                employee.getPhonenumber(),
                new AddressMapper().toDomain(employee.getAddress()),
                employee.getEmail(),
                tickets
        );
    }

    public MPerson toDomain(Client client) {
        List<MTicket> tickets = new ArrayList<>();
        for(Ticket ticket : client.getTickets()){
            tickets.add(new TicketMapper().toDomain(new TicketReadImpl(ticket.getTicketId()).execute().model));
        }
        return new MPerson(
                client.getPersonId(),
                client.getFirstName(),
                client.getMiddleName(),
                client.getLastName(),
                client.getDateOfBirth(),
                client.getPhonenumber(),
                new AddressMapper().toDomain(client.getAddress()),
                client.getEmail(),
                tickets
        );
    }
}
