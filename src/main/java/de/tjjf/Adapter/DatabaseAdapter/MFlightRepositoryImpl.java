package de.tjjf.Adapter.DatabaseAdapter;

import de.tjjf.Domain.models.MFlight;
import de.tjjf.Domain.ports.DB.DataAccess;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Create.FlightCreateImpl;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Delete.FlightDeleteImpl;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Read.FlightReadImpl;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Update.FlightUpdateImpl;
import de.tjjf.Infrastructure.persistence.EntityManagerFactorySingleton;
import de.tjjf.Infrastructure.persistence.entities.Flight;
import de.tjjf.Infrastructure.persistence.mapper.FlightMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.List;

public class MFlightRepositoryImpl implements DataAccess.MFlightRepository {
    @Override
    public MFlight create(MFlight flight) {

        return new FlightMapper().toDomain(new FlightCreateImpl(new FlightMapper().toEntity(flight)).execute().model);
    }

    @Override
    public MFlight readById(Long id) {
        return new FlightMapper().toDomain(new FlightReadImpl(id).execute().model);
    }

    @Override
    public void update(MFlight entity) {
        new FlightUpdateImpl(new FlightMapper().toEntity(entity), entity.getFlightNum()).execute();
    }

    @Override
    public void delete(Long id) {
        new FlightDeleteImpl(id).execute();
    }

    @Override
    public List<MFlight> getAllFlights(int pageNumber, int pageSize) {
        return new FlightReadImpl().getAllFlights(pageNumber, pageSize).stream().map(flight -> new FlightMapper().toDomain(flight)).toList();
    }
}
