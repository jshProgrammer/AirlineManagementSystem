package de.tjjf.CRUDTests.BusinessLevel;

import de.tjjf.Domain.models.*;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class CreateMModelsTest {

    @Test
    public void testCreatingMAdress(){
        String street = "TestStreet";
        int number = 123;
        int zipcode = 97265;
        String city = "TestCity";
        String country = "TestCountry";
        MAddress mAdress = new MAddress(street, number, zipcode, city, country);

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
        MAddress address = new MAddress(null,0,0, null, null);
        String phoneNumber = "+4915112345678";
        String email = "testmail@gmail.com";

        MAirline mAirline = new MAirline(name , date, headQuarters, address, phoneNumber, email);

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
        MAirline mAirline = new MAirline(null, null, null, null, "+4915112345678", "airline@gmail.com");
        boolean isOperable = true;
        int maxWeightOfLuggage = 40000;

        MAirplane mAirplane = new MAirplane(serialNum, manufacturer, model, amountOfEconomySeats, amountOfBusinessSeats, amountOfFirstClassSeats,  mAirline, isOperable, maxWeightOfLuggage);

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

        MAirport mAirport = new MAirport(code, name, country, city, timezone);

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
        MAddress address = new MAddress(null, 0, 0, null, null);
        String email = "testmail@gmail.com";
        String password = "TestPassword";
        Boolean isBusinessClient = true;

        MClient mClient = new MClient(personId, firstName, middleName, lastName, dateofBirth, phoneNumber, address, email, password, isBusinessClient);

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
        MAirline mAirline = new MAirline(null, null, null, null, "+4915112345678", "airline@gmail.com");
        Date hireDate = new Date();
        long personId = 987654321;
        String firstName = "TestFirstName";
        String lastName = "TestLastName";
        String middleName = "TestMiddleName";
        Date dateofBirth = new Date();
        String phoneNumber = "+4915112345678";
        MAddress address = new MAddress(null, 0, 0, null, null);
        String email = "testmail@gmail.com";
        String password = "TestPassword";

        MEmployee mEmployee = new MEmployee(personId, firstName, middleName, lastName, dateofBirth, phoneNumber, address, email, password, salary, position, mAirline, hireDate);

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

    @Test
    public void testCreatingMTicket() {
        int ticketId = 1234;
        MPerson person = new MPerson(0,  "TestFirstName",  "TestMiddleName", "TestLastName", null, "+4915112345678", null, "person@gmail.com", "personPassword", null);
        MAddress mAddress = new MAddress("TestStreet",0,0, "Frankfurt", "Germany");
        MAirline mAirline = new MAirline("TestAirlineName", null, "TestHeadquarters", mAddress, "+4915112345678", "airline@gmail.com");
        MAirport mAirport = new MAirport("TestCode", "TestName", "TestCountry", "TestCity", "TestTimezone");
        MAirplane mAirplane = new MAirplane(0, "TestManufacturer", "TestModel", 100, 50, 25, mAirline, true, 10000);
        MFlight mFlight = new MFlight(0, mAirplane, new Date(), mAirport, new Date(), mAirport, new Date(), MFlight.FlightStatus.landed, 0, null,  null);
        Date dateTimeOfBooking = new Date();
        int totalPrice = 300;
        int seatNum = 15;
        MTicket.SeatingClass seatingClass = MTicket.SeatingClass.Economy;
        MTicket.TicketStatus ticketStatus = MTicket.TicketStatus.paid;
        int weightOfLuggage = 20;

        MTicket mTicket = new MTicket(ticketId, person, mFlight, dateTimeOfBooking, totalPrice, seatNum, seatingClass, ticketStatus, weightOfLuggage);

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
