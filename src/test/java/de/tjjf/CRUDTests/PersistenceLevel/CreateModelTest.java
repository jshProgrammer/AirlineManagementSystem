package de.tjjf.CRUDTests.PersistenceLevel;

import com.stripe.model.Person;
import de.tjjf.Domain.models.*;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Create.AirlineCreateImpl;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Create.AirplaneCreateImpl;
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

        int serialNum = 1234;
        String manufacturer = "TestManufacturer";
        String model = "TestModel";
        int amountOfEconomySeats = 50;
        int amountOfBusinessSeats = 25;
        int amountOfFirstClassSeats = 15;
        Airline airline =  new Airline("TestAirline" + UUID.randomUUID().getMostSignificantBits(),
                new Date(), "TestHeadquarters",
                "testairline@gmail.com", "+4915112345678", "TestAddress");
        AirlineCreateImpl airlineCreate= new AirlineCreateImpl(airline);
        airlineCreate.execute();
        boolean isOperable = true;
        int maxWeightOfLuggage = 40000;

        AirplaneCreateImpl airplane = new AirplaneCreateImpl( new Airplane(serialNum, manufacturer, model, amountOfEconomySeats,
                amountOfBusinessSeats, amountOfFirstClassSeats,
                airline, isOperable, maxWeightOfLuggage));
        airplane.execute();

        Airplane retrievedAirplane = (Airplane) em.createQuery("SELECT a FROM Airplane a WHERE a.serialNum = :serialNum")
                .setParameter("serialNum", serialNum)
                .getSingleResult();

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

        em.getTransaction().begin();
        em.remove(retrievedAirplane);
        em.remove(airline);
        em.getTransaction().commit();

        List<Airplane> airplanesAfterDeletion = em.createQuery("SELECT a FROM Airplane a WHERE a.serialNum = :serialNum")
                .setParameter("serialNum", serialNum)
                .getResultList();
        assertTrue(airplanesAfterDeletion.isEmpty());
    }


    @Test
    public void testCreatingMAirport(){
        String code = "TestCode";
        String name = "TestName";
        String country = "TestCountry";
        String city = "TestCity";
        String timezone = "TestTimezone";

        Airport airport = new Airport(code, name, country, city, timezone);

        assertEquals(airport.getCode(), code);
        assertEquals(airport.getName(), name);
        assertEquals(airport.getCountry(), country);
        assertEquals(airport.getCity(), city);
        assertEquals(airport.getTimezone(), timezone);
    }

    public void testCreatingClient(){
        long personId = 987654321;
        String firstName = "TestFirstName";
        String lastName = "TestLastName";
        String middleName = "TestMiddleName";
        Date dateofBirth = new Date();
        String phoneNumber = "+4915112345678";
        String address = "testAddress";
        String email = "testmail@gmail.com";
        String password = "TestPassword";
        List<Ticket> tickets = new ArrayList<>( );
        Boolean isBusinessClient = true;

        Client client = new Client(personId, firstName, middleName, lastName, dateofBirth, phoneNumber, address, email, password, tickets, isBusinessClient);

        assertEquals(client.getPersonId(), personId);
        assertEquals(client.getFirstName(), firstName);
        assertEquals(client.getLastName(), lastName);
        assertEquals(client.getMiddleName(), middleName);
        assertEquals(client.getDateOfBirth(), dateofBirth);
        assertEquals(client.getPhonenumber(), phoneNumber);
        assertEquals(client.getAddress(), address);
        assertEquals(client.getTickets(), tickets);
        assertEquals(client.getEmail(), email);
        if(isBusinessClient){
            assertTrue(client.isBusinessClient());
        }else{
            assertFalse(client.isBusinessClient());
        }
    }

    @Test
    public void testCreatingEmployee(){
        long personId = 987654321;
        String firstName = "TestFirstName";
        String lastName = "TestLastName";
        String middleName = "TestMiddleName";
        Date dateofBirth = new Date();
        String phoneNumber = "+4915112345678";
        String address = "testAddress";
        String email = "testmail@gmail.com";
        String password = "TestPassword";
        List<Ticket> tickets = new ArrayList<>();
        int salary = 100;
        String position = "TestPosition";
        Airline airline = new Airline(null, null, null, null, "+4915112345678", "airline@gmail.com");
        Date hireDate = new Date();

        Employee employee = new Employee(personId, firstName, middleName, lastName, dateofBirth, phoneNumber, address, email, password,tickets,  salary, position, airline, hireDate);

        assertEquals(employee.getPersonId(), personId);
        assertEquals(employee.getFirstName(), firstName);
        assertEquals(employee.getMiddleName(), middleName);
        assertEquals(employee.getLastName(), lastName);
        assertEquals(employee.getDateOfBirth(), dateofBirth);
        assertEquals(employee.getDateOfBirth(), dateofBirth);
        assertEquals(employee.getPhonenumber(), phoneNumber);
        assertEquals(employee.getAddress(), address);
        assertEquals(employee.getEmail(), email);
        assertEquals(employee.getSalary(), salary);
        assertEquals(employee.getPosition(), position);
        assertEquals(employee.getAirline(), airline);
        assertEquals(employee.getHireDate(), hireDate);
    }

    @Test
    public void testCreatingFlight(){
        long flightNum = 1234;
        Airplane airplane = new Airplane();
        Date departureDateTime = new Date();
        Airport departureAirport = new Airport();
        Date arrivalDateTime = new Date();
        Airport arrivalAirport = new Airport();
        Date boardingTime = new Date();
        String flyStatus = "testStatus";
        int duration = 123;
        Employee pilot = new Employee();
        Employee copilot = new Employee();

        Flight flight = new Flight(flightNum, airplane, departureDateTime, departureAirport, arrivalDateTime, arrivalAirport, boardingTime, flyStatus, duration, pilot, copilot);

        assertEquals(flight.getFlightNum(), flightNum);
        assertEquals(flight.getAirplane(), airplane);
        assertEquals(flight.getDepartureDateTime(), departureDateTime);
        assertEquals(flight.getDepartureAirport(), departureAirport);
        assertEquals(flight.getArrivalDateTime(), arrivalDateTime);
        assertEquals(flight.getArrivalAirport(), arrivalAirport);
        assertEquals(flight.getBoardingTime(), boardingTime);
        assertEquals(flight.getStatus(), flyStatus);
        assertEquals(flight.getDuration(), duration);
        assertEquals(flight.getPilot(), pilot);
        assertEquals(flight.getCopilot(), copilot);
    }

    @Test
    public void testCreatingMTicket() {
        int ticketId = 1234;
        long person = 12345678;
        Flight mFlight = new Flight();
        Date dateTimeOfBooking = new Date();
        int totalPrice = 300;
        int seatNum = 15;
        String seatingClass = "testSeatingClass";
        String ticketStatus = "testTicketStatus";
        int weightOfLuggage = 20;

        Ticket mTicket = new Ticket(ticketId, person, mFlight, dateTimeOfBooking, totalPrice, seatNum, seatingClass, ticketStatus, weightOfLuggage);

        assertEquals(mTicket.getTicketId(), ticketId);
        assertEquals(mTicket.getPersonId(), person);
        assertEquals(mTicket.getFlight(), mFlight);
        assertEquals(mTicket.getDateTimeOfBooking(), dateTimeOfBooking);
        assertEquals(mTicket.getTotalPrice(), (totalPrice + weightOfLuggage * 4)); //see MTicket.setLuggageWeight()
        assertEquals(mTicket.getSeatNum(), seatNum);
        assertEquals(mTicket.getSeatingClass(), seatingClass);
        assertEquals(mTicket.getTicketStatus(), ticketStatus);
        assertEquals(mTicket.getMaxWeightOfLuggage(), weightOfLuggage);
    }
}
