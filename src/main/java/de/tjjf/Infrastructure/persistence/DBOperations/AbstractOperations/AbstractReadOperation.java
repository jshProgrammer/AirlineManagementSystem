package de.tjjf.Infrastructure.persistence.DBOperations.AbstractOperations;

import de.tjjf.Infrastructure.persistence.entities.Model;
import de.tjjf.Infrastructure.persistence.results.ModelResult;
import jakarta.transaction.Transactional;

// D = String/int
@Transactional
public abstract class AbstractReadOperation<T extends Model, D> extends AbstractDatabaseOperation<ModelResult<T>> {

    Class<T> type;
    private D identifier;

    public AbstractReadOperation(Class<T> type, D identifier) {
        this.type = type;
        this.identifier = identifier;
    }


    @Override
    public ModelResult<T> run() {
        return new ModelResult<>(em.find( type, identifier ));
    }
}
