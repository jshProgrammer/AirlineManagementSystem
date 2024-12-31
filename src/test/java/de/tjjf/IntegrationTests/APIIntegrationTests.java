package de.tjjf.IntegrationTests;

import static org.junit.jupiter.api.Assertions.*;

import de.tjjf.Infrastructure.Client.ClientOperations.APIOperations.AirlineAPIOperation;
import de.tjjf.Infrastructure.Client.ClientOperations.APIOperations.AirplaneAPIOperation;
import de.tjjf.Infrastructure.Client.ClientOperations.APIOperations.ClientAPIOperation;
import de.tjjf.Infrastructure.Client.ClientOperations.APIOperations.EmployeeAPIOperation;
import de.tjjf.Infrastructure.Client.GraphQLClient;
import de.tjjf.Infrastructure.api.InputModels.*;
import de.tjjf.Infrastructure.api.MapperInput.EmployeeMapperInput;
import de.tjjf.Infrastructure.api.models.APIAirline;
import de.tjjf.Infrastructure.api.models.APIAirplane;
import de.tjjf.Infrastructure.api.models.APIClient;
import de.tjjf.Infrastructure.api.models.APIEmployee;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Delete.AirlineDeleteImpl;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Delete.AirplaneDeleteImpl;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Delete.ClientDeleteImpl;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Delete.EmployeeDeleteImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

public class APIIntegrationTests {

    private GraphQLClient graphQLClient;
    private Calendar calendar;
    private Date date;

    @BeforeEach
    public void setUp() {

        graphQLClient = new GraphQLClient();
        calendar = Calendar.getInstance();
        calendar.set(2005, Calendar.FEBRUARY, 2);
        date = calendar.getTime();
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


    //TODO: beide Employee Test methoden werfen noch folgenden Fehler:
    /*
    rror while committing the transaction
	at org.hibernate.internal.ExceptionConverterImpl.convertCommitException(ExceptionConverterImpl.java:67)
	at org.hibernate.engine.transaction.internal.TransactionImpl.commit(TransactionImpl.java:104)
	at de.tjjf.Infrastructure.persistence.DBOperations.AbstractOperations.AbstractDatabaseOperation.execute(AbstractDatabaseOperation.java:21)
	... 34 common frames omitted
Caused by: org.hibernate.exception.ConstraintViolationException: could not execute statement [Eindeutiger Index oder Primärschlüssel verletzt: "PUBLIC.PRIMARY_KEY_E ON PUBLIC.AIRLINE(NAME) VALUES (  36  'Test1876630105' )
     */
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



    //TODO: diese funktioniert bisher als einziges nicht
    @Test
    void createAndReadAirplaneInDBViaAPITest() throws Exception {

        APIAirlineInput apiAirlineInput = new APIAirlineInput("Test" + System.currentTimeMillis(), date, new APIAddressInput("Test", 1, 91237, "Berlin", "Germany"), "02341324", "test@airline.de");
        new AirlineAPIOperation().createAirline(apiAirlineInput);

        APIAirplaneInput apiAirplaneInput = new APIAirplaneInput((int)System.currentTimeMillis(), apiAirlineInput.getName(), true);
        new AirplaneAPIOperation().createAirplane(apiAirplaneInput);


        APIAirplane airplaneReadFromDB = new AirplaneAPIOperation().readAirplaneBySerialNum(apiAirplaneInput.getSerialNum());

        assertEquals(apiAirplaneInput.getSerialNum(), airplaneReadFromDB.getSerialNum());
        assertEquals(apiAirplaneInput.getBelongingAirline(), airplaneReadFromDB.getBelongingAirlineName());

        new AirlineDeleteImpl(apiAirlineInput.getName()).execute();
        new AirplaneDeleteImpl(apiAirplaneInput.getSerialNum()).execute();
    }

    //TODO: hier noch updateAirplane

    //TODO: AirportTest


    //TODO: FlightTest

    //TODO: TicketTest



}