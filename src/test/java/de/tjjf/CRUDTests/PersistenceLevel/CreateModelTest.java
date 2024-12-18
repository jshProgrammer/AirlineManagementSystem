package de.tjjf.CRUDTests.PersistenceLevel;

import com.stripe.model.Person;
import de.tjjf.Domain.models.*;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Create.*;
import de.tjjf.Infrastructure.persistence.EntityManagerFactorySingleton;
import de.tjjf.Infrastructure.persistence.entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class CreateModelTest {

    EntityManagerFactory emf = EntityManagerFactorySingleton.getInstance();
    EntityManager em = emf.createEntityManager();

    @Test
    public void testCreatingAirline() {

        String name = "TestAirline" + UUID.randomUUID().getMostSignificantBits();
        Date date = new Date();
        String headQuarters = "TestHeadquarters";
        String phoneNumber = "+4915112345678";
        String email = "testmail@gmail.com";
        String address = "testAddress";

        AirlineCreateImpl airlineCreate = new AirlineCreateImpl(new Airline(name, date, headQuarters, email, phoneNumber, address));
        airlineCreate.execute();

        Airline retrievedAirline = (Airline) em.createQuery("SELECT a FROM Airline a WHERE a.name = :name")
                .setParameter("name", name)
                .getSingleResult();

        assertNotNull(retrievedAirline);
        assertEquals(retrievedAirline.getName(), name);
        assertEquals(retrievedAirline.getFoundationYear(), date);
        assertEquals(retrievedAirline.getHeadQuarters(), headQuarters);
        assertEquals(retrievedAirline.getAddress(), address);
        assertEquals(retrievedAirline.getPhoneNumber(), phoneNumber);
        assertEquals(retrievedAirline.getMail(), email);

        em.getTransaction().begin();
        em.remove(retrievedAirline);
        em.getTransaction().commit();

        List<Airline> airlinesAfterDeletion = em.createQuery("SELECT a FROM Airline a WHERE a.name = :name")
                .setParameter("name", name)
                .getResultList();
        assertTrue(airlinesAfterDeletion.isEmpty());
    }

    @Test
    public void testCreatingAirplane() {

        // create Airline for Airplane and safe it int db
        Airline airline = new Airline("TestAirline" + UUID.randomUUID().getMostSignificantBits(),
                new Date(), "TestHeadquarters",
                "testairline@gmail.com", "+4915112345678", "TestAddress");
        AirlineCreateImpl airlineCreate = new AirlineCreateImpl(airline);
        airlineCreate.execute();

        // attributes for airplane
        int serialNum = 9999999;
        String manufacturer = "TestManufacturer";
        String model = "TestModel";
        int amountOfEconomySeats = 50;
        int amountOfBusinessSeats = 25;
        int amountOfFirstClassSeats = 15;
        boolean isOperable = true;
        int maxWeightOfLuggage = 40000;

        //saving airplane in db
        AirplaneCreateImpl airplaneCreate = new AirplaneCreateImpl(new Airplane(serialNum, manufacturer, model, amountOfEconomySeats,
                amountOfBusinessSeats, amountOfFirstClassSeats,
                airline, isOperable, maxWeightOfLuggage));
        airplaneCreate.execute();

        // retrieve airplane from db
        Airplane retrievedAirplane = (Airplane) em.createQuery("SELECT a FROM Airplane a WHERE a.serialNum = :serialNum")
                .setParameter("serialNum", serialNum)
                .getSingleResult();

        // assert attributes
        assertNotNull(retrievedAirplane);
        assertEquals(retrievedAirplane.getSerialNum(), serialNum);
        assertEquals(retrievedAirplane.getManufacturer(), manufacturer);
        assertEquals(retrievedAirplane.getModel(), model);
        assertEquals(retrievedAirplane.getAmoutOfEconomySeats(), amountOfEconomySeats);
        assertEquals(retrievedAirplane.getAmoutOfBusinessSeats(), amountOfBusinessSeats);
        assertEquals(retrievedAirplane.getAmoutOfFirstClassSeats(), amountOfFirstClassSeats);
        assertEquals(retrievedAirplane.getBelongingAirline(), airline);
        assertEquals(retrievedAirplane.getMaxWeightOfLuggage(), maxWeightOfLuggage);
        assertEquals(retrievedAirplane.isOperatable(), isOperable);

        // delete all entities created
        em.getTransaction().begin();
        em.remove(retrievedAirplane);
        em.remove(em.find(Airline.class, airline.getName()));
        em.getTransaction().commit();

        // asserting airplane has been deleted
        List<Airplane> airplanesAfterDeletion = em.createQuery("SELECT a FROM Airplane a WHERE a.serialNum = :serialNum")
                .setParameter("serialNum", serialNum)
                .getResultList();
        assertTrue(airplanesAfterDeletion.isEmpty());

        // asserting airline has been deleted
        List<Airline> airlinesAfterDeletion = em.createQuery("SELECT a FROM Airline a WHERE a.name = :name")
                .setParameter("name", airline.getName())
                .getResultList();
        assertTrue(airlinesAfterDeletion.isEmpty());
    }



    @Test
    public void testCreatingMAirport() {
        String code = "TestCode";
        String name = "TestName";
        String country = "TestCountry";
        String city = "TestCity";
        String timezone = "TestTimezone";

        AirportCreateImpl airportCreate = new AirportCreateImpl(new Airport(code, name, country, city, timezone));
        airportCreate.execute();

        Airport retrievedAirport = (Airport) em.createQuery("SELECT a FROM Airport a WHERE a.code = :code")
                .setParameter("code", code)
                .getSingleResult();

        assertNotNull(retrievedAirport);
        assertEquals(retrievedAirport.getCode(), code);
        assertEquals(retrievedAirport.getName(), name);
        assertEquals(retrievedAirport.getCountry(), country);
        assertEquals(retrievedAirport.getCity(), city);
        assertEquals(retrievedAirport.getTimezone(), timezone);

        em.getTransaction().begin();
        em.remove(retrievedAirport);
        em.getTransaction().commit();

        List<Airport> airportsAfterDeletion = em.createQuery("SELECT a FROM Airport a WHERE a.code = :code")
                .setParameter("code", code)
                .getResultList();
        assertTrue(airportsAfterDeletion.isEmpty());
    }


    @Test
    public void testCreatingClient() {
        long personId = 8888888;
        String firstName = "TestFirstName";
        String lastName = "TestLastName";
        String middleName = "TestMiddleName";
        Date dateOfBirth = new Date();
        String phoneNumber = "+4915112345678";
        String address = "testAddress";
        String email = "testmail@gmail.com";
        String password = "TestPassword";
        List<Ticket> tickets = new ArrayList<>();
        Boolean isBusinessClient = true;

        ClientCreateImpl clientCreate = new ClientCreateImpl(new Client(personId, firstName, middleName, lastName, dateOfBirth, phoneNumber, address, email, password, tickets, isBusinessClient));
        clientCreate.execute();

        Client retrievedClient = (Client) em.createQuery("SELECT c FROM Client c WHERE c.personId = :personId")
                .setParameter("personId", personId)
                .getSingleResult();

        assertNotNull(retrievedClient);
        assertEquals(retrievedClient.getPersonId(), personId);
        assertEquals(retrievedClient.getFirstName(), firstName);
        assertEquals(retrievedClient.getLastName(), lastName);
        assertEquals(retrievedClient.getMiddleName(), middleName);
        assertEquals(retrievedClient.getDateOfBirth(), dateOfBirth);
        assertEquals(retrievedClient.getPhonenumber(), phoneNumber);
        assertEquals(retrievedClient.getAddress(), address);
        assertEquals(retrievedClient.getTickets(), tickets);
        assertEquals(retrievedClient.getEmail(), email);
        assertEquals(retrievedClient.isBusinessClient(), isBusinessClient);

        em.getTransaction().begin();
        em.remove(retrievedClient);
        em.getTransaction().commit();

        List<Client> clientsAfterDeletion = em.createQuery("SELECT c FROM Client c WHERE c.personId = :personId")
                .setParameter("personId", personId)
                .getResultList();
        assertTrue(clientsAfterDeletion.isEmpty());
    }


    @Test
    public void testCreatingEmployee() {
        long personId = 7777777;
        String firstName = "TestFirstName";
        String lastName = "TestLastName";
        String middleName = "TestMiddleName";
        Date dateOfBirth = new Date();
        String phoneNumber = "+4915112345678";
        String address = "testAddress";
        String email = "testmail@gmail.com";
        String password = "TestPassword";
        List<Ticket> tickets = new ArrayList<>();
        int salary = 100;
        String position = "TestPosition";
        Airline airline = new Airline("TestAirline" + UUID.randomUUID().getMostSignificantBits(),
                new Date(), "TestHeadquarters", "airline@gmail.com", "+4915112345678", "TestAddress");
        AirlineCreateImpl airlineCreate = new AirlineCreateImpl(airline);
        airlineCreate.execute();
        Date hireDate = new Date();

        EmployeeCreateImpl employeeCreate = new EmployeeCreateImpl(new Employee(personId, firstName, middleName, lastName, dateOfBirth,
                phoneNumber, address, email, password, tickets, salary, position, airline, hireDate));
        employeeCreate.execute();

        Employee retrievedEmployee = (Employee) em.createQuery("SELECT e FROM Employee e WHERE e.personId = :personId")
                .setParameter("personId", personId)
                .getSingleResult();

        assertNotNull(retrievedEmployee);
        assertEquals(retrievedEmployee.getPersonId(), personId);
        assertEquals(retrievedEmployee.getFirstName(), firstName);
        assertEquals(retrievedEmployee.getMiddleName(), middleName);
        assertEquals(retrievedEmployee.getLastName(), lastName);
        assertEquals(retrievedEmployee.getDateOfBirth(), dateOfBirth);
        assertEquals(retrievedEmployee.getPhonenumber(), phoneNumber);
        assertEquals(retrievedEmployee.getAddress(), address);
        assertEquals(retrievedEmployee.getEmail(), email);
        assertEquals(retrievedEmployee.getSalary(), salary);
        assertEquals(retrievedEmployee.getPosition(), position);
        assertEquals(retrievedEmployee.getAirline(), airline);
        assertEquals(retrievedEmployee.getHireDate(), hireDate);

        em.getTransaction().begin();
        em.remove(retrievedEmployee);
        em.remove(em.find(Airline.class, airline.getName()));
        em.getTransaction().commit();

        List<Employee> employeesAfterDeletion = em.createQuery("SELECT e FROM Employee e WHERE e.personId = :personId")
                .setParameter("personId", personId)
                .getResultList();
        assertTrue(employeesAfterDeletion.isEmpty());

        List<Airline> airlinesAfterDeletion = em.createQuery("SELECT a FROM Airline a WHERE a.name = :name")
                .setParameter("name", airline.getName())
                .getResultList();
        assertTrue(airlinesAfterDeletion.isEmpty());
    }


    @Test
    public void testCreatingFlight() {
        long flightNum = 6666666;
        String status = "testStatus";
        int duration = 12345678;
        Date date = new Date();

        Airline airline = new Airline("TestAirline" + UUID.randomUUID().getMostSignificantBits(),
                new Date(), "TestHeadquarters", "airline@gmail.com", "+4915112345678", "TestAddress");
        AirlineCreateImpl airlineCreate = new AirlineCreateImpl(airline);
        airlineCreate.execute();

        Airplane airplane = new Airplane(6666669, "TestManufacturer", "TestModel", 100, 50, 20, airline, true, 30000);
        AirplaneCreateImpl airplaneCreate = new AirplaneCreateImpl(airplane);
        airplaneCreate.execute();

        Airport departureAirport = new Airport("DPT", "Departure Airport", "CountryA", "CityA", "TimezoneA");
        AirportCreateImpl departureAirportCreate = new AirportCreateImpl(departureAirport);
        departureAirportCreate.execute();

        Airport arrivalAirport = new Airport("ARR", "Arrival Airport", "CountryB", "CityB", "TimezoneB");
        AirportCreateImpl arrivalAirportCreate = new AirportCreateImpl(arrivalAirport);
        arrivalAirportCreate.execute();

        Employee pilot = new Employee(6666668, "PilotFirstName", "PilotMiddleName", "PilotLastName", new Date(),
                "+491512345678", "PilotAddress", "pilot@gmail.com", "password", new ArrayList<>(), 100000, "Captain", airline, new Date());
        EmployeeCreateImpl pilotCreate = new EmployeeCreateImpl(pilot);
        pilotCreate.execute();

        Employee copilot = new Employee(6666667, "CoPilotFirstName", "CoPilotMiddleName", "CoPilotLastName", new Date(),
                "+491512345679", "CoPilotAddress", "copilot@gmail.com", "password", new ArrayList<>(), 80000, "First Officer", airline, new Date());
        EmployeeCreateImpl copilotCreate = new EmployeeCreateImpl(copilot);
        copilotCreate.execute();

        FlightCreateImpl flightCreate = new FlightCreateImpl(new Flight(flightNum, airplane, date, departureAirport, date,
                arrivalAirport, date, status, duration, pilot, copilot));
        flightCreate.execute();

        Flight retrievedFlight = (Flight) em.createQuery("SELECT f FROM Flight f WHERE f.flightNum = :flightNum")
                .setParameter("flightNum", flightNum)
                .getSingleResult();

        assertNotNull(retrievedFlight);
        assertEquals(retrievedFlight.getFlightNum(), flightNum);
        assertEquals(retrievedFlight.getAirplane(), airplane);
        assertEquals(retrievedFlight.getDepartureDateTime(), departureAirport.getTimezone());
        assertEquals(retrievedFlight.getDepartureAirport(), departureAirport);
        assertEquals(retrievedFlight.getArrivalDateTime(), arrivalAirport.getTimezone());
        assertEquals(retrievedFlight.getArrivalAirport(), arrivalAirport);
        assertEquals(retrievedFlight.getBoardingTime(), date);
        assertEquals(retrievedFlight.getStatus(), status);
        assertEquals(retrievedFlight.getDuration(), duration);
        assertEquals(retrievedFlight.getPilot(), pilot);
        assertEquals(retrievedFlight.getCopilot(), copilot);

        em.getTransaction().begin();
        em.remove(retrievedFlight);
        em.remove(em.find(Airplane.class, airplane.getSerialNum()));
        em.remove(em.find(Airport.class, departureAirport.getName()));
        em.remove(em.find(Airport.class, arrivalAirport.getName()));
        em.remove(em.find(Employee.class, pilot.getPersonId()));
        em.remove(em.find(Employee.class, copilot.getPersonId()));
        em.remove(em.find(Airline.class, airline.getName()));
        em.getTransaction().commit();

        List<Flight> flightsAfterDeletion = em.createQuery("SELECT f FROM Flight f WHERE f.flightNum = :flightNum")
                .setParameter("flightNum", flightNum)
                .getResultList();
        assertTrue(flightsAfterDeletion.isEmpty());

        List<Airplane> airplanesAfterDeletion = em.createQuery("SELECT a FROM Airplane a WHERE a.serialNum = :serialNum")
                .setParameter("serialNum", airplane.getSerialNum())
                .getResultList();
        assertTrue(airplanesAfterDeletion.isEmpty());

        List<Airport> departureAirportsAfterDeletion = em.createQuery("SELECT a FROM Airport a WHERE a.code = :code")
                .setParameter("code", departureAirport.getCode())
                .getResultList();
        assertTrue(departureAirportsAfterDeletion.isEmpty());

        List<Airport> arrivalAirportsAfterDeletion = em.createQuery("SELECT a FROM Airport a WHERE a.code = :code")
                .setParameter("code", arrivalAirport.getCode())
                .getResultList();
        assertTrue(arrivalAirportsAfterDeletion.isEmpty());

        List<Employee> pilotsAfterDeletion = em.createQuery("SELECT e FROM Employee e WHERE e.personId = :personId")
                .setParameter("personId", pilot.getPersonId())
                .getResultList();
        assertTrue(pilotsAfterDeletion.isEmpty());

        List<Employee> copilotsAfterDeletion = em.createQuery("SELECT e FROM Employee e WHERE e.personId = :personId")
                .setParameter("personId", copilot.getPersonId())
                .getResultList();
        assertTrue(copilotsAfterDeletion.isEmpty());

        List<Airline> airlinesAfterDeletion = em.createQuery("SELECT a FROM Airline a WHERE a.name = :name")
                .setParameter("name", airline.getName())
                .getResultList();
        assertTrue(airlinesAfterDeletion.isEmpty());
    }


    @Test
    public void testCreatingMTicket() {
        Airline airline = new Airline("TestAirline" + UUID.randomUUID().getMostSignificantBits(),
                new Date(), "TestHeadquarters", "airline@gmail.com", "+4915112345678", "TestAddress");
        AirlineCreateImpl airlineCreate = new AirlineCreateImpl(airline);
        airlineCreate.execute();

        Airplane airplane = new Airplane(5555559, "TestManufacturer", "TestModel", 100, 50, 20, airline, true, 30000);
        AirplaneCreateImpl airplaneCreate = new AirplaneCreateImpl(airplane);
        airplaneCreate.execute();

        Airport departureAirport = new Airport("DPT", "Departure Airport", "CountryA", "CityA", "TimezoneA");
        AirportCreateImpl departureAirportCreate = new AirportCreateImpl(departureAirport);
        departureAirportCreate.execute();

        Airport arrivalAirport = new Airport("ARR", "Arrival Airport", "CountryB", "CityB", "TimezoneB");
        AirportCreateImpl arrivalAirportCreate = new AirportCreateImpl(arrivalAirport);
        arrivalAirportCreate.execute();

        Employee pilot = new Employee(5555558, "PilotFirstName", "PilotMiddleName", "PilotLastName", new Date(),
                "+491512345678", "PilotAddress", "pilot@gmail.com", "password", new ArrayList<>(), 100000, "Captain", airline, new Date());
        EmployeeCreateImpl pilotCreate = new EmployeeCreateImpl(pilot);
        pilotCreate.execute();

        Employee copilot = new Employee(5555557, "CoPilotFirstName", "CoPilotMiddleName", "CoPilotLastName", new Date(),
                "+491512345679", "CoPilotAddress", "copilot@gmail.com", "password", new ArrayList<>(), 80000, "First Officer", airline, new Date());
        EmployeeCreateImpl copilotCreate = new EmployeeCreateImpl(copilot);
        copilotCreate.execute();

        Flight flight = new Flight(5555556, airplane, new Date(), departureAirport, new Date(),
                arrivalAirport, new Date(), "testStatus", 123, pilot, copilot);
        FlightCreateImpl flightCreate = new FlightCreateImpl(flight);
        flightCreate.execute();

        int ticketId = 5555555;
        long person = 12345678;
        Date dateTimeOfBooking = new Date();
        int totalPrice = 300;
        int seatNum = 15;
        String seatingClass = "testSeatingClass";
        String ticketStatus = "testTicketStatus";
        int weightOfLuggage = 20;

        TicketCreateImpl ticketCreate = new TicketCreateImpl(new Ticket(ticketId, person, flight, dateTimeOfBooking, totalPrice,
                seatNum, seatingClass, ticketStatus, weightOfLuggage));
        ticketCreate.execute();

        Ticket retrievedTicket = (Ticket) em.createQuery("SELECT t FROM Ticket t WHERE t.ticketId = :ticketId")
                .setParameter("ticketId", ticketId)
                .getSingleResult();

        assertNotNull(retrievedTicket);
        assertEquals(retrievedTicket.getTicketId(), ticketId);
        assertEquals(retrievedTicket.getPersonId(), person);
        assertEquals(retrievedTicket.getFlight(), flight);
        assertEquals(retrievedTicket.getDateTimeOfBooking(), dateTimeOfBooking);
        assertEquals(retrievedTicket.getTotalPrice(), (totalPrice + weightOfLuggage * 4));
        assertEquals(retrievedTicket.getSeatNum(), seatNum);
        assertEquals(retrievedTicket.getSeatingClass(), seatingClass);
        assertEquals(retrievedTicket.getTicketStatus(), ticketStatus);
        assertEquals(retrievedTicket.getMaxWeightOfLuggage(), weightOfLuggage);

        em.getTransaction().begin();
        em.remove(retrievedTicket);
        em.remove(em.find(Flight.class, flight.getFlightNum()));
        em.remove(em.find(Airplane.class, airplane.getSerialNum()));
        em.remove(em.find(Airport.class, departureAirport.getName()));
        em.remove(em.find(Airport.class, arrivalAirport.getName()));
        em.remove(em.find(Employee.class, pilot.getPersonId()));
        em.remove(em.find(Employee.class, copilot.getPersonId()));
        em.remove(em.find(Airline.class, airline.getName()));
        em.getTransaction().commit();

        List<Ticket> ticketsAfterDeletion = em.createQuery("SELECT t FROM Ticket t WHERE t.ticketId = :ticketId")
                .setParameter("ticketId", ticketId)
                .getResultList();
        assertTrue(ticketsAfterDeletion.isEmpty());
    }

}
