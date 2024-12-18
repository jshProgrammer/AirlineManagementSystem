package de.tjjf.CRUDTests.PersistenceLevel;

import de.tjjf.Domain.models.*;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Create.*;
import de.tjjf.Infrastructure.persistence.EntityManagerFactorySingleton;
import de.tjjf.Infrastructure.persistence.entities.*;
import org.junit.jupiter.api.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UpdateModelTest {
    EntityManagerFactory emf = EntityManagerFactorySingleton.getInstance();
    EntityManager em = emf.createEntityManager();
    static Airline airline;
    static Airplane airplane;
    static Airport departureAirport;
    static Airport arrivalAirport;
    static Client client;
    static Employee employee;
    static Flight flight;
    static Ticket ticket;

    @BeforeAll
    public static void setup() {
        EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
        em.getTransaction().begin();

        airline = new Airline("TestAirline", new Date(), "TestHeadquarters", "testemail@gmail.com", "+4915112345678", "TestAddress");
        AirlineCreateImpl airlineCreate = new AirlineCreateImpl(airline);
        airlineCreate.execute();

        airplane = new Airplane(9999999, "TestManufacturer", "TestModel", 50, 25, 15, airline, true, 40000);
        AirplaneCreateImpl airplaneCreate = new AirplaneCreateImpl(airplane);
        airplaneCreate.execute();

        departureAirport = new Airport("DPT", "Departure Airport", "CountryA", "CityA", "TimezoneA");
        AirportCreateImpl departureAirportCreate = new AirportCreateImpl(departureAirport);
        departureAirportCreate.execute();

        arrivalAirport = new Airport("ARR", "Arrival Airport", "CountryB", "CityB", "TimezoneB");
        AirportCreateImpl arrivalAirportCreate = new AirportCreateImpl(arrivalAirport);
        arrivalAirportCreate.execute();

        client = new Client(8888888, "TestFirstName", "TestMiddleNames", "TestLastName", new Date(), "+4915112345678", "TestAddress", "testemail@gmail.com", "TestPassword", new ArrayList<>(), true);
        ClientCreateImpl clientCreate = new ClientCreateImpl(client);
        clientCreate.execute();

        employee = new Employee(7777777, "TestEmployee", "TestMiddleNames", "TestLastName", new Date(), "+4915112345678", "TestAddress", "employee@gmail.com", "password", new ArrayList<>(), 100, "TestPosition", airline, new Date());
        EmployeeCreateImpl employeeCreate = new EmployeeCreateImpl(employee);
        employeeCreate.execute();

        flight = new Flight(6666666, airplane, new Date(), departureAirport, new Date(), arrivalAirport, new Date(), "testStatus", 123, employee, employee);
        FlightCreateImpl flightCreate = new FlightCreateImpl(flight);
        flightCreate.execute();

        ticket = new Ticket(5555555, 8888888, flight, new Date(), 300, 15, "Economy", "Active", 20);
        TicketCreateImpl ticketCreate = new TicketCreateImpl(ticket);
        ticketCreate.execute();

        em.getTransaction().commit();
        em.close();
    }

    @AfterAll
    public static void teardown() {
        EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
        em.getTransaction().begin();

        em.remove(em.find(Ticket.class, ticket.getTicketId()));
        em.remove(em.find(Flight.class, flight.getFlightNum()));
        em.remove(em.find(Airplane.class, airplane.getSerialNum()));
        em.remove(em.find(Airport.class, departureAirport.getCode()));
        em.remove(em.find(Airport.class, arrivalAirport.getCode()));
        em.remove(em.find(Employee.class, employee.getPersonId()));
        em.remove(em.find(Client.class, client.getPersonId()));
        em.remove(em.find(Airline.class, airline.getName()));

        em.getTransaction().commit();
        em.close();
    }


    @Test
    public void testUpdateMAirline() {
        String updatedName = "UpdatedAirline";
        String updatedHeadquarters = "UpdatedHeadquarters";
        String updatedEmail = "updatedEmail@gmail.com";
        String updatedPhoneNumber = "+4915198765432";
        String updatedAddress = "updatedAddress";

        em.getTransaction().begin();
        Airline airline = em.createQuery("SELECT a FROM Airline a", Airline.class).getSingleResult();
        airline.setName(updatedName);
        airline.setHeadQuarters(updatedHeadquarters);
        airline.setMail(updatedEmail);
        airline.setPhoneNumber(updatedPhoneNumber);
        airline.setAddress(updatedAddress);
        em.merge(airline);
        em.getTransaction().commit();

        Airline updatedAirline = em.createQuery("SELECT a FROM Airline a", Airline.class).getSingleResult();
        assertEquals(updatedAirline.getName(), updatedName);
        assertEquals(updatedAirline.getHeadQuarters(), updatedHeadquarters);
        assertEquals(updatedAirline.getMail(), updatedEmail);
        assertEquals(updatedAirline.getPhoneNumber(), updatedPhoneNumber);
        assertEquals(updatedAirline.getAddress(), updatedAddress);
    }

    @Test
    public void testUpdateMAirplane() {
        boolean updatedIsOperable = false;
        em.getTransaction().begin();
        Airplane airplane = em.createQuery("SELECT a FROM Airplane a", Airplane.class).getSingleResult();
        airplane.setOperatable(updatedIsOperable);
        em.merge(airplane);
        em.getTransaction().commit();

        Airplane updatedAirplane = em.createQuery("SELECT a FROM Airplane a", Airplane.class).getSingleResult();
        assertEquals(updatedAirplane.isOperatable(), updatedIsOperable);
    }

    @Test
    public void testUpdateAirport() {
        String updatedName = "UpdatedAirport";
        String updatedCountry = "UpdatedCountry";
        String updatedCity = "UpdatedCity";
        String updatedTimezone = "UpdatedTimezone";

        em.getTransaction().begin();
        Airport departureAirport = em.createQuery("SELECT a FROM Airport a WHERE a.code = 'DPT'", Airport.class).getSingleResult();
        departureAirport.setName(updatedName);
        departureAirport.setCountry(updatedCountry);
        departureAirport.setCity(updatedCity);
        departureAirport.setTimezone(updatedTimezone);
        em.merge(departureAirport);
        em.getTransaction().commit();

        Airport updatedAirport = em.createQuery("SELECT a FROM Airport a WHERE a.code = 'DPT'", Airport.class).getSingleResult();
        assertEquals(updatedAirport.getName(), updatedName);
        assertEquals(updatedAirport.getCountry(), updatedCountry);
        assertEquals(updatedAirport.getCity(), updatedCity);
        assertEquals(updatedAirport.getTimezone(), updatedTimezone);
    }

    @Test
    public void testUpdateClient() {
        boolean updatedIsBusinessClient = false;

        em.getTransaction().begin();
        Client client = em.createQuery("SELECT c FROM Client c", Client.class).getSingleResult();
        client.setBusinessClient(updatedIsBusinessClient);
        em.merge(client);
        em.getTransaction().commit();

        Client updatedClient = em.createQuery("SELECT c FROM Client c", Client.class).getSingleResult();
        assertEquals(updatedClient.isBusinessClient(), updatedIsBusinessClient);
    }

    @Test
    public void testUpdateEmployee() {
        int updatedSalary = 200;
        String updatedPosition = "UpdatedPosition";

        em.getTransaction().begin();
        Employee employee = em.createQuery("SELECT e FROM Employee e", Employee.class).getSingleResult();
        employee.setSalary(updatedSalary);
        employee.setPosition(updatedPosition);
        em.merge(employee);
        em.getTransaction().commit();

        Employee updatedEmployee = em.createQuery("SELECT e FROM Employee e", Employee.class).getSingleResult();
        assertEquals(updatedEmployee.getSalary(), updatedSalary);
        assertEquals(updatedEmployee.getPosition(), updatedPosition);
    }

    @Test
    public void testUpdateFlight() {
        String updatedStatus = "UpdatedStatus";

        em.getTransaction().begin();
        Flight flight = em.createQuery("SELECT f FROM Flight f", Flight.class).getSingleResult();
        flight.setStatus(updatedStatus);
        em.merge(flight);
        em.getTransaction().commit();

        Flight updatedFlight = em.createQuery("SELECT f FROM Flight f", Flight.class).getSingleResult();
        assertEquals(updatedFlight.getStatus(), updatedStatus);
    }

    @Test
    public void testUpdateTicket() {
        String updatedTicketStatus = "UpdatedTicketStatus";

        em.getTransaction().begin();
        Ticket ticket = em.createQuery("SELECT t FROM Ticket t", Ticket.class).getSingleResult();
        ticket.setTicketStatus(updatedTicketStatus);
        em.merge(ticket);
        em.getTransaction().commit();

        Ticket updatedTicket = em.createQuery("SELECT t FROM Ticket t", Ticket.class).getSingleResult();
        assertEquals(updatedTicket.getTicketStatus(), updatedTicketStatus);
    }
}
