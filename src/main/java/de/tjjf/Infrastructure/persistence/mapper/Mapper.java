package de.tjjf.Infrastructure.persistence.mapper;

import de.tjjf.Domain.models.MModel;
import de.tjjf.Infrastructure.persistence.entities.Model;

public abstract class Mapper<MMod extends MModel, Mod extends Model> {
    public abstract Mod toEntity(MMod mModel);
    public abstract MMod toDomain(Mod model);
}
