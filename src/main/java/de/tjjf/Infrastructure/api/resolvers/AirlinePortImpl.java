package de.tjjf.Infrastructure.api.resolvers;

import de.tjjf.Domain.models.MAirline;
import de.tjjf.Domain.ports.API.AirlinePort;

public class AirlinePortImpl implements AirlinePort {
    @Override
    public void createAirline(MAirline airline) {

    }

    @Override
    public MAirline readAirlineByName(String name) {
        return null;
    }

    @Override
    public MAirline updateAirline(MAirline airline) {
        return null;
    }
}
