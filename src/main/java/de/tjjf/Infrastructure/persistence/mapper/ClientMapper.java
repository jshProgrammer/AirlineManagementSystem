package de.tjjf.Infrastructure.persistence.mapper;

import de.tjjf.Domain.models.MClient;
import de.tjjf.Domain.models.MPerson;
import de.tjjf.Domain.models.MTicket;
import de.tjjf.Infrastructure.persistence.entities.Client;
import de.tjjf.Infrastructure.persistence.entities.Ticket;

import java.util.ArrayList;
import java.util.List;

public class ClientMapper extends Mapper<MClient, Client>{
    public Client toEntity(MClient mClient) {
        return toEntity(mClient, true);
    }

    public Client toEntity(MClient mClient, boolean mapTickets){
        Client client = new Client(
                //mClient.getPersonId(),
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
            for (MTicket mTicket : mClient.getTickets()) {
                Ticket ticket = new TicketMapper().toEntity(mTicket);
                ticket.setClient(client);
                tickets.add(ticket);
            }
            client.setTickets(tickets);
        }

        return client;
    }

    public Client toEntityWithId(MClient mClient) {
        return toEntityWithId(mClient, true);
    }

    public Client toEntityWithId(MClient mClient, boolean mapTickets) {
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
            for (MTicket mTicket : mClient.getTickets()) {
                Ticket ticket = new TicketMapper().toEntity(mTicket);
                ticket.setClient(client);
                tickets.add(ticket);
            }
            client.setTickets(tickets);
        }

        return client;
    }

    public MClient toDomain(Client client){

        MPerson person = new PersonMapper().toDomain(client);
        return new MClient(
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
