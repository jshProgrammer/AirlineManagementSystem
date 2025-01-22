package de.tjjf.CRUDTests.BusinessLevel;

import de.tjjf.Domain.models.*;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class CreateDomainModelsTest {

    @Test
    public void testCreatingMAdress(){
        String street = "TestStreet";
        int number = 123;
        int zipcode = 97265;
        String city = "TestCity";
        String country = "TestCountry";
        DomainAddress mAdress = new DomainAddress(street, number, zipcode, city, country);

        assertEquals(mAdress.getStreet(), street);
        assertEquals(mAdress.getNumber(), number);
        assertEquals(mAdress.getZipcode(), zipcode);
        assertEquals(mAdress.getCity(), city);
        assertEquals(mAdress.getCountry(), country);
    }


    @Test
    public void testCreatingMAirline(){
        String name = "TestAirline";
        Date date = new Date();
        String headQuarters = "TestHeadquarters";
        DomainAddress address = new DomainAddress(null,0,0, null, null);
        String phoneNumber = "+4915112345678";
        String email = "testmail@gmail.com";

        DomainAirline mAirline = new DomainAirline(name , date, headQuarters, address, phoneNumber, email);

        assertEquals(mAirline.getName(), name);
        assertEquals(mAirline.getHeadQuarters(), headQuarters);
        assertEquals(mAirline.getFoundationYear(), date);
        assertEquals(mAirline.getAddress(), address);
        assertEquals(mAirline.getPhoneNumber(), phoneNumber);
        assertEquals(mAirline.getEmail(), email);
    }


    @Test
    public void testCreatingMAirplane(){
        int serialNum = 1234;
        String manufacturer = "TestManufacturer";
        String model = "TestModel";
        int amountOfEconomySeats = 50;
        int amountOfBusinessSeats = 25;
        int amountOfFirstClassSeats = 15;
        DomainAirline mAirline = new DomainAirline(null, null, null, null, "+4915112345678", "airline@gmail.com");
        boolean isOperable = true;
        int maxWeightOfLuggage = 40000;

        DomainAirplane mAirplane = new DomainAirplane(serialNum, manufacturer, model, amountOfEconomySeats, amountOfBusinessSeats, amountOfFirstClassSeats,  mAirline, isOperable, maxWeightOfLuggage);

        assertEquals(mAirplane.getSerialNum(), serialNum);
        assertEquals(mAirplane.getManufacturer(), manufacturer);
        assertEquals(mAirplane.getModel(), model);
        assertEquals(mAirplane.getAmountOfEconomySeats(), amountOfEconomySeats);
        assertEquals(mAirplane.getAmountOfBusinessSeats(), amountOfBusinessSeats);
        assertEquals(mAirplane.getAmountOfFirstClassSeats(), amountOfFirstClassSeats);
        assertEquals(mAirplane.getBelongingAirline(), mAirline);
        if(isOperable){
            assertTrue(mAirplane.isOperable());
        }else{
            assertFalse(mAirplane.isOperable());
        }
        assertEquals(mAirplane.getMaxWeightOfLuggage(), maxWeightOfLuggage);
    }


    @Test
    public void testCreatingMAirport(){
        String code = "TestCode";
        String name = "TestName";
        String country = "TestCountry";
        String city = "TestCity";
        String timezone = "TestTimezone";

        DomainAirport mAirport = new DomainAirport(code, name, country, city, timezone);

        assertEquals(mAirport.getCode(), code);
        assertEquals(mAirport.getName(), name);
        assertEquals(mAirport.getCountry(), country);
        assertEquals(mAirport.getCity(), city);
        assertEquals(mAirport.getTimezone(), timezone);
    }


    @Test
    public void testCreatingClient(){
        long personId = 987654321;
        String firstName = "TestFirstName";
        String lastName = "TestLastName";
        String middleName = "TestMiddleName";
        Date dateofBirth = new Date();
        String phoneNumber = "+4915112345678";
        DomainAddress address = new DomainAddress(null, 0, 0, null, null);
        String email = "testmail@gmail.com";
        Boolean isBusinessClient = true;

        DomainClient mClient = new DomainClient(personId, firstName, middleName, lastName, dateofBirth, phoneNumber, address, email, isBusinessClient);

        assertEquals(mClient.getPersonId(), personId);
        assertEquals(mClient.getFirstName(), firstName);
        assertEquals(mClient.getLastName(), lastName);
        assertEquals(mClient.getMiddleNames(), middleName);
        assertEquals(mClient.getDateOfBirth(), dateofBirth);
        assertEquals(mClient.getPhonenumber(), phoneNumber);
        assertEquals(mClient.getAddress(), address);
        assertEquals(mClient.getEmail(), email);
        if(isBusinessClient){
            assertTrue(mClient.isBusinessClient());
        }else{
            assertFalse(mClient.isBusinessClient());
        }
    }

    @Test
    public void testCreatingEmployee(){
        int salary = 100;
        String position = "TestPosition";
        DomainAirline mAirline = new DomainAirline(null, null, null, null, "+4915112345678", "airline@gmail.com");
        Date hireDate = new Date();
        long personId = 987654321;
        String firstName = "TestFirstName";
        String lastName = "TestLastName";
        String middleName = "TestMiddleName";
        Date dateofBirth = new Date();
        String phoneNumber = "+4915112345678";
        DomainAddress address = new DomainAddress(null, 0, 0, null, null);
        String email = "testmail@gmail.com";

        DomainEmployee mEmployee = new DomainEmployee(personId, firstName, middleName, lastName, dateofBirth, phoneNumber, address, email, salary, position, mAirline, hireDate);

        assertEquals(mEmployee.getPersonId(), personId);
        assertEquals(mEmployee.getFirstName(), firstName);
        assertEquals(mEmployee.getMiddleNames(), middleName);
        assertEquals(mEmployee.getLastName(), lastName);
        assertEquals(mEmployee.getDateOfBirth(), dateofBirth);
        assertEquals(mEmployee.getDateOfBirth(), dateofBirth);
        assertEquals(mEmployee.getPhonenumber(), phoneNumber);
        assertEquals(mEmployee.getAddress(), address);
        assertEquals(mEmployee.getEmail(), email);
        assertEquals(mEmployee.getSalary(), salary);
        assertEquals(mEmployee.getPosition(), position);
        assertEquals(mEmployee.getAirline(), mAirline);
        assertEquals(mEmployee.getHireDate(), hireDate);
    }

    @Test
    public void testCreatingFlight(){
        long flightNum = 1234;
        DomainAirplane mAirplane = new DomainAirplane(0, null, null, 0, 0, 0, null, true, 0);
        Date departureDateTime = new Date();
        DomainAirport departureAirport = new DomainAirport(null, null, null, null, null);
        Date arrivalDateTime = new Date();
        DomainAirport arrivalAirport = new DomainAirport(null, null, null, null, null);
        Date boardingTime = new Date();
        DomainFlight.FlightStatus flyStatus = DomainFlight.FlightStatus.landed;
        int duration = 123;
        DomainEmployee pilot = new DomainEmployee(0, null, null, null, null, "+4915112345678",null, "pilot@gmail.com",  0, null, null, null);
        DomainEmployee copilot = new DomainEmployee(0, null, null, null, null, "+4915112345678",null, "copilot@gmail.com", 0, null, null, null);

        DomainFlight mFlight = new DomainFlight(flightNum, mAirplane, departureDateTime, departureAirport, arrivalDateTime, arrivalAirport, boardingTime, flyStatus, duration, pilot, copilot);

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

    @Test
    public void testCreatingMTicket() {
        int ticketId = 1234;
        DomainPerson person = new DomainPerson(0,  "TestFirstName",  "TestMiddleName", "TestLastName", null, "+4915112345678", null, "person@gmail.com", null);
        DomainAddress mAddress = new DomainAddress("TestStreet",0,0, "Frankfurt", "Germany");
        DomainAirline mAirline = new DomainAirline("TestAirlineName", null, "TestHeadquarters", mAddress, "+4915112345678", "airline@gmail.com");
        DomainAirport mAirport = new DomainAirport("TestCode", "TestName", "TestCountry", "TestCity", "TestTimezone");
        DomainAirplane mAirplane = new DomainAirplane(0, "TestManufacturer", "TestModel", 100, 50, 25, mAirline, true, 10000);
        DomainFlight mFlight = new DomainFlight(0, mAirplane, new Date(), mAirport, new Date(), mAirport, new Date(), DomainFlight.FlightStatus.landed, 0, null,  null);
        Date dateTimeOfBooking = new Date();
        int totalPrice = 300;
        int seatNum = 15;
        DomainTicket.SeatingClass seatingClass = DomainTicket.SeatingClass.Economy;
        DomainTicket.TicketStatus ticketStatus = DomainTicket.TicketStatus.paid;
        int weightOfLuggage = 20;

        DomainTicket mTicket = new DomainTicket(ticketId, person, mFlight, dateTimeOfBooking, totalPrice, seatNum, seatingClass, ticketStatus, weightOfLuggage);

        assertEquals(mTicket.getTicketId(), ticketId);
        assertEquals(mTicket.getPerson(), person);
        assertEquals(mTicket.getFlight(), mFlight);
        assertEquals(mTicket.getDateTimeOfBooking(), dateTimeOfBooking);
        assertEquals(mTicket.getTotalPrice(), (totalPrice + weightOfLuggage * 4)); //see MTicket.setLuggageWeight()
        assertEquals(mTicket.getSeatNum(), seatNum);
        assertEquals(mTicket.getSeatingClass(), seatingClass);
        assertEquals(mTicket.getTicketStatus(), ticketStatus);
        assertEquals(mTicket.getWeightOfLuggage(), weightOfLuggage);
    }


}
