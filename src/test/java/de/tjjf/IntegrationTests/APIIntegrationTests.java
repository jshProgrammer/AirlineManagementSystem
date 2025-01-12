package de.tjjf.IntegrationTests;

import static org.junit.jupiter.api.Assertions.*;

import de.tjjf.Domain.models.MPayment;
import de.tjjf.Infrastructure.Client.ClientOperations.APIOperations.*;
import de.tjjf.Infrastructure.Client.GraphQLClient;
import de.tjjf.Infrastructure.api.InputModels.*;
import de.tjjf.Infrastructure.api.MapperInput.EmployeeMapperInput;
import de.tjjf.Infrastructure.api.models.*;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Create.AirportCreateImpl;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Delete.*;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Read.AirportReadImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

public class APIIntegrationTests {

    private GraphQLClient graphQLClient;
    private Calendar calendar;
    private Date date;
    private Date dateTime;

    @BeforeEach
    public void setUp() {

        graphQLClient = new GraphQLClient();
        calendar = Calendar.getInstance();
        calendar.set(2005, Calendar.FEBRUARY, 2);
        date = calendar.getTime();

        calendar = Calendar.getInstance();
        calendar.set(2005, Calendar.FEBRUARY, 2, 12, 0, 0);
        dateTime = calendar.getTime();
    }

    @Test
    void createAndReadClientInDBViaAPITest() throws Exception {
        APIClientInput input = new APIClientInput("Jan", "M", "Kowalski", date.toString(), "0234214234", new APIAddressInput("Test", 1, 91237, "Berlin", "Germany"), "test@test.de", true);

        APIClient apiClient = new ClientAPIOperation().createClient(input);

        APIClient clientReadFromDB = new ClientAPIOperation().readClientById(apiClient.getClientId());
        assertEquals("Jan", clientReadFromDB.getFirstName());
        assertEquals("M", clientReadFromDB.getMiddleNames());
        assertEquals("Kowalski", clientReadFromDB.getLastName());
        //TODO: extract DateParser from one Mapper class so that it can be used here
        //assertEquals(clientReadFromDB.getDateOfBirth(), date.toString());
        assertEquals( "0234214234", clientReadFromDB.getPhoneNumber());
        assertEquals( "Test", clientReadFromDB.getAddress().getStreet());
        assertEquals(1, clientReadFromDB.getAddress().getNumber());
        assertEquals(91237, clientReadFromDB.getAddress().getZipCode());
        assertEquals("Berlin", clientReadFromDB.getAddress().getCity());
        assertEquals("Germany", clientReadFromDB.getAddress().getCountry());
        assertEquals("test@test.de", clientReadFromDB.getEmail());
        assertTrue(clientReadFromDB.getIsBusinessClient());

        new ClientDeleteImpl(clientReadFromDB.getClientId()).execute();

    }

    @Test
    void updateClientInDBViaAPITest() throws Exception {
        APIClientInput input = new APIClientInput("Jan", "M", "Kowalski", date.toString(), "0234214234", new APIAddressInput("Test", 1, 91237, "Berlin", "Germany"), "test@test.de", true);

        APIClient apiClient = new ClientAPIOperation().createClient(input);
        new ClientAPIOperation().updateClient(apiClient.getClientId(), new APIClientInput("Test", "Test", "Test", date.toString(), "0234214233", new APIAddressInput("Street", 2, 91236, "Frankfurt", "Germany"),"test@airline.de", true));

        APIClient clientReadFromDB = new ClientAPIOperation().readClientById(apiClient.getClientId());


        assertEquals("Test", clientReadFromDB.getFirstName());
        assertEquals("Test", clientReadFromDB.getMiddleNames());
        assertEquals("Test", clientReadFromDB.getLastName());
        //TODO: extract DateParser from one Mapper class so that it can be used here
        //assertEquals(clientReadFromDB.getDateOfBirth(), date.toString());

        //assertEquals( "0234214233", clientReadFromDB.getPhoneNumber());
        assertEquals( "Street", clientReadFromDB.getAddress().getStreet());
        assertEquals(2, clientReadFromDB.getAddress().getNumber());
        assertEquals(91236, clientReadFromDB.getAddress().getZipCode());
        assertEquals("Frankfurt", clientReadFromDB.getAddress().getCity());
        assertEquals("Germany", clientReadFromDB.getAddress().getCountry());
        assertEquals("test@airline.de", clientReadFromDB.getEmail());
        assertTrue(clientReadFromDB.getIsBusinessClient());

        new ClientDeleteImpl(clientReadFromDB.getClientId()).execute();
    }

