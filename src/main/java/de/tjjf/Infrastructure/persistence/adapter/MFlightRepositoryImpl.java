package de.tjjf.Infrastructure.persistence.adapter;

import de.tjjf.Domain.models.DomainFlight;
import de.tjjf.Domain.ports.DB.DataAccess;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Create.FlightCreateImpl;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Delete.FlightDeleteImpl;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Read.FlightReadImpl;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Update.FlightUpdateImpl;
import de.tjjf.Infrastructure.persistence.mapper.FlightMapper;

import java.util.List;

public class MFlightRepositoryImpl implements DataAccess.MFlightRepository {
    @Override
    public DomainFlight create(DomainFlight flight) {

        return new FlightMapper().toDomain(new FlightCreateImpl(new FlightMapper().toEntity(flight)).execute().model);
    }

    @Override
    public DomainFlight readById(Long id) {
        return new FlightMapper().toDomain(new FlightReadImpl(id).execute().model);
    }

    @Override
    public void update(DomainFlight entity) {
        new FlightUpdateImpl(new FlightMapper().toEntity(entity), entity.getFlightNum()).execute();
    }

    @Override
    public void delete(Long id) {
        new FlightDeleteImpl(id).execute();
    }

    @Override
    public List<DomainFlight> getAllFlights(int pageNumber, int pageSize) {
        return new FlightReadImpl().getAllFlights(pageNumber, pageSize).stream().map(flight -> new FlightMapper().toDomain(flight)).toList();
    }
}
