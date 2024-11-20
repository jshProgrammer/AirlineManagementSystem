package de.tjjf.Infrastructure.persistence.DBOperations.AbstractOperations;

import de.tjjf.Infrastructure.persistence.DataAccessException;
import de.tjjf.Infrastructure.persistence.results.AbstractResult;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public abstract class AbstractDatabaseOperation<R extends AbstractResult> {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory( "my-persistence-unit" );
    protected EntityManager em = null;

    public void execute() {

        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            run();
            em.getTransaction().commit();
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