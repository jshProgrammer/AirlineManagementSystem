package de.tjjf.Adapter.APIAdapter;

import de.tjjf.Adapter.DatabaseAdapter.MFlightRepositoryImpl;
import de.tjjf.Domain.UseCases.Services.FlightService;
import de.tjjf.Domain.models.MFlight;
import de.tjjf.Domain.ports.API.FlightPort;

import java.util.List;

public class FlightPortImpl implements FlightPort {
    @Override
    public MFlight createFlight(MFlight flight) {
        return new FlightService(new MFlightRepositoryImpl()).createFlight(flight);
    }

    @Override
    public MFlight readFlightByNum(long flightNum) {
        return new FlightService(new MFlightRepositoryImpl()).readFlightByNum(flightNum);
    }

    @Override
    public void updateFlight(MFlight flight) {
        new FlightService(new MFlightRepositoryImpl()).updateFlight(flight);
    }

    public void cancelFlight(MFlight flight) {
        new FlightService(new MFlightRepositoryImpl()).cancelFlight(flight);
    }

    @Override
    public List<MFlight> getAllFlights(int pageNumber, int pageSize) {
        return new FlightService(new MFlightRepositoryImpl()).getAllFlights(pageNumber, pageSize);
    }
}