    @Test
    void createAndReadAirlineInDBViaAPITest() throws Exception {
        APIAirlineInput apiAirlineInput = new APIAirlineInput("Test" + System.currentTimeMillis(), date, new APIAddressInput("Test", 1, 91237, "Berlin", "Germany"), "02341324", "test@airline.de");
        new AirlineAPIOperation().createAirline(apiAirlineInput);

        APIAirline airlineReadFromDB = new AirlineAPIOperation().readAirlineByName(apiAirlineInput.getName());

        assertEquals(apiAirlineInput.getName(), airlineReadFromDB.getName());
        //assertEquals(apiAirlineInput.getDate, airlineReadFromDB.getDate());
        assertEquals(apiAirlineInput.getAddress().getCity(), airlineReadFromDB.getAddress().getCity());
        assertEquals(apiAirlineInput.getAddress().getCountry(), airlineReadFromDB.getAddress().getCountry());
        assertEquals(apiAirlineInput.getAddress().getStreet(), airlineReadFromDB.getAddress().getStreet());
        assertEquals(apiAirlineInput.getAddress().getNumber(), airlineReadFromDB.getAddress().getNumber());
        assertEquals(apiAirlineInput.getAddress().getZipCode(), airlineReadFromDB.getAddress().getZipCode());
        assertEquals(apiAirlineInput.getPhoneNumber(), airlineReadFromDB.getPhoneNumber());
        assertEquals(apiAirlineInput.getEmail(), airlineReadFromDB.getEmail());

        new AirlineDeleteImpl(apiAirlineInput.getName()).execute();
    }

    @Test
    void updateAirlineInDBViaAPITest() throws Exception {
        APIAirlineInput apiAirlineInput = new APIAirlineInput("Test" + System.currentTimeMillis(), date, new APIAddressInput("Test", 1, 91237, "Berlin", "Germany"), "02341324", "test@airline.de");
        new AirlineAPIOperation().createAirline(apiAirlineInput);

        new AirlineAPIOperation().updateAirline(new APIAirlineInput(apiAirlineInput.getName(), date.toString(), new APIAddressInput("Street", 2, 91236, "Frankfurt", "Germany"), "0234214233", "airline@airline.de"));

        APIAirline airlineReadFromDB = new AirlineAPIOperation().readAirlineByName(apiAirlineInput.getName());

        assertEquals(apiAirlineInput.getName(), airlineReadFromDB.getName());
        //assertEquals(apiAirlineInput.getDate, airlineReadFromDB.getDate());
        assertEquals("Frankfurt", airlineReadFromDB.getAddress().getCity());
        assertEquals("Germany", airlineReadFromDB.getAddress().getCountry());
        assertEquals("Street", airlineReadFromDB.getAddress().getStreet());
        assertEquals(2, airlineReadFromDB.getAddress().getNumber());
        assertEquals(91236, airlineReadFromDB.getAddress().getZipCode());
        assertEquals("0234214233", airlineReadFromDB.getPhoneNumber());
        assertEquals("airline@airline.de", airlineReadFromDB.getEmail());

        new AirlineDeleteImpl(apiAirlineInput.getName()).execute();
    }

    @Test
    void createAndReadEmployeeInDBViaAPITest() throws Exception {
        APIAirlineInput apiAirlineInput = new APIAirlineInput("Test" + + System.currentTimeMillis(), date, new APIAddressInput("Test", 1, 91237, "Berlin", "Germany"), "02341324", "test@airline.de");
        new AirlineAPIOperation().createAirline(apiAirlineInput);

        APIEmployeeInput apiEmployeeInput = new APIEmployeeInput("Jan", "M", "Kowalski", date.toString() , "+4915112345678", new APIAddressInput("Test", 1, 91237, "Berlin", "Germany"), "test@test.de", apiAirlineInput.getName());
        APIEmployee apiEmployee = new EmployeeAPIOperation().createEmployee(apiEmployeeInput);
        APIEmployee employeeReadFromDB = new EmployeeAPIOperation().readEmployeeById(apiEmployee.getEmployeeId());

        assertEquals(apiEmployeeInput.getFirstName(), employeeReadFromDB.getFirstName());
        assertEquals(apiEmployeeInput.getMiddleNames(), employeeReadFromDB.getMiddleNames());
        assertEquals(apiEmployeeInput.getLastName(), employeeReadFromDB.getLastName());
        //assertEquals(apiEmployeeInput.getDateOfBirth(), employeeReadFromDB.getDateOfBirth());
        assertEquals(apiEmployeeInput.getPhoneNumber(), employeeReadFromDB.getPhoneNumber());
        assertEquals(apiEmployeeInput.getAddress().getCity(), employeeReadFromDB.getAddress().getCity());
        assertEquals(apiEmployeeInput.getAddress().getCountry(), employeeReadFromDB.getAddress().getCountry());
        assertEquals(apiEmployeeInput.getAddress().getStreet(), employeeReadFromDB.getAddress().getStreet());
        assertEquals(apiEmployeeInput.getAddress().getZipCode(), employeeReadFromDB.getAddress().getZipCode());
        assertEquals(apiEmployeeInput.getAddress().getNumber(), employeeReadFromDB.getAddress().getNumber());
        assertEquals(apiEmployeeInput.getEmail(), employeeReadFromDB.getEmail());
        assertEquals(apiEmployeeInput.getAirlineName(), employeeReadFromDB.getAirlineName());

        new EmployeeDeleteImpl(employeeReadFromDB.getEmployeeId()).execute();
        new AirlineDeleteImpl(apiAirlineInput.getName()).execute();
    }

