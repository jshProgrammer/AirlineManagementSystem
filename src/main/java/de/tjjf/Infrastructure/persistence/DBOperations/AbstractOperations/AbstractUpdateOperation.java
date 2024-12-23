package de.tjjf.Infrastructure.persistence.DBOperations.AbstractOperations;

import de.tjjf.Infrastructure.persistence.entities.Model;
import de.tjjf.Infrastructure.persistence.results.NoContentResult;
import jakarta.transaction.Transactional;

@Transactional
public class AbstractUpdateOperation<T extends Model> extends AbstractDatabaseOperation<NoContentResult>{

    T modelToChange;

    public AbstractUpdateOperation(T modelToChange) {
        this.modelToChange = modelToChange;
    }

    @Override
    public NoContentResult run() {
        em.merge( modelToChange );
        return new NoContentResult();
    }
}
