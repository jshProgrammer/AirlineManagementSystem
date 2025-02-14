package de.tjjf.Infrastructure.persistence.mapper;

import de.tjjf.Domain.models.DomainClient;
import de.tjjf.Domain.models.DomainPerson;
import de.tjjf.Domain.models.DomainTicket;
import de.tjjf.Infrastructure.persistence.entities.Client;
import de.tjjf.Infrastructure.persistence.entities.Ticket;

import java.util.ArrayList;
import java.util.List;

public class ClientMapper extends Mapper<DomainClient, Client>{
    public Client toEntity(DomainClient mClient) {
        return toEntity(mClient, true);
    }

    public Client toEntity(DomainClient mClient, boolean mapTickets){
        Client client = new Client(
                mClient.getFirstName(),
                mClient.getMiddleNames(),
                mClient.getLastName(),
                mClient.getDateOfBirth(),
                mClient.getPhonenumber(),
                AddressMapper.toEntity(mClient.getAddress()),
                mClient.getEmail(),
                null,
                mClient.isBusinessClient()
        );

        if (mapTickets) {
            List<Ticket> tickets = new ArrayList<>();
            for (DomainTicket mTicket : mClient.getTickets()) {
                Ticket ticket = new TicketMapper().toEntity(mTicket);
                ticket.setClient(client);
                tickets.add(ticket);
            }
            client.setTickets(tickets);
        }

        return client;
    }

    public Client toEntityWithId(DomainClient mClient) {
        return toEntityWithId(mClient, true);
    }

    public Client toEntityWithId(DomainClient mClient, boolean mapTickets) {
        Client client = new Client(
                mClient.getPersonId(),
                mClient.getFirstName(),
                mClient.getMiddleNames(),
                mClient.getLastName(),
                mClient.getDateOfBirth(),
                mClient.getPhonenumber(),
                AddressMapper.toEntity(mClient.getAddress()),
                mClient.getEmail(),
                null,
                mClient.isBusinessClient()
        );

        if (mapTickets) {
            List<Ticket> tickets = new ArrayList<>();
            for (DomainTicket mTicket : mClient.getTickets()) {
                Ticket ticket = new TicketMapper().toEntity(mTicket);
                ticket.setClient(client);
                tickets.add(ticket);
            }
            client.setTickets(tickets);
        }

        return client;
    }

    public DomainClient toDomain(Client client){

        DomainPerson person = new PersonMapper().toDomain(client);
        return new DomainClient(
                person.getPersonId(),
                person.getFirstName(),
                person.getMiddleNames(),
                person.getLastName(),
                person.getDateOfBirth(),
                person.getPhonenumber(),
                person.getAddress(),
                person.getEmail(),
                client.isBusinessClient()
        );
    }
}