    @Test
    void updateEmployeeInDBViaAPITest() throws Exception {

        APIAirlineInput apiAirlineInput = new APIAirlineInput("Test" + System.currentTimeMillis(), date, new APIAddressInput("Test", 1, 91237, "Berlin", "Germany"), "02341324", "test@airline.de");
        new AirlineAPIOperation().createAirline(apiAirlineInput);

        APIEmployeeInput apiEmployeeInput = new APIEmployeeInput("Jan", "M", "Kowalski", date.toString() , "+4915112345678", new APIAddressInput("Test", 1, 91237, "Berlin", "Germany"), "test@test.de", apiAirlineInput.getName());
        APIEmployee apiEmployee = new EmployeeAPIOperation().createEmployee(apiEmployeeInput);

        APIAirlineInput apiAirlineInputUpdated = new APIAirlineInput("Test" + + System.currentTimeMillis(), date, new APIAddressInput("Test", 1, 91237, "Berlin", "Germany"), "02341324", "test@airline.de");
        new AirlineAPIOperation().createAirline(apiAirlineInputUpdated);

        new EmployeeAPIOperation().updateEmployee(apiEmployee.getEmployeeId(), new APIEmployeeInput("Test", "Test", "Test", date.toString() , "+4915112345678", new APIAddressInput("Street", 2, 912376, "Frankfurt", "Germany"), "airline@test.de", apiAirlineInput.getName()));

        APIEmployee employeeReadFromDB = new EmployeeAPIOperation().readEmployeeById(apiEmployee.getEmployeeId());

        assertEquals("Test", employeeReadFromDB.getFirstName());
        assertEquals("Test", employeeReadFromDB.getMiddleNames());
        assertEquals("Test", employeeReadFromDB.getLastName());
        //assertEquals(apiEmployeeInput.getDateOfBirth(), employeeReadFromDB.getDateOfBirth());
        assertEquals("+4915112345678", employeeReadFromDB.getPhoneNumber());
        assertEquals("Frankfurt", employeeReadFromDB.getAddress().getCity());
        assertEquals("Germany", employeeReadFromDB.getAddress().getCountry());
        assertEquals("Street", employeeReadFromDB.getAddress().getStreet());
        assertEquals(912376, employeeReadFromDB.getAddress().getZipCode());
        assertEquals(2, employeeReadFromDB.getAddress().getNumber());
        assertEquals("airline@test.de", employeeReadFromDB.getEmail());
        //TODO: noch testen, ob man auch diese constraint abändern kann
        //assertEquals(apiAirlineInputUpdated.getName(), employeeReadFromDB.getAirlineName());

        new EmployeeDeleteImpl(employeeReadFromDB.getEmployeeId()).execute();
        new AirlineDeleteImpl(apiAirlineInput.getName()).execute();
        new AirlineDeleteImpl(apiAirlineInputUpdated.getName()).execute();
    }

    @Test
    void createAndReadAirplaneInDBViaAPITest() throws Exception {

        APIAirlineInput apiAirlineInput = new APIAirlineInput("Test" + System.currentTimeMillis(), date, new APIAddressInput("Test", 1, 91237, "Berlin", "Germany"), "02341324", "test@airline.de");
        new AirlineAPIOperation().createAirline(apiAirlineInput);

        APIAirplaneInput apiAirplaneInput = new APIAirplaneInput((int)System.currentTimeMillis(), apiAirlineInput.getName(), true);
        new AirplaneAPIOperation().createAirplane(apiAirplaneInput);


        APIAirplane airplaneReadFromDB = new AirplaneAPIOperation().readAirplaneBySerialNum(apiAirplaneInput.getSerialNum());

        assertEquals(apiAirplaneInput.getSerialNum(), airplaneReadFromDB.getSerialNum());
        assertEquals(apiAirplaneInput.getBelongingAirlineName(), airplaneReadFromDB.getBelongingAirlineName());
        assertEquals(apiAirplaneInput.getIsOperable(), airplaneReadFromDB.getIsOperable());

        new AirplaneDeleteImpl(apiAirplaneInput.getSerialNum()).execute();
        new AirlineDeleteImpl(apiAirlineInput.getName()).execute();
    }

