package de.tjjf.Domain.ports.API;

import de.tjjf.Domain.models.DomainAirplane;

public interface AirplanePort {
    DomainAirplane createAirplane(DomainAirplane airplane);
    DomainAirplane readAirplaneBySerialNum(int serialNum);
    void setOperable(int serialNum, boolean isOperable);

}
