package de.tjjf.Domain.ports.API;

import de.tjjf.Domain.models.MAirplane;

public interface AirplanePort {
    MAirplane createAirplane(MAirplane airplane);
    MAirplane readAirplaneBySerialNum(int serialNum);
    void setOperable(int serialNum, boolean isOperable);

}
