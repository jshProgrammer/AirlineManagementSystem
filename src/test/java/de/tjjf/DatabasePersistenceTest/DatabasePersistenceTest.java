package de.tjjf.DatabasePersistenceTest;

import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Create.AirlineCreateImpl;
import de.tjjf.Infrastructure.persistence.DataAccessException;
import de.tjjf.Infrastructure.persistence.EntityManagerFactorySingleton;
import de.tjjf.Infrastructure.persistence.entities.Airline;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

public class DatabasePersistenceTest {
    EntityManagerFactory emf = EntityManagerFactorySingleton.getInstance();
    EntityManager em = emf.createEntityManager();


    @Test
    public void createNewAirplane() {
        List airlinesInDBBefore = em.createNativeQuery("Select * from Airline").getResultList();
        int sizeBefore = airlinesInDBBefore.size();

        //TODO: hier noch einen Mapper verwenden
        AirlineCreateImpl airline = new AirlineCreateImpl(new Airline("Test" + UUID.randomUUID().getMostSignificantBits(), Date.valueOf("2010-01-01"), "München"));
        airline.execute();

        List airlinesInDBAfter = em.createNativeQuery("Select * from Airline").getResultList();

        int sizeAfter = airlinesInDBAfter.size();

        assertEquals(sizeBefore+1, sizeAfter);
    }

    @Test
    public void createExistingAirplane() {
        long hash = UUID.randomUUID().getMostSignificantBits();
        AirlineCreateImpl airline = new AirlineCreateImpl(new Airline("Test" + hash, Date.valueOf("2010-01-01"), "München"));
        airline.execute();

         try {
             airline = new AirlineCreateImpl(new Airline("Test" + hash, Date.valueOf("2011-01-01"), "Frankfurt"));
             airline.execute();
             fail("DataAccessException expected as two entries with same identifier have been created");
         } catch (DataAccessException e){}
    }
}
