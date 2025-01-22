package de.tjjf.Infrastructure.persistence.mapper;

import de.tjjf.Domain.models.DomainPerson;
import de.tjjf.Domain.models.DomainTicket;
import de.tjjf.Infrastructure.persistence.entities.Client;
import de.tjjf.Infrastructure.persistence.entities.Employee;
import de.tjjf.Infrastructure.persistence.entities.Ticket;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PersonMapper {
    public DomainPerson toDomain(Employee employee) {
        return this.toDomain(employee, new HashSet<>());
    }

    public DomainPerson toDomain(Employee employee, Set<Long> processedTickets) {
        List<DomainTicket> tickets = new ArrayList<>();
        for (Ticket ticket : employee.getTickets()) {
            if (!processedTickets.contains(ticket.getTicketId())) {
                processedTickets.add(ticket.getTicketId());
                tickets.add(new TicketMapper().toDomain(ticket, processedTickets));
            }
        }
        return new DomainPerson(
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

    public DomainPerson toDomain(Client client) {
        return this.toDomain(client, new HashSet<>());
    }

    public DomainPerson toDomain(Client client, Set<Long> processedTickets) {
        List<DomainTicket> tickets = new ArrayList<>();
        for (Ticket ticket : client.getTickets()) {
            if (!processedTickets.contains(ticket.getTicketId())) {
                processedTickets.add(ticket.getTicketId());
                tickets.add(new TicketMapper().toDomain(ticket, processedTickets));
            }
        }
        return new DomainPerson(
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
