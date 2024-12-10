package de.tjjf.Adapter.APIAdapter;

import de.tjjf.Domain.models.MAirport;
import de.tjjf.Domain.ports.API.AirportPort;

public class AirportPortImpl implements AirportPort {
    @Override
    public void createAirport(MAirport airport){

    }

    @Override
    public MAirport readAirportByCode(String code) {
        return null;
    }
}
