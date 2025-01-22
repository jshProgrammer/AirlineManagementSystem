package de.tjjf.Infrastructure.api.adapter;

import de.tjjf.Infrastructure.persistence.adapter.MAirlineRepositoryImpl;
import de.tjjf.Domain.UseCases.Services.AirlineService;
import de.tjjf.Domain.models.DomainAirline;
import de.tjjf.Domain.ports.API.AirlinePort;

public class AirlinePortImpl implements AirlinePort {
    @Override
    public DomainAirline createAirline(DomainAirline airline) {
        return new AirlineService(new MAirlineRepositoryImpl()).create(airline);
    }

    @Override
    public DomainAirline readAirlineByName(String name) {
        return new AirlineService(new MAirlineRepositoryImpl()).readById(name);
    }

    @Override
    public void updateAirline(DomainAirline airline) {
        new AirlineService(new MAirlineRepositoryImpl()).update(airline);;
    }
}
