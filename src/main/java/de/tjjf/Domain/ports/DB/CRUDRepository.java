package de.tjjf.Domain.ports.DB;

import de.tjjf.Domain.models.MModel;

public interface CRUDRepository<MMmod extends MModel, ID> {
    void create(MMmod entity); // Create
    MMmod readById(ID id); // Read
    //List<MMmod> readAll(); // Read all
    void update(MMmod entity); // Update
    void delete(ID id); // Delete
}
