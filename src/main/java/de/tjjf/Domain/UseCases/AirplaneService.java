package de.tjjf.Domain.UseCases;

import de.tjjf.Domain.models.MAirplane;
import de.tjjf.Domain.ports.DB.DataAccess;

public class AirplaneService {
    DataAccess.MAirplaneRepository port;

    public AirplaneService(DataAccess.MAirplaneRepository port) {
        this.port = port;
    }

    public void createAirplane(MAirplane airplane) {
        port.create(airplane);
    }

    public MAirplane readAirplaneBySerialNum(int serialNum) {
        return port.readById(serialNum);
    }

    public void setOperable(int serialNum, boolean isOperable) {
        MAirplane mAirplane = readAirplaneBySerialNum(serialNum);
        mAirplane.setOperable(isOperable);
        port.update(mAirplane);
    }
}
