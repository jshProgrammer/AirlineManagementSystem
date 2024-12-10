package de.tjjf.Adapter.APIAdapter;

import de.tjjf.Domain.models.MAirplane;
import de.tjjf.Domain.ports.API.AirplanePort;

public class AirplanePortImpl implements AirplanePort {
    @Override
    public void createAirplane(MAirplane airplane) {

    }

    @Override
    public MAirplane readAirplaneBySerialNum(int serialNum) {
        return null;
    }

    @Override
    public void setOperable(int serialNum, boolean isOperable) {

    }
}
