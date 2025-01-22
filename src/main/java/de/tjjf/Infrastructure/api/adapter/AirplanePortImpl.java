package de.tjjf.Infrastructure.api.adapter;

import de.tjjf.Infrastructure.persistence.adapter.MAirplaneRepositoryImpl;
import de.tjjf.Domain.UseCases.Services.AirplaneService;
import de.tjjf.Domain.models.DomainAirplane;
import de.tjjf.Domain.ports.API.AirplanePort;

public class AirplanePortImpl implements AirplanePort {
    @Override
    public DomainAirplane createAirplane(DomainAirplane airplane) {
        return new AirplaneService(new MAirplaneRepositoryImpl()).createAirplane(airplane);
    }

    @Override
    public DomainAirplane readAirplaneBySerialNum(int serialNum) {
        return new AirplaneService(new MAirplaneRepositoryImpl()).readAirplaneBySerialNum(serialNum);
    }

    @Override
    public void setOperable(int serialNum, boolean isOperable) {
        new AirplaneService(new MAirplaneRepositoryImpl()).setOperable(serialNum, isOperable);;
    }
}
