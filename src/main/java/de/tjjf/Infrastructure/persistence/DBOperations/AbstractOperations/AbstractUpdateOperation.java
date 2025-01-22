package de.tjjf.Infrastructure.persistence.DBOperations.AbstractOperations;

import de.tjjf.Infrastructure.persistence.entities.Model;
import de.tjjf.Infrastructure.persistence.results.NoContentResult;
import jakarta.persistence.Id;
import jakarta.transaction.Transactional;

import java.lang.reflect.Field;

@Transactional
public abstract class AbstractUpdateOperation<T extends Model, IDType> extends AbstractDatabaseOperation<NoContentResult>{
    IDType id;
    T modelToChange;

    public AbstractUpdateOperation(T modelToChange, IDType id) {
        this.id = id;
        this.modelToChange = modelToChange;
    }

    @Override
    public NoContentResult run() {
        prePersist();

        T existingEntity = (T) em.find(modelToChange.getClass(), id);

        if (existingEntity == null) {
            throw new RuntimeException("Entity with ID " + id + " not found");
        }

        copyNonNullProperties(modelToChange, existingEntity);

        em.merge( existingEntity );
        postPersist();
        return new NoContentResult();
    }

    private void copyNonNullProperties(T source, T target) {
        for (Field field : source.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                if (field.isAnnotationPresent(Id.class)) {
                    continue;
                }
                Object value = field.get(source);
                if (value != null) {
                    field.set(target, value);
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Error while copying properties", e);
            }
        }
    }

    protected void prePersist() {}

    protected void postPersist() {}
}
