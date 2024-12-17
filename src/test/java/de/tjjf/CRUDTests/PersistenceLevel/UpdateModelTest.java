package de.tjjf.CRUDTests.PersistenceLevel;

import de.tjjf.Domain.models.*;
import de.tjjf.Infrastructure.persistence.entities.*;
import org.glassfish.jaxb.core.v2.TODO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

    @BeforeEach
    public void beforeEach() {
        //ToDo rename instances
        String mAirlineName = "TestAirline";
        Date mAirlineDate = new Date();
        String mAirlineHeadQuarters = "TestHeadquarters";
        String airlineAddress = "testAirlineAddress";
        String mAirlinePhoneNumber = "+4915112345678";
        String mAirlineEmail = "testemail@gmail.com";
        airline = new Airline(mAirlineName , mAirlineDate, mAirlineHeadQuarters, mAirlineEmail, mAirlinePhoneNumber, airlineAddress);

        int mAirplaneSerialNum = 1234;
        String mAirplaneManufacturer = "TestManufacturer";
        String mAirplaneModel = "TestModel";
        int mAirplaneAmountOfEconomySeats = 50;
        int mAirplaneAmountOfBusinessSeats = 25;
        int mAirplaneAmountOfFirstClassSeats = 15;
        boolean mAirplaneIsOperable = true;
        int mAirplaneMaxWeightOfLuggage = 40000;
        airplane = new Airplane(mAirplaneSerialNum, mAirplaneManufacturer, mAirplaneModel, mAirplaneAmountOfEconomySeats, mAirplaneAmountOfBusinessSeats, mAirplaneAmountOfFirstClassSeats, airline, mAirplaneIsOperable, mAirplaneMaxWeightOfLuggage);

        String departureMAirportCode = "departureTestCode";
        String departureMAirportName = "departureTestName";
        String departureMAirportCountry = "departureTestCountry";
        String departureMAirportCity = "departureTestCity";
        String departureMAirportTimezone = "departureTestTimezone";
        departureAirport = new Airport(departureMAirportCode, departureMAirportName,departureMAirportCountry, departureMAirportCity, departureMAirportTimezone);

        String arrivalMAirportCode = "arrivalTestCode";
        String arrivalMAirportName = "arrivalTestName";
        String arrivalMAirportCountry = "arrivalTestCountry";
        String arrivalMAirportCity = "arrivalTestCity";
        String arrivalMAirportTimezone = "arrivalTestTimezone";
        arrivalAirport = new Airport(arrivalMAirportCode, arrivalMAirportName,arrivalMAirportCountry, arrivalMAirportCity, arrivalMAirportTimezone);

        long mClientPersonId = 9999999;
        String mClientFirstName = "TestClientFirstName";
        String mClientMiddleNames = "TestClientMiddleNames";
        String mClientLastName = "TestClientLastName";
        Date mClientDateOfBirth = new Date();
        String mClientPhoneNumber = "+4915112345678";
        String clientAddress = "testClientAddress";
        String mClientEmail = "testemail@gmail.com";
        String mClientPassword = "testpassword";
        List<Ticket> clientTickets = new ArrayList<Ticket>();
        boolean mClientIsBusinessClient = true;
        client = new Client(mClientPersonId, mClientFirstName, mClientMiddleNames, mClientLastName, mClientDateOfBirth,  mClientPhoneNumber, clientAddress, mClientEmail, mClientPassword,clientTickets, mClientIsBusinessClient);

        long mEmployeePersonId = 9999999;
        String mEmployeeFirstName = "TestEmployeetFirstName";
        String mEmployeeMiddleNames = "TestEmployeeMiddleNames";
        String mEmployeeLastName = "TestEmployeeLastName";
        Date mEmployeeDateOfBirth = new Date();
        String mEmployeePhoneNumber = "+4915112345678";
        String employeeAddress = "testEmployeeAddress";
        String mEmployeeEmail = "testemail@gmail.com";
        String mEmployeePassword = "testpassword";
        int mEmployeeSalary = 100;
        String mEmployeePosition = "TestPosition";
        //ToDo check if different constructor is neccessary
        Airline mEmployeeMAirline = new Airline();
        Date mEmployeeHireDate = new Date();
        List<Ticket> employeeTickets = new ArrayList<>();
        employee = new Employee(mEmployeePersonId, mEmployeeFirstName, mEmployeeMiddleNames, mEmployeeLastName, mEmployeeDateOfBirth,  mEmployeePhoneNumber, employeeAddress, mEmployeeEmail, mEmployeePassword,employeeTickets, mEmployeeSalary, mEmployeePosition,mEmployeeMAirline,mEmployeeHireDate);

        long mFLightFlightNum = 1234;
        Date mAirplaneDepartureDateTime = new Date();
        Date mAirplaneArrivalDateTime = new Date();
        Date mAirplaneBoardingTime = new Date();
        String airplaneFlightStatus = "testFlightStatus";
        int mAirplaneDuration = 123;
        Employee mAirplanePilot = new Employee();
        Employee mAirplaneCopilot = new Employee();
        flight = new Flight(mFLightFlightNum, airplane, mAirplaneDepartureDateTime, departureAirport, mAirplaneArrivalDateTime, arrivalAirport, mAirplaneBoardingTime, airplaneFlightStatus, mAirplaneDuration, mAirplanePilot, mAirplaneCopilot);

        int mTicketTicketId = 1234;
        long ticketPersonId = 9999999;
        Date mTicketDateTimeOfBooking = new Date();
        int mTicketTotalPrice = 300;
        int mTicketSeatNum = 15;
        String ticketSeatingClass = "testSeatingClass";
        String ticketTicketStatus = "testTicketStatus";
        int mTicketWeightOfLuggage = 20;
        ticket = new Ticket(mTicketTicketId, ticketPersonId, flight, mTicketDateTimeOfBooking, mTicketTotalPrice, mTicketSeatNum, ticketSeatingClass, ticketTicketStatus, mTicketWeightOfLuggage);
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
