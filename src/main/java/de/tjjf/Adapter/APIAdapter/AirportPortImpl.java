package de.tjjf.Adapter.APIAdapter;

import de.tjjf.Adapter.DatabaseAdapter.MAirlineRepositoryImpl;
import de.tjjf.Adapter.DatabaseAdapter.MAirportRepsoitoryImp;
import de.tjjf.Domain.UseCases.Services.AirlineService;
import de.tjjf.Domain.UseCases.Services.AirportService;
import de.tjjf.Domain.models.MAirport;
import de.tjjf.Domain.ports.API.AirportPort;

public class AirportPortImpl implements AirportPort {
    @Override
    public void createAirport(MAirport airport){
        new AirportService(new MAirportRepsoitoryImp()).createAirport(airport);

    }

    @Override
    public MAirport readAirportByCode(String code) {
        return new AirportService(new MAirportRepsoitoryImp()).readAirportByCode(code);

    }
}
