package de.tjjf.Domain.ports.API;

import de.tjjf.Domain.models.DomainFlight;

import java.util.List;

public interface FlightPort {
    DomainFlight createFlight(DomainFlight flight);
    DomainFlight readFlightByNum(long flightNum);
    void updateFlight(DomainFlight flight);
    void cancelFlight(DomainFlight flight);
    List<DomainFlight> getAllFlights(int pageNumber, int pageSize);
}
