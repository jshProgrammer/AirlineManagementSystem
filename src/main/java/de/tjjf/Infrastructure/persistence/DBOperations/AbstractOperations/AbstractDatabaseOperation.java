package de.tjjf.Infrastructure.persistence.DBOperations.AbstractOperations;

import de.tjjf.Infrastructure.persistence.DataAccessException;
import de.tjjf.Infrastructure.persistence.EntityManagerFactorySingleton;
import de.tjjf.Infrastructure.persistence.results.AbstractResult;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public abstract class AbstractDatabaseOperation<R extends AbstractResult> {
    private EntityManagerFactory emf = EntityManagerFactorySingleton.getInstance();
    protected EntityManager em = null;

    public R execute() {

        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            R result = run();
            em.getTransaction().commit();
            return result;
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new DataAccessException("Error while CRUD-operation", e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public abstract R run();
}