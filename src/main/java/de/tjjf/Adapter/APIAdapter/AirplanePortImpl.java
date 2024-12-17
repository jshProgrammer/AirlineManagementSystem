package de.tjjf.Adapter.APIAdapter;

import de.tjjf.Adapter.DatabaseAdapter.MAirlineRepositoryImpl;
import de.tjjf.Adapter.DatabaseAdapter.MAirplaneRepositoryImpl;
import de.tjjf.Domain.UseCases.Services.AirlineService;
import de.tjjf.Domain.UseCases.Services.AirplaneService;
import de.tjjf.Domain.models.MAirplane;
import de.tjjf.Domain.ports.API.AirplanePort;

public class AirplanePortImpl implements AirplanePort {
    @Override
    public void createAirplane(MAirplane airplane) {
        new AirplaneService(new MAirplaneRepositoryImpl()).createAirplane(airplane);
    }

    @Override
    public MAirplane readAirplaneBySerialNum(int serialNum) {
        return new AirplaneService(new MAirplaneRepositoryImpl()).readAirplaneBySerialNum(serialNum);
    }

    @Override
    public void setOperable(int serialNum, boolean isOperable) {
        new AirplaneService(new MAirplaneRepositoryImpl()).setOperable(serialNum, isOperable);;
    }
}
