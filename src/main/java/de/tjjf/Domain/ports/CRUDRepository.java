package de.tjjf.Domain.ports;

import de.tjjf.Domain.models.MModel;

import java.util.List;

public interface CRUDRepository<MMmod extends MModel, ID> {
    void create(MMmod entity); // Create
    MMmod readById(ID id); // Read
    //List<MMmod> readAll(); // Read all
    void update(MMmod entity); // Update
    void delete(ID id); // Delete
}
