package de.tjjf.Infrastructure.api.MapperInput;

import de.tjjf.Infrastructure.api.InputModels.APIAirplaneInput;
import de.tjjf.Infrastructure.api.models.APIAirplane;

public class AirplaneMapperInput {

    public APIAirplaneInput toClient(APIAirplane airplane){
        return new APIAirplaneInput(
                airplane.getSerialNum(),
                airplane.getBelongingAirline(),
                airplane.isOperable()
        );
    }

    public APIAirplane toDomain(APIAirplaneInput airplane){
        return new APIAirplane(
                airplane.getSerialNum(),
                airplane.getBelongingAirline(),
                airplane.isOperable()
        );
    }
}
