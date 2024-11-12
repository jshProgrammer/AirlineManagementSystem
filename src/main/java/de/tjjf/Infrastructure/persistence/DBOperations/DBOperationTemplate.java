package de.tjjf.Infrastructure.persistence.DBOperations;

import de.tjjf.Infrastructure.persistence.DataAccessException;
import de.tjjf.Infrastructure.persistence.entities.Model;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public abstract class DBOperationTemplate {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory( "my-persistence-unit" );
    protected EntityManager em = null;

    Model result;

    public enum CRUD {
        Create, Read, Update, Delete;
    }


    public void execute(CRUD desiredOperation) {

        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            switch(desiredOperation) {
                case CRUD.Create -> create();
                case CRUD.Read -> read();
                case CRUD.Update -> update();
                case CRUD.Delete -> delete();
            }
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

    public abstract void create();
    public abstract void read();
    public abstract void update();
    public abstract void delete();
}