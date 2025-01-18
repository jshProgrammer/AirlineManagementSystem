package de.tjjf.CRUDTests.PersistenceLevel;

import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Create.*;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Delete.*;
import de.tjjf.Infrastructure.persistence.EntityManagerFactorySingleton;
import de.tjjf.Infrastructure.persistence.entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class CreateModelTest {

    public String salt;

    @BeforeEach
    public void initialize() {
        salt = UUID.randomUUID().toString();
    }

    @Test
    public void testAirlineCreation() {
        String name = "TestAirline_" + salt;
        Date foundationYear = new Date();
        String headQuarters = "TestHeadquarters";
        String email = "testemail_" + salt + "@gmail.com";
        String phoneNumber = "+4915112345678";
        String address = "TestAddress";

        Airline airline = new Airline(name, foundationYear, headQuarters, email, phoneNumber, address);
        new AirlineCreateImpl(airline).execute();

        assertNotNull(airline);
        assertEquals(headQuarters, airline.getHeadQuarters());

        new AirlineDeleteImpl(name).execute();
    }

    @Test
    public void testAirplaneCreation() {
        String airlineName = "TestAirline_" + salt;
        Date foundationYear = new Date();
        String headQuarters = "TestHeadquarters";
        String email = "testemail_" + salt + "@gmail.com";
        String phoneNumber = "+4915112345678";
        String address = "TestAddress";

        Airline airline = new Airline(airlineName, foundationYear, headQuarters, email, phoneNumber, address);
        new AirlineCreateImpl(airline).execute();

        int serialNum = 9999999 + salt.hashCode();
        String manufacturer = "TestManufacturer";
        String model = "TestModel";
        int economySeats = 50;
        int businessSeats = 25;
        int firstClassSeats = 15;
        boolean isOperatable = true;
        int maxWeightOfLuggage = 40000;

        Airplane airplane = new Airplane(serialNum, manufacturer, model, economySeats, businessSeats, firstClassSeats, airline, isOperatable, maxWeightOfLuggage);
        new AirplaneCreateImpl(airplane).execute();

        assertNotNull(airplane);
        assertEquals(manufacturer, airplane.getManufacturer());

        new AirplaneDeleteImpl(serialNum).execute();
        new AirlineDeleteImpl(airlineName).execute();
    }

    @Test
    public void testAirportCreation() {
        String departureCode = "DPT_" + salt;
        String departureName = "Departure Airport";
        String departureCountry = "CountryA";
        String departureCity = "CityA";
        String departureTimezone = "TimezoneA";

        Airport departureAirport = new Airport(departureCode, departureName, departureCountry, departureCity, departureTimezone);
        new AirportCreateImpl(departureAirport).execute();

        assertNotNull(departureAirport);
        assertEquals(departureCity, departureAirport.getCity());

        new AirportDeleteImpl(departureCode).execute();
    }

    @Test
    public void testClientCreation() {
        String firstName = "TestFirstName";
        String middleName = "TestMiddleNames";
        String lastName = "TestLastName";
        Date dateOfBirth = new Date();
        String phoneNumber = "+4915112345678";
        String address = "TestAddress";
        String email = "testemail_" + salt + "@gmail.com";
        boolean isBusinessClient = true;

        Client client = new Client( firstName, middleName, lastName, dateOfBirth, phoneNumber, address, email, new ArrayList<>(), isBusinessClient);
        Client clientReturned = new ClientCreateImpl(client).execute().model;

        assertNotNull(client);
        assertEquals(firstName, client.getFirstName());

        new ClientDeleteImpl(clientReturned.getPersonId()).execute();
    }

    @Test
    public void testEmployeeCreation() {
        String airlineName = "TestAirline_" + salt;
        Date foundationYear = new Date();
        String headQuarters = "TestHeadquarters";
        String email = "testemail_" + salt + "@gmail.com";
        String phoneNumber = "+4915112345678";
        String address = "TestAddress";

        Airline airline = new Airline(airlineName, foundationYear, headQuarters, email, phoneNumber, address);
        new AirlineCreateImpl(airline).execute();

        String firstName = "EmployeeFirstName";
        String middleName = "EmployeeMiddleName";
        String lastName = "EmployeeLastName";
        Date dateOfBirth = new Date();
        String employeePhoneNumber = "+491512345678";
        String employeeAddress = "EmployeeAddress";
        String employeeEmail = "employee@" + salt + ".com";
        int salary = 5000;
        String position = "Manager";
        Date hireDate = new Date();
        Employee employee = new Employee(firstName, middleName, lastName, dateOfBirth, employeePhoneNumber, employeeAddress, employeeEmail, new ArrayList<>(), salary, position, airline, hireDate);
        Employee createdEmployee = new EmployeeCreateImpl(employee).execute().model;

        assertNotNull(employee);
        assertEquals(position, employee.getPosition());

        new EmployeeDeleteImpl(createdEmployee.getPersonId()).execute();
        new AirlineDeleteImpl(airlineName).execute();
    }

    @Test
    public void testFlightCreation() {
        String airlineName = "TestAirline_" + salt;
        Date foundationYear = new Date();
        String headQuarters = "TestHeadquarters";
        String email = "testemail_" + salt + "@gmail.com";
        String phoneNumber = "+4915112345678";
        String address = "TestAddress";

        Airline airline = new Airline(airlineName, foundationYear, headQuarters, email, phoneNumber, address);
        new AirlineCreateImpl(airline).execute();

        int serialNum = 9999999 + salt.hashCode();
        String manufacturer = "TestManufacturer";
        String model = "TestModel";
        int economySeats = 50;
        int businessSeats = 25;
        int firstClassSeats = 15;
        boolean isOperatable = true;
        int maxWeightOfLuggage = 40000;

        Airplane airplane = new Airplane(serialNum, manufacturer, model, economySeats, businessSeats, firstClassSeats, airline, isOperatable, maxWeightOfLuggage);
        new AirplaneCreateImpl(airplane).execute();

        String departureCode = "DPT_" + salt;
        String departureName = "Departure Airport";
        String departureCountry = "CountryA";
        String departureCity = "CityA";
        String departureTimezone = "TimezoneA";

        Airport departureAirport = new Airport(departureCode, departureName, departureCountry, departureCity, departureTimezone);
        new AirportCreateImpl(departureAirport).execute();

        String arrivalCode = "ARR_" + salt;
        String arrivalName = "Arrival Airport";
        String arrivalCountry = "CountryB";
        String arrivalCity = "CityB";
        String arrivalTimezone = "TimezoneB";

        Airport arrivalAirport = new Airport(arrivalCode, arrivalName, arrivalCountry, arrivalCity, arrivalTimezone);
        new AirportCreateImpl(arrivalAirport).execute();

        String pilotFirstName = "PilotFirstName";
        String pilotLastName = "PilotLastName";
        String pilotPosition = "Captain";
        Employee pilot = new Employee(pilotFirstName, "", pilotLastName, new Date(), "+491512345678", "PilotAddress", "pilot@gmail.com", new ArrayList<>(), 100000, pilotPosition, airline, new Date());
        new EmployeeCreateImpl(pilot).execute();

        String status = "Scheduled";
        int duration = 180;

        Flight flight = new Flight( airplane, new Date(), departureAirport, new Date(), arrivalAirport, new Date(), status, duration, pilot, pilot);
        new FlightCreateImpl(flight).execute();

        assertNotNull(flight);
        assertEquals(status, flight.getStatus());

        new FlightDeleteImpl(flight.getFlightNum()).execute();
        new EmployeeDeleteImpl(pilot.getPersonId()).execute();
        new AirplaneDeleteImpl(serialNum).execute();
        new AirportDeleteImpl(departureCode).execute();
        new AirportDeleteImpl(arrivalCode).execute();
        new AirlineDeleteImpl(airlineName).execute();
    }

    @Test
    public void createTicketTest() {
        String airlineName = "TestAirline_" + salt;
        Date foundationYear = new Date();
        String headQuarters = "TestHeadquarters";
        String email = "testemail_" + salt + "@gmail.com";
        String phoneNumber = "+4915112345678";
        String address = "TestAddress";

        Airline airline = new Airline(airlineName, foundationYear, headQuarters, email, phoneNumber, address);
        new AirlineCreateImpl(airline).execute();

        int serialNum = 9999999 + salt.hashCode();
        String manufacturer = "TestManufacturer";
        String model = "TestModel";
        int economySeats = 50;
        int businessSeats = 25;
        int firstClassSeats = 15;
        boolean isOperatable = true;
        int maxWeightOfLuggage = 40000;

        Airplane airplane = new Airplane(serialNum, manufacturer, model, economySeats, businessSeats, firstClassSeats, airline, isOperatable, maxWeightOfLuggage);
        new AirplaneCreateImpl(airplane).execute();

        String departureCode = "DPT_" + salt;
        String departureName = "Departure Airport";
        String departureCountry = "CountryA";
        String departureCity = "CityA";
        String departureTimezone = "TimezoneA";

        Airport departureAirport = new Airport(departureCode, departureName, departureCountry, departureCity, departureTimezone);
        new AirportCreateImpl(departureAirport).execute();

        String arrivalCode = "ARR_" + salt;
        String arrivalName = "Arrival Airport";
        String arrivalCountry = "CountryB";
        String arrivalCity = "CityB";
        String arrivalTimezone = "TimezoneB";

        Airport arrivalAirport = new Airport(arrivalCode, arrivalName, arrivalCountry, arrivalCity, arrivalTimezone);
        new AirportCreateImpl(arrivalAirport).execute();


        String firstName = "EmployeeFirstName";
        String middleName = "EmployeeMiddleName";
        String lastName = "EmployeeLastName";
        Date dateOfBirth = new Date();
        String employeePhoneNumber = "+491512345678";
        String employeeAddress = "EmployeeAddress";
        String employeeEmail = "employee@" + salt + ".com";
        int salary = 5000;
        String position = "Manager";
        Date hireDate = new Date();

        Employee employee = new Employee(firstName, middleName, lastName, dateOfBirth, employeePhoneNumber, employeeAddress, employeeEmail, new ArrayList<>(), salary, position, airline, hireDate);
        Employee createdEmployee = new EmployeeCreateImpl(employee).execute().model;

        String status = "Scheduled";
        int duration = 180;

        Flight flight = new Flight(airplane, new Date(), departureAirport, new Date(), arrivalAirport, new Date(), status, duration, createdEmployee, createdEmployee);
        new FlightCreateImpl(flight).execute();


        firstName = "TestFirstName";
        middleName = "TestMiddleNames";
        lastName = "TestLastName";
        dateOfBirth = new Date();
        String clientPhoneNumber = "+4915112345678";
        String clientAddress = "TestAddress";
        String clientEmail = "testemail_" + salt + "@gmail.com";
        boolean isBusinessClient = true;

        Client client = new Client( firstName, middleName, lastName, dateOfBirth, clientPhoneNumber, clientAddress, clientEmail, new ArrayList<>(), isBusinessClient);
        new ClientCreateImpl(client).execute();
        Date bookingDate = new Date();
        int totalPrice = 200;
        int seatNum = 1;
        String seatingClass = "Economy";
        String ticketStatus = "Confirmed";
        int weightOfLuggage = 20;

        Ticket ticket = new Ticket(flight, bookingDate, totalPrice, seatNum, seatingClass, ticketStatus, weightOfLuggage, client);
        Ticket ticketReturned = new TicketCreateImpl(ticket).execute().model;

        assertNotNull(ticketReturned);
        assertEquals(seatingClass, ticketReturned.getSeatingClass());
        assertEquals(totalPrice, ticketReturned.getTotalPrice());

        new TicketDeleteImpl(ticketReturned.getTicketId()).execute();
        new FlightDeleteImpl(flight.getFlightNum()).execute();
        new AirplaneDeleteImpl(serialNum).execute();
        new AirportDeleteImpl(departureCode).execute();
        new AirportDeleteImpl(arrivalCode).execute();
        new AirlineDeleteImpl(airlineName).execute();
    }

}
