package de.tjjf.Adapter.DatabaseAdapter;

import de.tjjf.Domain.models.MFlight;
import de.tjjf.Domain.ports.DB.DataAccess;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Create.FlightCreateImpl;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Delete.FlightDeleteImpl;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Read.FlightReadImpl;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Update.FlightUpdateImpl;
import de.tjjf.Infrastructure.persistence.mapper.FlightMapper;

public class MFlightRepositoryImpl implements DataAccess.MFlightRepository {
    @Override
    public MFlight create(MFlight flight) {
        // auch das funktioniert noch:
        System.out.println("TEST.z4: " + new FlightMapper().toEntity(flight).getCopilot().getFirstName());

        //TODO: das problem liegt in flightcreateimpl => ???!!!
        System.out.println("Test.z5: " + new FlightCreateImpl(new FlightMapper().toEntity(flight)).execute().model);
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
}
