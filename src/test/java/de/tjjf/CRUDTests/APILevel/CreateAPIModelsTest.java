package de.tjjf.CRUDTests.APILevel;

import de.tjjf.Infrastructure.api.models.*;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class CreateAPIModelsTest {

    @Test
    public void testCreatingAPIAdress(){
        String street = "TestStreet";
        int number = 123;
        int zipcode = 97265;
        String city = "TestCity";
        String country = "TestCountry";
        APIAddress apiAdress = new APIAddress(street, number, zipcode, city, country);

        assertEquals(street, apiAdress.getStreet());
        assertEquals(number, apiAdress.getNumber());
        assertEquals(zipcode, apiAdress.getZipCode());
        assertEquals(city, apiAdress.getCity());
        assertEquals(country, apiAdress.getCountry());

    }


    @Test
    public void testCreatingAPIAirline(){
        String name = "TestAirline";
        Date date = new Date();
        APIAddress address = new APIAddress(null,0,0, null, null);
        String phoneNumber = "+4915112345678";
        String email = "testmail@gmail.com";

        APIAirline apiAirline = new APIAirline(name , date.toString() ,address, phoneNumber, email);

        assertEquals(name, apiAirline.getName());
        //assertEquals(date, apiAirline.getFoundationYear());
        assertEquals(address, apiAirline.getAddress());
        assertEquals(phoneNumber, apiAirline.getPhoneNumber());
        assertEquals(email, apiAirline.getEmail());

    }


    @Test
    public void testCreatingAPIAirplane(){
        int serialNum = 1234;
        APIAirline apiAirline = new APIAirline(null, null, null, "+4915112345678", "airline@gmail.com");
        boolean isOperable = true;

        APIAirplane apiAirplane = new APIAirplane(serialNum, apiAirline.getName(), isOperable);

        assertEquals(serialNum, apiAirplane.getSerialNum());
        assertEquals(apiAirline.getName(), apiAirplane.getBelongingAirlineName());
        if (isOperable) {
            assertTrue(apiAirplane.getIsOperable());
        } else {
            assertFalse(apiAirplane.getIsOperable());
        }
    }


    @Test
    public void testCreatingAPIAirport(){
        String code = "TestCode";
        String name = "TestName";
        String country = "TestCountry";
        String city = "TestCity";
        String timezone = "TestTimezone";

        APIAirport apiAirport = new APIAirport(code, name, country, city, timezone);

        assertEquals(code, apiAirport.getCode());
        assertEquals(name, apiAirport.getName());
        assertEquals(country, apiAirport.getCountry());
        assertEquals(city, apiAirport.getCity());
        assertEquals(timezone, apiAirport.getTimezone());

    }


    @Test
    public void testCreatingAPIClient(){
        long personId = 987654321;
        String firstName = "TestFirstName";
        String lastName = "TestLastName";
        String middleName = "TestMiddleName";
        Date dateofBirth = new Date();
        String phoneNumber = "+4915112345678";
        APIAddress address = new APIAddress(null, 0, 0, null, null);
        String email = "testmail@gmail.com";
        String password = "TestPassword";
        Boolean isBusinessClient = true;

        APIClient apiClient = new APIClient(personId, firstName, middleName, lastName, dateofBirth.toString(), phoneNumber, address, email, isBusinessClient);

        assertEquals(personId, apiClient.getClientId());
        assertEquals(firstName, apiClient.getFirstName());
        assertEquals(lastName, apiClient.getLastName());
        assertEquals(middleName, apiClient.getMiddleNames());
        assertEquals(dateofBirth.toString(), apiClient.getDateOfBirth());
        assertEquals(phoneNumber, apiClient.getPhoneNumber());
        assertEquals(address, apiClient.getAddress());
        assertEquals(email, apiClient.getEmail());
        if (isBusinessClient) {
            assertTrue(apiClient.getIsBusinessClient());
        } else {
            assertFalse(apiClient.getIsBusinessClient());
        }

    }

    @Test
    public void testCreatingAPIEmployee(){
        APIAirline apiAirline = new APIAirline("TestAirline", new Date().toString(), new APIAddress( ), "+4915112345678", "testmail@gmail.com");
        long personId = 987654321;
        String firstName = "TestFirstName";
        String lastName = "TestLastName";
        String middleName = "TestMiddleName";
        Date dateofBirth = new Date();
        String phoneNumber = "+4915112345678";
        APIAddress address = new APIAddress(null, 0, 0, null, null);
        String email = "testmail@gmail.com";

        APIEmployee apiEmployee = new APIEmployee(personId, firstName, middleName, lastName,apiAirline.getName(), email, address, phoneNumber, dateofBirth.toString());

        assertEquals(personId, apiEmployee.getEmployeeId());
        assertEquals(firstName, apiEmployee.getFirstName());
        assertEquals(middleName, apiEmployee.getMiddleNames());
        assertEquals(lastName, apiEmployee.getLastName());
        assertEquals(dateofBirth.toString(), apiEmployee.getDateOfBirth());
        assertEquals(phoneNumber, apiEmployee.getPhoneNumber());
        assertEquals(address, apiEmployee.getAddress());
        assertEquals(email, apiEmployee.getEmail());
        assertEquals(apiAirline.getName(), apiEmployee.getAirlineName());

    }

    @Test
    public void testCreatingAPIFlight(){
        long flightNum = 1234;
        APIAirplane apiAirplane = new APIAirplane(123456, null, true);
        Date departureDateTime = new Date();
        APIAirport departureAirport = new APIAirport("depCode", null, null, null, null);
        Date arrivalDateTime = new Date();
        APIAirport arrivalAirport = new APIAirport("arrCode", null, null, null, null);
        Date boardingTime = new Date();
        APIFlight.FlightStatus flyStatus = APIFlight.FlightStatus.landed;
        int duration = 123;
        APIEmployee pilot = new APIEmployee(1234567, null, null, null, null, null, null, null, null);
        APIEmployee copilot = new APIEmployee(987654321, null, null, null, null, null, null, null, null);

        APIFlight apiFlight = new APIFlight(flightNum, apiAirplane.getSerialNum(), departureDateTime.toString(), departureAirport.getCode(), arrivalDateTime.toString(), arrivalAirport.getCode(), boardingTime.toString(), flyStatus, duration, pilot.getEmployeeId(), copilot.getEmployeeId());

        assertEquals(flightNum, apiFlight.getFlightNum());
        assertEquals(apiAirplane.getSerialNum(), apiFlight.getAirplaneSerialNum());
        assertEquals(departureDateTime.toString(), apiFlight.getDepartureDateTime());
        assertEquals(departureAirport.getCode(), apiFlight.getDepartureAirportCode());
        assertEquals(arrivalDateTime.toString(), apiFlight.getArrivalDateTime());
        assertEquals(arrivalAirport.getCode(), apiFlight.getArrivalAirportCode());
        assertEquals(boardingTime.toString(), apiFlight.getBoardingTime());
        assertEquals(flyStatus, apiFlight.getStatus());
        assertEquals(duration, apiFlight.getDuration());
        assertEquals(pilot.getEmployeeId(), apiFlight.getPilotId());
        assertEquals(copilot.getEmployeeId(), apiFlight.getCopilotId());

    }

    @Test
    public void testCreatingAPIPayment(){
        String cardnumber = "+4915112345678";
        String expMonth = "TestExpMonth";
        String cvc = "testcvc";
        String expYear = "TestExpYear";

        APIPayment apiPayment = new APIPayment(cardnumber, expMonth, expYear, cvc);

        assertEquals(cardnumber, apiPayment.getCardNumber());
        assertEquals(expMonth, apiPayment.getExpMonth());
        assertEquals(cvc, apiPayment.getCvc());
        assertEquals(expYear, apiPayment.getExpYear());

    }

    @Test
    public void testCreatingAPITicket() {
        int ticketId = 1234;
        APIClient apiClient = new APIClient(123456789, null, null, null, null, null, null, null, true );
        boolean isClient = true;
        APIAirport apiAirport = new APIAirport("airportCode", null, null, null, null);
        APIAirplane apiAirplane = new APIAirplane(123456789, null, true);
        APIFlight apiFlight = new APIFlight(0, apiAirplane.getSerialNum(), new Date().toString(), apiAirport.getCode(), new Date().toString(), apiAirport.getCode(), new Date().toString(), APIFlight.FlightStatus.landed, 0, 0,  0);
        Date dateTimeOfBooking = new Date();
        int totalPrice = 300;
        int seatNum = 15;
        APITicket.SeatingClass seatingClass = APITicket.SeatingClass.Economy;
        APITicket.TicketStatus ticketStatus = APITicket.TicketStatus.paid;
        int weightOfLuggage = 20;

        APITicket apiTicket = new APITicket(ticketId, apiClient.getClientId(), isClient, apiFlight.getFlightNum(), dateTimeOfBooking.toString(), totalPrice, seatNum, seatingClass, ticketStatus, weightOfLuggage );

        assertEquals(ticketId, apiTicket.getTicketId());
        assertEquals(apiClient.getClientId(), apiTicket.getPersonId());
        assertEquals(apiFlight.getFlightNum(), apiTicket.getFlightNum());
        assertEquals(isClient, apiTicket.getIsClient());
        assertEquals(apiFlight.getFlightNum(), apiTicket.getFlightNum());
        assertEquals(dateTimeOfBooking.toString(), apiTicket.getDateTimeOfBooking());
        assertEquals(totalPrice, apiTicket.getTotalPrice());
        assertEquals(seatNum, apiTicket.getSeatNum());
        assertEquals(seatingClass, apiTicket.getSeatingClass());
        assertEquals(ticketStatus, apiTicket.getTicketStatus());
        assertEquals(weightOfLuggage, apiTicket.getWeightOfLuggage());

    }


}
