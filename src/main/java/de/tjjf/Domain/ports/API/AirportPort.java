package de.tjjf.Domain.ports.API;

import de.tjjf.Domain.models.MAirport;

public interface AirportPort {
    MAirport createAirport(MAirport airport);
    MAirport readAirportByCode(String code);
}
