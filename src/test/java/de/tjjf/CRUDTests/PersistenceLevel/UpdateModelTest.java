package de.tjjf.CRUDTests.PersistenceLevel;

import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Create.*;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Delete.*;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Read.*;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Update.*;
import de.tjjf.Infrastructure.persistence.entities.*;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class UpdateModelTest {

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
       String salt = UUID.randomUUID().toString();

        airline = new Airline(
                "TestAirline_" + salt,
                new Date(),
                "TestHeadquarters",
                "testemail_" + salt + "@gmail.com",
                "+4915112345678",
                "TestAddress"
        );
        new AirlineCreateImpl(airline).execute();

        airplane = new Airplane(
                9999999 + salt.hashCode(),
                "TestManufacturer",
                "TestModel",
                50,
                25,
                15,
                airline,
                true,
                40000
        );
        new AirplaneCreateImpl(airplane).execute();

        departureAirport = new Airport(
                "DPT_" + salt,
                "Departure Airport",
                "CountryA",
                "CityA",
                "TimezoneA"
        );
        new AirportCreateImpl(departureAirport).execute();

        arrivalAirport = new Airport(
                "ARR_" + salt,
                "Arrival Airport",
                "CountryB",
                "CityB",
                "TimezoneB"
        );
        new AirportCreateImpl(arrivalAirport).execute();

        client = new Client(
                "TestFirstName",
                "TestMiddleNames",
                "TestLastName",
                new Date(),
                "+4915112345678",
                "TestAddress",
                "testemail_" + salt + "@gmail.com",
                "TestPassword",
                new ArrayList<>(),
                true
        );
        new ClientCreateImpl(client).execute();

        employee = new Employee(
                "TestEmployee",
                "TestMiddleNames",
                "TestLastName",
                new Date(),
                "+4915112345678",
                "TestAddress",
                "employee_" + salt + "@gmail.com",
                "password",
                new ArrayList<>(),
                100,
                "TestPosition",
                airline,
                new Date()
        );
        new EmployeeCreateImpl(employee).execute();

        flight = new Flight(
                airplane,
                new Date(),
                departureAirport,
                new Date(),
                arrivalAirport,
                new Date(),
                "testStatus",
                123,
                employee,
                employee
        );
        new FlightCreateImpl(flight).execute();

        ticket = new Ticket(
                client.getPersonId(),
                flight,
                new Date(),
                300,
                15,
                "Economy",
                "Active",
                20
        );
        new TicketCreateImpl(ticket).execute();
    }



    @AfterAll
    public static void teardown() {
        if (ticket != null) {
            new TicketDeleteImpl(ticket.getTicketId()).execute();
        }
        if (flight != null) {
            new FlightDeleteImpl(flight.getFlightNum()).execute();
        }
        if (airplane != null) {
            new AirplaneDeleteImpl(airplane.getSerialNum()).execute();
        }
        if (departureAirport != null) {
            new AirportDeleteImpl(departureAirport.getCode()).execute();
        }
        if (arrivalAirport != null) {
            new AirportDeleteImpl(arrivalAirport.getCode()).execute();
        }
        if (employee != null) {
            new EmployeeDeleteImpl(employee.getPersonId()).execute();
        }
        if (client != null) {
            new ClientDeleteImpl(client.getPersonId()).execute();
        }
        if (airline != null) {
            new AirlineDeleteImpl(airline.getName()).execute();
        }
    }



    @Test
    public void testUpdateAirline() {
        //String updatedName = "UpdatedAirline";
        String updatedHeadquarters = "UpdatedHeadquarters";
        String updatedEmail = "updatedEmail@gmail.com";
        String updatedPhoneNumber = "+4915198765432";
        String updatedAddress = "updatedAddress";

        //airline.setName(updatedName);
        airline.setHeadQuarters(updatedHeadquarters);
        airline.setMail(updatedEmail);
        airline.setPhoneNumber(updatedPhoneNumber);
        airline.setAddress(updatedAddress);

        new AirlineUpdateImpl(airline).execute();


        Airline updatedAirline = new AirlineReadImpl(airline.getName()).execute().model;
        //assertEquals(updatedName, updatedAirline.getName());
        assertEquals(updatedHeadquarters, updatedAirline.getHeadQuarters());
        assertEquals(updatedEmail, updatedAirline.getMail());
        assertEquals(updatedPhoneNumber, updatedAirline.getPhoneNumber());
        assertEquals(updatedAddress, updatedAirline.getAddress());
    }

    @Test
    public void testUpdateAirplane() {
        boolean updatedOperatable = false;

        airplane.setOperable(updatedOperatable);

        new AirplaneUpdateImpl(airplane).execute();
        assertEquals(updatedOperatable, new AirplaneReadImpl(airplane.getSerialNum()).execute().model.isOperable());
    }

    @Test
    public void testUpdateAirport() {
        String updatedName = "UpdatedAirport";
        String updatedCountry = "UpdatedCountry";
        String updatedCity = "UpdatedCity";
        String updatedTimezone = "UpdatedTimezone";

        departureAirport.setName(updatedName);
        departureAirport.setCountry(updatedCountry);
        departureAirport.setCity(updatedCity);
        departureAirport.setTimezone(updatedTimezone);

        new AirportUpdateImpl(departureAirport).execute();
        Airport updatedAirport = new AirportReadImpl(departureAirport.getCode()).execute().model;

        assertEquals(updatedName, updatedAirport.getName());
        assertEquals(updatedCountry, updatedAirport.getCountry());
        assertEquals(updatedCity, updatedAirport.getCity());
        assertEquals(updatedTimezone, updatedAirport.getTimezone());
    }

    @Test
    public void testUpdateClient() {
        boolean updatedIsBusinessClient = false;
        client.setBusinessClient(updatedIsBusinessClient);
        new ClientUpdateImpl(client).execute();
        assertEquals(updatedIsBusinessClient, new ClientReadImpl(client.getPersonId()).execute().model.isBusinessClient());
    }

    @Test
    public void testUpdateEmployee() {
        int updatedSalary = 200;
        String updatedPosition = "UpdatedPosition";

        employee.setSalary(updatedSalary);
        employee.setPosition(updatedPosition);

        new EmployeeUpdateImpl(employee).execute();

        Employee updatedEmployee = new EmployeeReadImpl(employee.getPersonId()).execute().model;

        assertEquals(updatedSalary, updatedEmployee.getSalary());
        assertEquals(updatedPosition, updatedEmployee.getPosition());
    }

    @Test
    public void testUpdateFlight() {
        String updatedStatus = "UpdatedStatus";
        flight.setStatus(updatedStatus);
        new FlightUpdateImpl(flight).execute();
        assertEquals(updatedStatus, new FlightReadImpl(flight.getFlightNum()).execute().model.getStatus());
    }

    @Test
    public void testUpdateTicket() {
        String updatedTicketStatus = "UpdatedTicketStatus";
        ticket.setTicketStatus(updatedTicketStatus);
        new TicketUpdateImpl(ticket).execute();
        assertEquals(updatedTicketStatus, new TicketReadImpl(ticket.getTicketId()).execute().model.getTicketStatus());
    }


}