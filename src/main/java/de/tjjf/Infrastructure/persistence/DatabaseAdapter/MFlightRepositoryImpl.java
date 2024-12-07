package de.tjjf.Infrastructure.persistence.DatabaseAdapter;

import de.tjjf.Domain.models.MFlight;
import de.tjjf.Domain.models.MTicket;
import de.tjjf.Domain.ports.DataAccess;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Create.FlightCreateImpl;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Delete.FlightDeleteImpl;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Delete.TicketDeleteImpl;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Read.FlightReadImpl;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Read.TicketReadImpl;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Update.FlightUpdateImpl;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Update.TicketUpdateImpl;
import de.tjjf.Infrastructure.persistence.mapper.FlightMapper;
import de.tjjf.Infrastructure.persistence.mapper.TicketMapper;

public class MFlightRepositoryImpl implements DataAccess.MFlightRepository {
    @Override
    public void create(MFlight flight) {
        new FlightCreateImpl(new FlightMapper().toEntity(flight)).execute();
    }

    @Override
    public MFlight readById(Long id) {
        return new FlightMapper().toDomain(new FlightReadImpl(id).execute().model);
    }

    @Override
    public void update(MFlight entity) {
        new FlightUpdateImpl(new FlightMapper().toEntity(entity)).execute();
    }

    @Override
    public void delete(Long id) {
        new FlightDeleteImpl(id).execute();
    }
}
