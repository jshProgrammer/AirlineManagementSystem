package de.tjjf.Infrastructure.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerFactorySingleton {
    private EntityManagerFactorySingleton(){};
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("my-persistence-unit");

    public static EntityManagerFactory getInstance() {
        return emf;
    }
}