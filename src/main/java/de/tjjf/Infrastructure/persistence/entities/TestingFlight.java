package de.tjjf.Infrastructure.persistence.entities;
import de.tjjf.Adapter.DatabaseAdapter.MAirplaneRepositoryImpl;
import de.tjjf.Domain.models.MAirplane;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Create.*;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Delete.FlightDeleteImpl;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Read.*;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Update.AirlineUpdateImpl;
import de.tjjf.Infrastructure.persistence.EntityManagerFactorySingleton;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

public class TestingFlight {

    private EntityManagerFactory emf = EntityManagerFactorySingleton.getInstance();


        public void addFlight(Flight flight) {
            EntityManager em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();
            try {
                transaction.begin();
                em.persist(flight);
                transaction.commit();
            } catch (Exception e) {
                if (transaction.isActive()) {
                    transaction.rollback();
                }
                throw e;
            } finally {
                em.close();
            }
        }

    public List<Flight> getAllFlights() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Flight> query = em.createQuery("SELECT f FROM Flight f", Flight.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }



        public static void main(String[] args) {
            TestingFlight testingFlight = new TestingFlight();

            Ticket ticket = new TicketCreateImpl(
                    new Ticket(
                            1,
                            new FlightReadImpl(102).execute().model,
                            new Date(2020, 10, 10),
                            1000,
                            12,
                            "First",
                            "scheduled",
                            1000
                    )
            ).execute().model;

            System.out.println(ticket.getTicketId());

            System.out.println ( new FlightReadImpl (new TicketReadImpl(1).execute().model.getFlight().getFlightNum() ).execute().model.getArrivalAirport().getCode());


            //TODO: Flight funktioniert, sogar mit unseren ImplOperations

            //TODO: update funktioniert icht
            new AirlineUpdateImpl(new Airline("Lufthansa", new Date(2000, 10, 10), "Munich", "test@test.de", "9123123", "street;1;91241;Berlin;France")).execute();

            System.out.println("Test whether update worked: " + new AirlineReadImpl("Lufthansa").execute().model.getAddress());

            //Airline airline = new AirlineCreateImpl(new Airline("testest", new Date(2000, 10, 10), "Munich", "test@test.de", "9123123", "street;1;91241;Berlin;Germany")).execute().model;

            Airline airline = new AirlineReadImpl("testest").execute().model;

            /*Airplane airplane = new AirplaneCreateImpl(
                    new Airplane(1232147119,
                            "Boeing", "747",
                            500, 299, 100,
                            airline, true, 1000)).execute().model;*/

            Airplane airplane = new AirplaneReadImpl(1232147119).execute().model;

            System.out.println("FUNKTIONIERT " + airplane.getSerialNum());

            System.out.println("Macht das was?!");
            MAirplane mAirplane = new MAirplaneRepositoryImpl().readById(1232147119);
            System.out.println(mAirplane.getSerialNum());
            System.out.println(mAirplane.getModel());


            //Airport fra = new AirportCreateImpl(new Airport("FRA", "Frankfurt", "Germany", "Frankfurt", "CET")).execute().model;
            Airport fra = new AirportReadImpl("FRA").execute().model;

            Flight flight = new Flight(
                   airplane,
                    new Date(2000, 10, 10),
                    fra,
                    new Date(2000, 10, 10),
                    fra,
                    new Date(2000, 10, 10),
                    "scheduled",    1000, null, null
            );
            testingFlight.addFlight(flight);



            System.out.println(testingFlight.getAllFlights().size());


            testingFlight.getAllFlights().forEach(f -> System.out.println(f.getFlightNum()));
            new FlightDeleteImpl(flight.getFlightNum()).execute();
            System.out.println(testingFlight.getAllFlights().size());

            EntityManagerFactory emf = EntityManagerFactorySingleton.getInstance();
            EntityManager em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();

            //TODO: client funktioniert
            /*
            try {
                transaction.begin();

                Client client = new Client(
                        "TestFirstName",
                        "TestMiddleName",
                        "TestLastName",
                        new Date(),
                        "+4915112345678",
                        "TestAddress",
                        "testemail@gmail.com",
                        "TestPassword",
                        new ArrayList<>(),
                        true
                );

                em.persist(client);
                transaction.commit();
            } catch (Exception e) {
                if (transaction.isActive()) {
                    transaction.rollback();
                }
                e.printStackTrace();
            } finally {
                em.close();
            }*/




            //TODO: employee funktioniert
            /*try {
                transaction.begin();

                Employee employee = new Employee(
                        "Tom",
                        "TestMiddleName",
                        "Mustermann",
                        new Date(),
                        "+4915112345678",
                        "TestAddress",
                        "test@test.de",
                        "TestPassword",
                        new ArrayList<>(),
                        1000,
                        "TestPosition",
                        null,
                        new Date());


                em.persist(employee);
                transaction.commit();
            } catch (Exception e) {
                if (transaction.isActive()) {
                    transaction.rollback();
                }
                e.printStackTrace();
            } finally {
                em.close();
            }

            EntityManager em2 = emf.createEntityManager();
            try {
                TypedQuery<Employee> query = em2.createQuery("SELECT f FROM Employee f", Employee.class);
                query.getResultList().forEach(f -> System.out.println(f.getPersonId() + " " + f.getFirstName()));
            } finally {
                em.close();
            }*/


        }

}
