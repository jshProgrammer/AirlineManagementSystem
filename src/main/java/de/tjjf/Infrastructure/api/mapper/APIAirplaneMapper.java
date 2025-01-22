package de.tjjf.Infrastructure.api.mapper;

import de.tjjf.Domain.models.DomainAirplane;
import de.tjjf.Infrastructure.api.models.APIAirplane;
import de.tjjf.Infrastructure.api.adapter.AirlinePortImpl;

public class APIAirplaneMapper extends AbstractAPIMapper<APIAirplane, DomainAirplane> {

    @Override
    public APIAirplane toAPIEntity(DomainAirplane mAirplane){
        return new APIAirplane(
                mAirplane.getSerialNum(),
                mAirplane.getBelongingAirline().getName(),
                mAirplane.isOperable()
        );
    }

    @Override
    public DomainAirplane toDomainEntity(APIAirplane model){
        return new DomainAirplane(
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
