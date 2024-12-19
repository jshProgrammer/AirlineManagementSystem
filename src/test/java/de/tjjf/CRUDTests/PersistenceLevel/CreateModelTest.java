package de.tjjf.CRUDTests.PersistenceLevel;

import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Create.*;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Delete.*;
import de.tjjf.Infrastructure.persistence.entities.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class CreateModelTest {

    public static final String salt = UUID.randomUUID().toString();

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
        long personId = 8888888 + salt.hashCode();
        String firstName = "TestFirstName";
        String middleName = "TestMiddleNames";
        String lastName = "TestLastName";
        Date dateOfBirth = new Date();
        String phoneNumber = "+4915112345678";
        String address = "TestAddress";
        String email = "testemail_" + salt + "@gmail.com";
        String password = "TestPassword";
        boolean isBusinessClient = true;

        Client client = new Client(personId, firstName, middleName, lastName, dateOfBirth, phoneNumber, address, email, password, new ArrayList<>(), isBusinessClient);
        new ClientCreateImpl(client).execute();

        assertNotNull(client);
        assertEquals(firstName, client.getFirstName());

        new ClientDeleteImpl(personId).execute();
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

        long personId = 7777777 + salt.hashCode();
        String firstName = "EmployeeFirstName";
        String middleName = "EmployeeMiddleName";
        String lastName = "EmployeeLastName";
        Date dateOfBirth = new Date();
        String employeePhoneNumber = "+491512345678";
        String employeeAddress = "EmployeeAddress";
        String employeeEmail = "employee@" + salt + ".com";
        String password = "EmployeePassword";
        int salary = 5000;
        String position = "Manager";
        Date hireDate = new Date();

        Employee employee = new Employee(personId, firstName, middleName, lastName, dateOfBirth, employeePhoneNumber, employeeAddress, employeeEmail, password, new ArrayList<>(), salary, position, airline, hireDate);
        new EmployeeCreateImpl(employee).execute();

        assertNotNull(employee);
        assertEquals(position, employee.getPosition());

        new EmployeeDeleteImpl(personId).execute();
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

        long pilotId = 6666668 + salt.hashCode();
        String pilotFirstName = "PilotFirstName";
        String pilotLastName = "PilotLastName";
        String pilotPosition = "Captain";

        Employee pilot = new Employee(pilotId, pilotFirstName, "", pilotLastName, new Date(), "+491512345678", "PilotAddress", "pilot@gmail.com", "password", new ArrayList<>(), 100000, pilotPosition, airline, new Date());
        new EmployeeCreateImpl(pilot).execute();

        long flightNum = 6666666 + salt.hashCode();
        String status = "Scheduled";
        int duration = 180;

        Flight flight = new Flight(flightNum, airplane, new Date(), departureAirport, new Date(), arrivalAirport, new Date(), status, duration, pilot, pilot);
        new FlightCreateImpl(flight).execute();

        assertNotNull(flight);
        assertEquals(status, flight.getStatus());

        new FlightDeleteImpl(flightNum).execute();
        new EmployeeDeleteImpl(pilotId).execute();
        new AirplaneDeleteImpl(serialNum).execute();
        new AirportDeleteImpl(departureCode).execute();
        new AirportDeleteImpl(arrivalCode).execute();
        new AirlineDeleteImpl(airlineName).execute();
    }
}
