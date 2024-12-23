package de.tjjf.Infrastructure.persistence.DBOperations.AbstractOperations;

import de.tjjf.Infrastructure.persistence.entities.Model;
import de.tjjf.Infrastructure.persistence.results.NoContentResult;
import jakarta.transaction.Transactional;

@Transactional
public class AbstractCreateOperation<T extends Model> extends AbstractDatabaseOperation<NoContentResult> {

    private T modelToPersist;

    public AbstractCreateOperation(T modelToPersist) {
        super();
        this.modelToPersist = modelToPersist;
    }

    @Override
    public NoContentResult run() {
        em.persist(this.modelToPersist);
        return new NoContentResult();
    }
}
