package de.tjjf.Domain.ports.API;

import de.tjjf.Domain.models.MAirline;

public interface AirlinePort {
    void createAirline(MAirline airline);
    MAirline readAirlineByName(String name);
    void updateAirline(MAirline airline); // e.g. name or headquarter could change
}
