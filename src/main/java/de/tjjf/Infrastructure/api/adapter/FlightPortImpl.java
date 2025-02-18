package de.tjjf.Infrastructure.api.adapter;

import de.tjjf.Infrastructure.persistence.adapter.MFlightRepositoryImpl;
import de.tjjf.Domain.UseCases.Services.FlightService;
import de.tjjf.Domain.models.DomainFlight;
import de.tjjf.Domain.ports.API.FlightPort;

import java.util.List;

public class FlightPortImpl implements FlightPort {
    @Override
    public DomainFlight createFlight(DomainFlight flight) {
        return new FlightService(new MFlightRepositoryImpl()).createFlight(flight);
    }

    @Override
    public DomainFlight readFlightByNum(long flightNum) {
        return new FlightService(new MFlightRepositoryImpl()).readFlightByNum(flightNum);
    }

    @Override
    public void updateFlight(DomainFlight flight) {
        new FlightService(new MFlightRepositoryImpl()).updateFlight(flight);
    }

    public void cancelFlight(DomainFlight flight) {
        new FlightService(new MFlightRepositoryImpl()).cancelFlight(flight);
    }

    @Override
    public List<DomainFlight> getAllFlights(int pageNumber, int pageSize) {
        return new FlightService(new MFlightRepositoryImpl()).getAllFlights(pageNumber, pageSize);
    }
}
