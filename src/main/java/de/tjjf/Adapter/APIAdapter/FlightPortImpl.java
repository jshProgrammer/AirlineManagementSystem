package de.tjjf.Adapter.APIAdapter;

import de.tjjf.Domain.models.MFlight;
import de.tjjf.Domain.ports.API.FlightPort;

public class FlightPortImpl implements FlightPort {
    @Override
    public void createFlight(MFlight flight) {

    }

    @Override
    public MFlight readFlightByNum(long flightNum) {
        return null;
    }

    @Override
    public void updateFlight(MFlight flight) {
        //return null; Rauswerfen von MFlight und rückgabe auf Void
    }

    public void cancelFlight(MFlight flight) {

    }
}