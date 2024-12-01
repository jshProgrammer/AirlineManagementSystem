package de.tjjf.Infrastructure.persistence.results;

import de.tjjf.Infrastructure.persistence.entities.Model;

public class ModelResult<T extends Model> extends AbstractResult {

    public T model;

    public ModelResult(T model) {
        this.model = model;
    }
}
