package de.tjjf.Infrastructure.persistence.DBOperations.AbstractOperations;

import de.tjjf.Infrastructure.persistence.entities.Model;
import de.tjjf.Infrastructure.persistence.results.NoContentResult;
import jakarta.transaction.Transactional;

@Transactional
public class AbstractDeleteOperation<T extends Model, I> extends AbstractDatabaseOperation<NoContentResult> {

    I identifier;
    Class<T> classOfModel;

    public AbstractDeleteOperation(Class<T> classOfModel, I identifier) {
        this.classOfModel = classOfModel;
        this.identifier = identifier;
    }

    @Override
    public NoContentResult run() {
        final Model result = em.find( classOfModel, identifier);
        if ( result != null )
        {
            em.remove( result );
        }
        return new NoContentResult();
    }
}
