package de.tjjf.Domain.ports.API;

import de.tjjf.Domain.models.DomainAirport;

public interface AirportPort {
    DomainAirport createAirport(DomainAirport airport);
    DomainAirport readAirportByCode(String code);
}
