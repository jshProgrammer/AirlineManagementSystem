package de.tjjf.Infrastructure.persistence;

import de.tjjf.Domain.models.MAirline;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Create.AirlineCreateImpl;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Create.AirplaneCreateImpl;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Read.AirlineReadImpl;
import de.tjjf.Infrastructure.persistence.entities.Airline;
import de.tjjf.Infrastructure.persistence.entities.Airplane;
import de.tjjf.Infrastructure.persistence.entities.Person;
import de.tjjf.Infrastructure.persistence.mapper.AirlineMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class DBAdapter2 {
    public static void main(String[] args) {

        //AirlineCreateImpl airline = new AirlineCreateImpl(new AirlineMapper().toEntity(new MAirline("TestAirline2", new Date(1990), "München")));
        //airline.execute();
        AirplaneCreateImpl airplane = new AirplaneCreateImpl(new Airplane(13, "", "", 1, 2, 2, null, false));
        airplane.execute();
        //AirlineReadImpl a = new AirlineReadImpl("TestAirline");


        EntityManagerFactory emf = EntityManagerFactorySingleton.getInstance();
        EntityManager em = emf.createEntityManager();

        List airlinesInDB = em.createNativeQuery("Select * from Airplane").getResultList();

        System.out.println(airlinesInDB.size());

        for (Object a : airlinesInDB) {
            System.out.println(a);
        }
    }
}
