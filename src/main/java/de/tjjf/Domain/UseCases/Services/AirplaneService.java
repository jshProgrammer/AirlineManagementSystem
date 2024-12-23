package de.tjjf.Domain.UseCases.Services;

import de.tjjf.Domain.Exceptions.UnauthorizedException;
import de.tjjf.Domain.UseCases.AuthenticationUseCase;
import de.tjjf.Domain.UseCases.AuthorizedUseCase;
import de.tjjf.Domain.UseCases.CancelTicketUseCase;
import de.tjjf.Domain.models.MAirplane;
import de.tjjf.Domain.ports.DB.DataAccess;

public class AirplaneService extends AuthorizedUseCase {
    DataAccess.MAirplaneRepository port;

    public AirplaneService(DataAccess.MAirplaneRepository port) {
        super(AuthenticationUseCase.getInstance());
        this.port = port;

    }

    public MAirplane createAirplane(MAirplane airplane) {
        new CancelTicketUseCase().authorize();
        return port.create(airplane);
    }

    public MAirplane readAirplaneBySerialNum(int serialNum) throws UnauthorizedException {
        new CancelTicketUseCase().authorize();
        return port.readById(serialNum);
    }

    public void setOperable(int serialNum, boolean isOperable) {
        new CancelTicketUseCase().authorize();
        MAirplane mAirplane = readAirplaneBySerialNum(serialNum);
        mAirplane.setOperable(isOperable);
        port.update(mAirplane);
    }
}
