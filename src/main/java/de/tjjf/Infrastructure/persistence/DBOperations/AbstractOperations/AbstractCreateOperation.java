package de.tjjf.Infrastructure.persistence.DBOperations.AbstractOperations;

import de.tjjf.Infrastructure.persistence.entities.Model;
import de.tjjf.Infrastructure.persistence.results.ModelResult;
import de.tjjf.Infrastructure.persistence.results.NoContentResult;
import jakarta.transaction.Transactional;

@Transactional
public abstract class AbstractCreateOperation<T extends Model> extends AbstractDatabaseOperation<ModelResult<T>> {

    private T modelToPersist;

    public AbstractCreateOperation(T modelToPersist) {
        super();
        this.modelToPersist = modelToPersist;
    }

    @Override
    public ModelResult<T> run() {
        prePersist();
        em.persist(this.modelToPersist);
        postPersist();
        return new ModelResult<T>(modelToPersist);
    }

    protected void prePersist() {}

    protected void postPersist() {}
}
