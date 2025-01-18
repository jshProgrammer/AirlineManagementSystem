package de.tjjf.Domain.ports.API;

import de.tjjf.Domain.models.MFlight;

import java.util.List;

public interface FlightPort {
    MFlight createFlight(MFlight flight);
    MFlight readFlightByNum(long flightNum);
    void updateFlight(MFlight flight);
    void cancelFlight(MFlight flight);
    List<MFlight> getAllFlights(int pageNumber, int pageSize);
}
