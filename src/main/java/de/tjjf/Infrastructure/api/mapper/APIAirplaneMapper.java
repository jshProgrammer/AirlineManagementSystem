package de.tjjf.Infrastructure.api.mapper;

import de.tjjf.Domain.models.MAirplane;
import de.tjjf.Infrastructure.api.models.APIAirplane;
import de.tjjf.Adapter.APIAdapter.AirlinePortImpl;

public class APIAirplaneMapper extends AbstractAPIMapper<APIAirplane, MAirplane> {

    @Override
    public APIAirplane toAPIEntity(MAirplane mAirplane){
        return new APIAirplane(
                mAirplane.getSerialNum(),
                mAirplane.getBelongingAirline().getName(),
                mAirplane.isOperable()
        );
    }

    @Override
    public MAirplane toDomainEntity(APIAirplane model){
        return new MAirplane(
                model.getSerialNum(),
                "DefaultManufacturer",
                "DefaultModel",
                100,
                20,
                10,
                new AirlinePortImpl().readAirlineByName(model.getBelongingAirlineName()),
                model.getIsOperable(),
                5000
        );
    }
}
