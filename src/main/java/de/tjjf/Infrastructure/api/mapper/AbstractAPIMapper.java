package de.tjjf.Infrastructure.api.mapper;

import de.tjjf.Domain.models.DomainModel;
import de.tjjf.Infrastructure.api.models.APIModel;

public abstract class AbstractAPIMapper<APIMod extends APIModel, MMod extends DomainModel> {
    public abstract APIMod toAPIEntity(MMod mModel);
    public abstract MMod toDomainEntity(APIMod model);
}


