package de.tjjf.Infrastructure.api.mapper;

import de.tjjf.Domain.models.MModel;
import de.tjjf.Infrastructure.api.models.APIModel;

public abstract class AbstractAPIMapper<APIMod extends APIModel, MMod extends MModel> {
    public abstract APIMod toAPIEntity(MMod mModel);
    public abstract MMod toDomainEntity(APIMod model);
}


