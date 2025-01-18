package de.tjjf.Domain.ports.DB;

import de.tjjf.Domain.models.MModel;

public interface CRUDRepository<MMmod extends MModel, ID> {
    MMmod create(MMmod entity);
    MMmod readById(ID id);
    void update(MMmod entity);
    void delete(ID id);
}
