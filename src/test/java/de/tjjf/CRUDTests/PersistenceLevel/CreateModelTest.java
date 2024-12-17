package de.tjjf.CRUDTests.PersistenceLevel;

import de.tjjf.Domain.models.*;
import de.tjjf.Infrastructure.persistence.entities.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CreateModelTest {

    @Test
    public void testCreatingAirline(){
        String name = "TestAirline";
        Date date = new Date();
        String headQuarters = "TestHeadquarters";
        String phoneNumber = "+4915112345678";
        String email = "testmail@gmail.com";
        String address = "testAddress";

        Airline airline = new Airline(name , date, headQuarters, email, phoneNumber, address);

        assertEquals(airline.getName(), name);
        assertEquals(airline.getHeadQuarters(), headQuarters);
        assertEquals(airline.getFoundationYear(), date);
        assertEquals(airline.getAddress(), address);
        assertEquals(airline.getPhoneNumber(), phoneNumber);
        assertEquals(airline.getMail(), email);
    }

    @Test
    public void testCreatingAirplane(){
        int serialNum = 1234;
        String manufacturer = "TestManufacturer";
        String model = "TestModel";
        int amountOfEconomySeats = 50;
        int amountOfBusinessSeats = 25;
        int amountOfFirstClassSeats = 15;
        Airline airline = new Airline(null, null, null, null, "+4915112345678", "airline@gmail.com");
        boolean isOperable = true;
        int maxWeightOfLuggage = 40000;

        Airplane airplane = new Airplane(serialNum, manufacturer, model, amountOfEconomySeats, amountOfBusinessSeats, amountOfFirstClassSeats,  airline, isOperable, maxWeightOfLuggage);

        assertEquals(airplane.getSerialNum(), serialNum);
        assertEquals(airplane.getManufacturer(), manufacturer);
        assertEquals(airplane.getModel(), model);
        assertEquals(airplane.getAmoutOfEconomySeats(), amountOfEconomySeats);
        assertEquals(airplane.getAmoutOfBusinessSeats(), amountOfBusinessSeats);
        assertEquals(airplane.getAmoutOfFirstClassSeats(), amountOfFirstClassSeats);
        assertEquals(airplane.getBelongingAirline(), airline);
        if(isOperable){
            assertTrue(airplane.isOperatable());
        }else{
            assertFalse(airplane.isOperatable());
        }
        assertEquals(airplane.getMaxWeightOfLuggage(), maxWeightOfLuggage);
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
        MAirplane mAirplane = new MAirplane(0, null, null, 0, 0, 0, null, true, 0);
        Date departureDateTime = new Date();
        MAirport departureAirport = new MAirport(null, null, null, null, null);
        Date arrivalDateTime = new Date();
        MAirport arrivalAirport = new MAirport(null, null, null, null, null);
        Date boardingTime = new Date();
        MFlight.FlightStatus flyStatus = MFlight.FlightStatus.landed;
        int duration = 123;
        MEmployee pilot = new MEmployee(0, null, null, null, null, "+4915112345678",null, "pilot@gmail.com", "pilotPassword", 0, null, null, null);
        MEmployee copilot = new MEmployee(0, null, null, null, null, "+4915112345678",null, "copilot@gmail.com", "copilotPassword", 0, null, null, null);

        MFlight mFlight = new MFlight(flightNum, mAirplane, departureDateTime, departureAirport, arrivalDateTime, arrivalAirport, boardingTime, flyStatus, duration, pilot, copilot);

        assertEquals(mFlight.getFlightNum(), flightNum);
        assertEquals(mFlight.getAirplane(), mAirplane);
        assertEquals(mFlight.getDepartureDateTime(), departureDateTime);
        assertEquals(mFlight.getDepartureAirport(), departureAirport);
        assertEquals(mFlight.getArrivalDateTime(), arrivalDateTime);
        assertEquals(mFlight.getArrivalAirport(), arrivalAirport);
        assertEquals(mFlight.getBoardingTime(), boardingTime);
        assertEquals(mFlight.getStatus(), flyStatus);
        assertEquals(mFlight.getDuration(), duration);
        assertEquals(mFlight.getPilot(), pilot);
        assertEquals(mFlight.getCopilot(), copilot);
    }
}
