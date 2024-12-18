package de.tjjf.CRUDTests.PersistenceLevel;

import de.tjjf.Domain.models.*;
import de.tjjf.Infrastructure.persistence.EntityManagerFactorySingleton;
import de.tjjf.Infrastructure.persistence.entities.*;
import jakarta.persistence.Persistence;
import org.glassfish.jaxb.core.v2.TODO;
import org.junit.jupiter.api.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpdateModelTest {
    Airline airline;
    Airplane airplane;
    Airport departureAirport;
    Airport arrivalAirport;
    Client client;
    Employee employee;
    Flight flight;
    Ticket ticket;

    EntityManagerFactory emf = EntityManagerFactorySingleton.getInstance();
    EntityManager em = emf.createEntityManager();

    @BeforeEach
    public void setup() {
        em = emf.createEntityManager();
        em.getTransaction().begin(); // Beginne die Transaktion
    }

    @AfterEach
    public void teardown() {
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback(); // Rollback nach jedem Test
        }
        em.close();
    }

    @AfterAll
    public static void closeEntityManagerFactory() {
        if (emf != null) {
            emf.close();
        }
    }
    @BeforeEach
    public void beforeEach() {
        String airlineName = "TestAirline";
        Date airlineDate = new Date();
        String airlineHeadQuarters = "TestHeadquarters";
        String airlineAddress = "testAirlineAddress";
        String airlinePhoneNumber = "+4915112345678";
        String airlineEmail = "testemail@gmail.com";
        airline = new Airline(airlineName , airlineDate, airlineHeadQuarters, airlineEmail, airlinePhoneNumber, airlineAddress);

        int airplaneSerialNum = 1234;
        String airplaneManufacturer = "TestManufacturer";
        String airplaneModel = "TestModel";
        int airplaneAmountOfEconomySeats = 50;
        int airplaneAmountOfBusinessSeats = 25;
        int airplaneAmountOfFirstClassSeats = 15;
        boolean airplaneIsOperable = true;
        int airplaneMaxWeightOfLuggage = 40000;
        airplane = new Airplane(airplaneSerialNum, airplaneManufacturer, airplaneModel, airplaneAmountOfEconomySeats, airplaneAmountOfBusinessSeats, airplaneAmountOfFirstClassSeats, airline, airplaneIsOperable, airplaneMaxWeightOfLuggage);

        String departureAirportCode = "departureTestCode";
        String departureAirportName = "departureTestName";
        String departureAirportCountry = "departureTestCountry";
        String departureAirportCity = "departureTestCity";
        String departureAirportTimezone = "departureTestTimezone";
        departureAirport = new Airport(departureAirportCode, departureAirportName, departureAirportCountry, departureAirportCity, departureAirportTimezone);

        String arrivalAirportCode = "arrivalTestCode";
        String arrivalAirportName = "arrivalTestName";
        String arrivalAirportCountry = "arrivalTestCountry";
        String arrivalAirportCity = "arrivalTestCity";
        String arrivalAirportTimezone = "arrivalTestTimezone";
        arrivalAirport = new Airport(arrivalAirportCode, arrivalAirportName, arrivalAirportCountry, arrivalAirportCity, arrivalAirportTimezone);

        long clientPersonId = 9999999;
        String clientFirstName = "TestClientFirstName";
        String clientMiddleNames = "TestClientMiddleNames";
        String clientLastName = "TestClientLastName";
        Date clientDateOfBirth = new Date();
        String clientPhoneNumber = "+4915112345678";
        String clientAddress = "testClientAddress";
        String clientEmail = "testemail@gmail.com";
        String clientPassword = "testpassword";
        List<Ticket> clientTickets = new ArrayList<Ticket>();
        boolean clientIsBusinessClient = true;
        client = new Client(clientPersonId, clientFirstName, clientMiddleNames, clientLastName, clientDateOfBirth, clientPhoneNumber, clientAddress, clientEmail, clientPassword, clientTickets, clientIsBusinessClient);

        long employeePersonId = 9999999;
        String employeeFirstName = "TestEmployeetFirstName";
        String employeeMiddleNames = "TestEmployeeMiddleNames";
        String employeeLastName = "TestEmployeeLastName";
        Date employeeDateOfBirth = new Date();
        String employeePhoneNumber = "+4915112345678";
        String employeeAddress = "testEmployeeAddress";
        String employeeEmail = "testemail@gmail.com";
        String employeePassword = "testpassword";
        int employeeSalary = 100;
        String employeePosition = "TestPosition";
//ToDo check if different constructor is neccessary
        Airline employeeAirline = new Airline();
        Date employeeHireDate = new Date();
        List<Ticket> employeeTickets = new ArrayList<>();
        employee = new Employee(employeePersonId, employeeFirstName, employeeMiddleNames, employeeLastName, employeeDateOfBirth, employeePhoneNumber, employeeAddress, employeeEmail, employeePassword, employeeTickets, employeeSalary, employeePosition, employeeAirline, employeeHireDate);

        long flightFlightNum = 1234;
        Date airplaneDepartureDateTime = new Date();
        Date airplaneArrivalDateTime = new Date();
        Date airplaneBoardingTime = new Date();
        String airplaneFlightStatus = "testFlightStatus";
        int airplaneDuration = 123;
        Employee airplanePilot = new Employee();
        Employee airplaneCopilot = new Employee();
        flight = new Flight(flightFlightNum, airplane, airplaneDepartureDateTime, departureAirport, airplaneArrivalDateTime, arrivalAirport, airplaneBoardingTime, airplaneFlightStatus, airplaneDuration, airplanePilot, airplaneCopilot);

        int ticketTicketId = 1234;
        long ticketPersonId = 9999999;
        Date ticketDateTimeOfBooking = new Date();
        int ticketTotalPrice = 300;
        int ticketSeatNum = 15;
        String ticketSeatingClass = "testSeatingClass";
        String ticketTicketStatus = "testTicketStatus";
        int ticketWeightOfLuggage = 20;
        ticket = new Ticket(ticketTicketId, ticketPersonId, flight, ticketDateTimeOfBooking, ticketTotalPrice, ticketSeatNum, ticketSeatingClass, ticketTicketStatus, ticketWeightOfLuggage);

    }

    @Test
    public void testUpdateMAirline() {
        String updatedName = "UpdatedAirline";
        String updatedHeadquarters = "UpdatedHeadquarters";
        String updatedEmail = "updatedEmail@gmail.com";
        String updatedPhoneNumber = "+4915198765432";
        String updatedAddress = "updatedAddress";

        // Update values
        airline.setName(updatedName);
        airline.setHeadQuarters(updatedHeadquarters);
        airline.setAddress(updatedAddress);
        airline.setMail(updatedEmail);
        airline.setPhoneNumber(updatedPhoneNumber);

        // Assertions
        assertEquals(airline.getName(), updatedName);
        assertEquals(airline.getHeadQuarters(), updatedHeadquarters);
        assertEquals(airline.getAddress(), updatedAddress);
        assertEquals(airline.getPhoneNumber(), updatedPhoneNumber);
        assertEquals(airline.getMail(), updatedEmail);
    }

    @Test
    public void testUpdateMAirplane() {
        boolean updatedIsOperable = false;
        Airline updatedAirline = new Airline(null, null, null, null ,"+4915112345678","updatedairline@gmail.com");

        airplane.setBelongingAirline(updatedAirline);
        airplane.setOperatable(updatedIsOperable);

        assertEquals(airplane.getBelongingAirline(), updatedAirline);
        assertEquals(airplane.isOperatable(), updatedIsOperable);
    }

    @Test
    public void testUpdateAirport(){
        String updatedName = "UpdatedAirport";
        String updatedCountry = "UpdatedCountry";
        String updatedCity = "UpdatedCity";
        String updatedTimezone = "UpdatedTimezone";

        departureAirport.setCity(updatedCity);
        departureAirport.setCountry(updatedCountry);
        departureAirport.setTimezone(updatedTimezone);
        departureAirport.setName(updatedName);

        assertEquals(departureAirport.getCity(), updatedCity);
        assertEquals(departureAirport.getCountry(), updatedCountry);
        assertEquals(departureAirport.getTimezone(), updatedTimezone);
        assertEquals(departureAirport.getName(), updatedName);
    }

    @Test
    public void testUpdateClient(){
        boolean updatedIsBusinessClient = false;

        client.setBusinessClient(updatedIsBusinessClient);

        assertEquals(client.isBusinessClient(), updatedIsBusinessClient);
    }

    @Test
    public void testUpdateEmployee(){
        int updatedSalary = 200;
        String updatedPosition = "UpdatedPosition";
        Airline updatedAirline = new Airline(null, null, null, null ,"+4915112345678","updatedariline@gmail.com");
        Date updatedHireDate= new Date();

        employee.setHireDate(updatedHireDate);
        employee.setSalary(updatedSalary);
        employee.setPosition(updatedPosition);
        employee.setAirline(updatedAirline);

        assertEquals(employee.getHireDate(), updatedHireDate);
        assertEquals(employee.getSalary(), updatedSalary);
        assertEquals(employee.getPosition(), updatedPosition);
        assertEquals(employee.getAirline(), updatedAirline);
    }

    @Test
    public void testUpdateFlight(){
        Airplane updatedAirplane = new Airplane();
        Date updatedDepartureDateTime = new Date();
        Airport updatedDepartureAirport = new Airport();
        Date updatedArrivalDateTime = new Date();
        Airport updatedArrivalAirport = new Airport();
        Date updatedBoardingTime = new Date();
        String updatedFlightStatus = "udpatedFlightStatus";
        int updatedDuration = 123;
        Employee updatedPilot = new Employee();
        Employee updatedCoPilot = new Employee();
        flight.setAirplane(updatedAirplane);
        flight.setDepartureDateTime(updatedDepartureDateTime);
        flight.setArrivalDateTime(updatedArrivalDateTime);
        flight.setBoardingTime(updatedBoardingTime);
        flight.setStatus(updatedFlightStatus);
        flight.setPilot(updatedPilot);
        flight.setArrivalAirport(updatedArrivalAirport);
        flight.setCopilot(updatedCoPilot);
        flight.setDepartureAirport(updatedDepartureAirport);
        flight.setDuration(updatedDuration);

        assertEquals(flight.getAirplane(), updatedAirplane);
        assertEquals(flight.getDepartureDateTime(), updatedDepartureDateTime);
        assertEquals(flight.getArrivalDateTime(), updatedArrivalDateTime);
        assertEquals(flight.getBoardingTime(), updatedBoardingTime);
        assertEquals(flight.getStatus(), updatedFlightStatus);
        assertEquals(flight.getPilot(), updatedPilot);
        assertEquals(flight.getCopilot(), updatedCoPilot);
        assertEquals(flight.getDepartureAirport(), updatedDepartureAirport);
        assertEquals(flight.getDuration(), updatedDuration);
        assertEquals(flight.getArrivalAirport(), updatedArrivalAirport);
    }

    @Test
    public void testUpdateTicket(){
        String updatedTicketStatus = "updatedTicketStatus";
        Flight updatedFlight = new Flight(0,null,null,null,null,null, null,null,0,null,null);
        long updatedPersonId = 88888888;
        int updatedSeatNum = 100;
        int updatedPrice = 1000;

        ticket.setTicketStatus(updatedTicketStatus);
        ticket.setPersonId(updatedPersonId);
        ticket.setFlightNum(updatedFlight);
        ticket.setTotalPrice(updatedPrice);
        ticket.setSeatNum(updatedSeatNum);

        assertEquals(ticket.getTicketStatus(), updatedTicketStatus);
        assertEquals(ticket.getPersonId(), updatedPersonId);
        assertEquals(ticket.getFlight(), updatedFlight);
        assertEquals(ticket.getTotalPrice(), updatedPrice);
        assertEquals(ticket.getSeatNum(), updatedSeatNum);
    }
}
