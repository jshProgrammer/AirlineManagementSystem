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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PersonMapper {
    public MPerson toDomain(Employee employee) {
        return this.toDomain(employee, new HashSet<>());
    }

    public MPerson toDomain(Employee employee, Set<Long> processedTickets) {
        List<MTicket> tickets = new ArrayList<>();
        for (Ticket ticket : employee.getTickets()) {
            if (!processedTickets.contains(ticket.getTicketId())) {
                processedTickets.add(ticket.getTicketId());
                tickets.add(new TicketMapper().toDomain(ticket, processedTickets));
            }
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
        return this.toDomain(client, new HashSet<>());
    }

    public MPerson toDomain(Client client, Set<Long> processedTickets) {
        List<MTicket> tickets = new ArrayList<>();
        for (Ticket ticket : client.getTickets()) {
            if (!processedTickets.contains(ticket.getTicketId())) {
                processedTickets.add(ticket.getTicketId());
                tickets.add(new TicketMapper().toDomain(ticket, processedTickets));
            }
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