    @Test
    void setOperableAirplaneInDBViaAPITest() throws Exception {
        APIAirlineInput apiAirlineInput = new APIAirlineInput("Test" + System.currentTimeMillis(), date, new APIAddressInput("Test", 1, 91237, "Berlin", "Germany"), "02341324", "test@airline.de");
        new AirlineAPIOperation().createAirline(apiAirlineInput);

        APIAirplaneInput apiAirplaneInput = new APIAirplaneInput((int)System.currentTimeMillis(), apiAirlineInput.getName(), true);
        new AirplaneAPIOperation().createAirplane(apiAirplaneInput);

        new AirplaneAPIOperation().setOperable(apiAirplaneInput.getSerialNum(), false);

        APIAirplane airplaneReadFromDB = new AirplaneAPIOperation().readAirplaneBySerialNum(apiAirplaneInput.getSerialNum());

        assertEquals(apiAirplaneInput.getSerialNum(), airplaneReadFromDB.getSerialNum());
        assertEquals(apiAirplaneInput.getBelongingAirlineName(), airplaneReadFromDB.getBelongingAirlineName());
        assertFalse(airplaneReadFromDB.getIsOperable());

        new AirplaneDeleteImpl(apiAirplaneInput.getSerialNum()).execute();
        new AirlineDeleteImpl(apiAirlineInput.getName()).execute();
    }

    @Test
    void createAndReadAirportInDBViaAPITest() throws Exception {
        APIAirportInput apiAirportInput = new APIAirportInput("Test" + System.currentTimeMillis(), "TestName", "Germany", "Berlin", "German");
        new AirportAPIOperation().createAirport(apiAirportInput);

        APIAirport airportReadFromDB = new AirportAPIOperation().readAirportByCode(apiAirportInput.getCode());

        assertEquals(apiAirportInput.getCode(), airportReadFromDB.getCode());
        assertEquals(apiAirportInput.getCity(), airportReadFromDB.getCity());
        assertEquals(apiAirportInput.getCountry(), airportReadFromDB.getCountry());
        assertEquals(apiAirportInput.getName(), airportReadFromDB.getName());
        assertEquals(apiAirportInput.getTimezone(), airportReadFromDB.getTimezone());

        new AirportDeleteImpl(apiAirportInput.getCode()).execute();
    }


