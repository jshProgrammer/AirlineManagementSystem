package de.tjjf.Adapter.APIAdapter;

import de.tjjf.Adapter.DatabaseAdapter.MAirportRepsoitoryImp;
import de.tjjf.Domain.UseCases.Services.AirportService;
import de.tjjf.Domain.models.DomainAirport;
import de.tjjf.Domain.ports.API.AirportPort;

public class AirportPortImpl implements AirportPort {
    @Override
    public DomainAirport createAirport(DomainAirport airport){
        return new AirportService(new MAirportRepsoitoryImp()).createAirport(airport);

    }

    @Override
    public DomainAirport readAirportByCode(String code) {
        return new AirportService(new MAirportRepsoitoryImp()).readAirportByCode(code);

    }
}
