package de.tjjf.Infrastructure.mapper;

import de.tjjf.Domain.models.MClient;
import de.tjjf.Domain.models.MEmployee;
import de.tjjf.Domain.models.MModel;
import de.tjjf.Infrastructure.models.Client;
import de.tjjf.Infrastructure.models.Employee;
import de.tjjf.Infrastructure.models.Model;

public abstract class Mapper<MMod extends MModel, Mod extends Model> {
    public abstract Mod toEntity(MMod mModel);
    public abstract MMod toDomain(Mod model);
}
