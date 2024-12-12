package de.tjjf.Adapter.APIAdapter;

import de.tjjf.Adapter.DatabaseAdapter.MAirlineRepositoryImpl;
import de.tjjf.Domain.UseCases.Services.AirlineService;
import de.tjjf.Domain.models.MAirline;
import de.tjjf.Domain.ports.API.AirlinePort;

public class AirlinePortImpl implements AirlinePort {
    @Override
    public void createAirline(MAirline airline) {
        new AirlineService(new MAirlineRepositoryImpl()).create(airline);
    }

    @Override
    public MAirline readAirlineByName(String name) {
        return new AirlineService(new MAirlineRepositoryImpl()).readById(name);
    }

    @Override
    public void updateAirline(MAirline airline) {
        new AirlineService(new MAirlineRepositoryImpl()).update(airline);;
    }
}
