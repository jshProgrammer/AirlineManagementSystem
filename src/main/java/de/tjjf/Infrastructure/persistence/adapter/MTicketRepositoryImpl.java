package de.tjjf.Infrastructure.persistence.adapter;

import de.tjjf.Domain.models.DomainTicket;
import de.tjjf.Domain.ports.DB.DataAccess;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Create.TicketCreateImpl;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Delete.TicketDeleteImpl;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Read.TicketReadImpl;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Update.FlightUpdateImpl;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Update.TicketUpdateImpl;
import de.tjjf.Infrastructure.persistence.mapper.FlightMapper;
import de.tjjf.Infrastructure.persistence.mapper.TicketMapper;

public class MTicketRepositoryImpl implements DataAccess.MTicketRepository {
    @Override
    public DomainTicket create(DomainTicket entity) {
        DomainTicket newTicket = new TicketMapper().toDomain(new TicketCreateImpl(new TicketMapper().toEntity(entity)).execute().model);
        entity.getFlight().addTicket(entity);
        new FlightUpdateImpl(new FlightMapper().toEntity(entity.getFlight()), entity.getFlight().getFlightNum()).execute();
        return newTicket;
    }

    @Override
    public DomainTicket readById(Long id) {
        return new TicketMapper().toDomain(new TicketReadImpl(id).execute().model);
    }

    @Override
    public void update(DomainTicket entity) {
        new TicketUpdateImpl(new TicketMapper().toEntity(entity), entity.getTicketId()).execute();
    }

    @Override
    public void delete(Long id) {
        new TicketDeleteImpl(id).execute();
    }
}
