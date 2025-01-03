package de.tjjf.Domain.ports.API;

import de.tjjf.Domain.models.MFlight;

public interface FlightPort {
    MFlight createFlight(MFlight flight);
    MFlight readFlightByNum(long flightNum);
    void updateFlight(MFlight flight); //TODO: man könnte theoretisch dadurch status auf canceled setzen, ohne email zu verschicken?!
    void cancelFlight(MFlight flight);
}
