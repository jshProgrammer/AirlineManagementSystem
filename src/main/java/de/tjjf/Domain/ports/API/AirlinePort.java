package de.tjjf.Domain.ports.API;

import de.tjjf.Domain.models.DomainAirline;

public interface AirlinePort {
    DomainAirline createAirline(DomainAirline airline);
    DomainAirline readAirlineByName(String name);
    void updateAirline(DomainAirline airline); // e.g. name or headquarter could change
}