    //TODO: FlightTest fuinktionert noch nicht
    @Test
    void createAndReadFlightInDBViaAPITest() throws Exception {
        APIAirlineInput apiAirlineInput = new APIAirlineInput("Test" + System.currentTimeMillis(), date, new APIAddressInput("Test", 1, 91237, "Berlin", "Germany"), "02341324", "test@airline.de");
        new AirlineAPIOperation().createAirline(apiAirlineInput);
        APIAirplaneInput apiAirplaneInput = new APIAirplaneInput((int)System.currentTimeMillis(), apiAirlineInput.getName(), true);
        new AirplaneAPIOperation().createAirplane(apiAirplaneInput);
        APIAirportInput apiAirportInput = new APIAirportInput("Test" + System.currentTimeMillis(), "TestName", "Germany", "Berlin", "German");
        new AirportAPIOperation().createAirport(apiAirportInput);

        APIEmployeeInput apiEmployeeInput = new APIEmployeeInput("Jan", "M", "Kowalski", date.toString() , "+4915112345678", new APIAddressInput("Test", 1, 91237, "Berlin", "Germany"), "test@test.de", apiAirlineInput.getName());
        APIEmployee apiEmployee = new EmployeeAPIOperation().createEmployee(apiEmployeeInput);


        //TODO
        APIFlightInput apiFlightInput = new APIFlightInput(apiAirplaneInput.getSerialNum(), dateTime.toString(), apiAirportInput.getCode(), dateTime.toString(), apiAirportInput.getCode(), dateTime.toString(), APIFlightInput.FlightStatus.scheduled, 120, apiEmployee.getEmployeeId(), apiEmployee.getEmployeeId());
        APIFlight apiFlight = new FlightAPIOperation().createFlight(apiFlightInput);

        System.out.println("flightNum" + apiFlight.getFlightNum());

       APIFlight flightReadFromDB = new FlightAPIOperation().readFlightByFlightNum(apiFlight.getFlightNum());

        System.out.println("flightNum" + flightReadFromDB.getFlightNum());

        assertEquals(apiFlightInput.getAirplaneSerialNum(), flightReadFromDB.getAirplaneSerialNum());
        //assertEquals(apiFlightInput.getDepartureDateTime(), flightReadFromDB.getDepartureDateTime());
        assertEquals(apiFlightInput.getDepartureAirportCode(), flightReadFromDB.getDepartureAirportCode());
        //assertEquals(apiFlightInput.getArrivalDateTime(), flightReadFromDB.getArrivalDateTime());
        assertEquals(apiFlightInput.getArrivalAirportCode(), flightReadFromDB.getArrivalAirportCode());
        //assertEquals(apiFlightInput.getBoardingTime(), flightReadFromDB.getBoardingTime());
        assertEquals(apiFlightInput.getStatus().toString(), flightReadFromDB.getStatus().toString());
        assertEquals(apiFlightInput.getDuration(), flightReadFromDB.getDuration());
        assertEquals(apiFlightInput.getPilotId(), flightReadFromDB.getPilotId());
        assertEquals(apiFlightInput.getCopilotId(), flightReadFromDB.getCopilotId());

        new FlightDeleteImpl(flightReadFromDB.getFlightNum()).execute();

        //TODO: Fragen: warum können wir das jetzt nicht löschen
        new AirplaneDeleteImpl(apiAirplaneInput.getSerialNum()).execute();
        new EmployeeDeleteImpl(apiEmployee.getEmployeeId()).execute();
        new AirlineDeleteImpl(apiAirlineInput.getName()).execute();
        new AirportDeleteImpl(apiAirportInput.getCode()).execute();
    }

    //TODO: FlightTest update

    //TODO: TicketTest

    @Test
    void createAndReadTicketInDBViaAPITest() throws Exception {

        APIAirlineInput apiAirlineInput = new APIAirlineInput("Test" + System.currentTimeMillis(), date, new APIAddressInput("Test", 1, 91237, "Berlin", "Germany"), "02341324", "test@airline.de");
        new AirlineAPIOperation().createAirline(apiAirlineInput);
        APIAirplaneInput apiAirplaneInput = new APIAirplaneInput((int)System.currentTimeMillis(), apiAirlineInput.getName(), true);
        new AirplaneAPIOperation().createAirplane(apiAirplaneInput);
        APIAirportInput apiAirportInput = new APIAirportInput("Test" + System.currentTimeMillis(), "TestName", "Germany", "Berlin", "German");
        new AirportAPIOperation().createAirport(apiAirportInput);

        APIClientInput apiClientInput = new APIClientInput("Jan", "M", "Kowalski", date.toString() , "+4915112345678", new APIAddressInput("Test", 1, 91237, "Berlin", "Germany"), "test@test.de", false);
        APIClient apiClient = new ClientAPIOperation().createClient(apiClientInput);

        APIEmployeeInput apiEmployeeInput = new APIEmployeeInput("Jan", "M", "Kowalski", date.toString() , "+4915112345678", new APIAddressInput("Test", 1, 91237, "Berlin", "Germany"), "test@test.de", apiAirlineInput.getName());
        APIEmployee apiEmployee = new EmployeeAPIOperation().createEmployee(apiEmployeeInput);


        APIFlightInput apiFlightInput = new APIFlightInput(apiAirplaneInput.getSerialNum(), dateTime.toString(), apiAirportInput.getCode(), dateTime.toString(), apiAirportInput.getCode(), dateTime.toString(), APIFlightInput.FlightStatus.scheduled, 120, apiEmployee.getEmployeeId(), apiEmployee.getEmployeeId());
        APIFlight apiFlight = new FlightAPIOperation().createFlight(apiFlightInput);


        APITicketInput apiTicketInput = new APITicketInput(apiClient.getClientId(), true, apiFlight.getFlightNum(), dateTime.toString(), 300, 23, APITicketInput.SeatingClass.Economy,  APITicketInput.TicketStatus.paid, 23);
        APIPaymentInput mp = new APIPaymentInput("4242424242424242", "12", "34", "567");
        APITicket apiTicket = new TicketAPIOperation().addBooking(apiTicketInput, mp);

        //TODO: Unexpected error occured
        /*APITicket ticketReadFromDB = new TicketAPIOperation().readTicketById(apiTicket.getTicketId());

        assertEquals(ticketReadFromDB.getFlightNum(), apiFlight.getFlightNum());*/
    }


}