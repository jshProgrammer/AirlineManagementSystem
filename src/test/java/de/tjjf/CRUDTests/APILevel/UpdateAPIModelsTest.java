package de.tjjf.CRUDTests.APILevel;


import de.tjjf.Infrastructure.api.models.*;
import org.apiguardian.api.API;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpdateAPIModelsTest {

    APIAddress apiAddress;
    APIAirline apiAirline;
    APIAirplane apiAirplane;
    APIAirport departuremAirport;
    APIAirport arrivalmAirport;
    APIClient apiClient;
    APIEmployee apiEmployee;
    APIFlight apiFlight;
    APIPayment apiPayment;
    APITicket apiTicket;

    @BeforeEach
    public void beforeEach() {
        String apiAddressStreet = "TestStreet";
        int apiAddressNumber = 1;
        int apiAddressZipCode = 12345;
        String apiAddressCity = "TestCity";
        String apiAddressCountry = "TestCountry";
        apiAddress = new APIAddress(apiAddressStreet, apiAddressNumber, apiAddressZipCode, apiAddressCity, apiAddressCountry);

        String apiAirlineName = "TestAirline";
        Date apiAirlineDate = new Date();
        APIAddress apiAirlineMAddress = new APIAddress();
        String apiAirlinePhoneNumber = "+4915112345678";
        String apiAirlineEmail = "testemail@gmail.com";
        apiAirline = new APIAirline(apiAirlineName , apiAirlineDate, apiAirlineMAddress, apiAirlinePhoneNumber, apiAirlineEmail);

        int apiAirplaneSerialNum = 1234;
        String apiAirplaneAirlineName = "TestAirline";
        boolean apiAirplaneIsOperable = true;
        apiAirplane = new APIAirplane(apiAirplaneSerialNum, apiAirplaneAirlineName, apiAirplaneIsOperable);

        String departureMAirportCode = "departureTestCode";
        String departureMAirportName = "departureTestName";
        String departureMAirportCountry = "departureTestCountry";
        String departureMAirportCity = "departureTestCity";
        String departureMAirportTimezone = "departureTestTimezone";
        departuremAirport = new APIAirport(departureMAirportCode, departureMAirportName,departureMAirportCountry, departureMAirportCity, departureMAirportTimezone);

        String arrivalMAirportCode = "arrivalTestCode";
        String arrivalMAirportName = "arrivalTestName";
        String arrivalMAirportCountry = "arrivalTestCountry";
        String arrivalMAirportCity = "arrivalTestCity";
        String arrivalMAirportTimezone = "arrivalTestTimezone";
        arrivalmAirport = new APIAirport(arrivalMAirportCode, arrivalMAirportName,arrivalMAirportCountry, arrivalMAirportCity, arrivalMAirportTimezone);

        long apiClientPersonId = 9999999;
        String apiClientFirstName = "TestClientFirstName";
        String apiClientMiddleNames = "TestClientMiddleNames";
        String apiClientLastName = "TestClientLastName";
        Date apiClientDateOfBirth = new Date();
        String apiClientPhoneNumber = "+4915112345678";
        APIAddress apiClientMAddress = new APIAddress(null, 0, 0, null, null);
        String apiClientEmail = "testemail@gmail.com";
        boolean mClientIsBusinessClient = true;
        apiClient = new APIClient(apiClientPersonId, apiClientFirstName, apiClientMiddleNames, apiClientLastName, apiClientDateOfBirth,  apiClientPhoneNumber, apiClientMAddress, apiClientEmail, mClientIsBusinessClient);

        long apiEmployeePersonId = 9999999;
        String apiEmployeeFirstName = "TestEmployeetFirstName";
        String apiEmployeeMiddleNames = "TestEmployeeMiddleNames";
        String apiEmployeeLastName = "TestEmployeeLastName";
        String apiEmployeeAirlineName = "TestAirlineName";
        String apiEmployeePhoneNumber = "+4915112345678";
        APIAddress apiEmployeeAPIAddress = new APIAddress(null, 0, 0, null, null);
        String apiEmployeeEmail = "testemail@gmail.com";
        Date apiEmployeeDateOfBirth = new Date();
        apiEmployee = new APIEmployee(apiEmployeePersonId, apiEmployeeFirstName, apiEmployeeMiddleNames, apiEmployeeLastName, apiEmployeeAirlineName, apiEmployeeEmail, apiEmployeeAPIAddress, apiEmployeePhoneNumber, apiEmployeeDateOfBirth);

        long apiFlightFlightNum = 123456789;
        int airplansSerialNum = 987654321;
        Date departureDateTime = new Date();
        String departureAirlineCode = "departureTestCode";
        Date arrivalDateTime = new Date();
        String arrivalAirlineName = "arrivalTestName";
        Date boardingTime = new Date();
        APIFlight.FlightStatus flightStatus = APIFlight.FlightStatus.landed;
        int apiFlightDuration = 100;
        long apiFlightPilotId = 888888888;
        long apiFlightCopilotId = 77777777;
        apiFlight = new APIFlight(apiFlightFlightNum, airplansSerialNum, departureDateTime, departureAirlineCode, arrivalDateTime, arrivalAirlineName, boardingTime, flightStatus, apiFlightDuration, apiFlightPilotId, apiFlightCopilotId);

        long mPersonPersonId = 9999999;
        String mPersonFirstName = "TestEmployeetFirstName";
        String mPersonMiddleNames = "TestEmployeeMiddleNames";
        String mPersonLastName = "TestEmployeeLastName";
        Date mPersonDateOfBirth = new Date();
        String mPersonPhoneNumber = "+4915112345678";
        APIAddress mPersonMAddress = new APIAddress(null, 0, 0, null, null);
        String mPersonEmail = "testemail@gmail.com";
        APIClient apiTicketClient = new APIClient(mPersonPersonId, mPersonFirstName, mPersonMiddleNames, mPersonLastName, mPersonDateOfBirth, mPersonPhoneNumber, mPersonMAddress, mPersonEmail, true);

        String cardNumber = "TestCardNumber";
        String expMonth  = "TestExpMonth";
        String expYear = "TestExpYear";
        String cvc = "TestCVC";
        apiPayment = new APIPayment(cardNumber, expMonth, expYear, cvc);

        int mTicketTicketId = 1234;
        Date mTicketDateTimeOfBooking = new Date();
        int mTicketTotalPrice = 300;
        int mTicketSeatNum = 15;
        APITicket.SeatingClass mTicketSeatingClass = APITicket.SeatingClass.Economy;
        APITicket.TicketStatus mTicketTicketStatus = APITicket.TicketStatus.paid;
        int mTicketWeightOfLuggage = 20;
        apiTicket = new APITicket(mTicketTicketId, apiTicketClient.getClientId(), true, apiFlight.getFlightNum(), mTicketDateTimeOfBooking, mTicketTotalPrice, mTicketSeatNum, mTicketSeatingClass, mTicketTicketStatus, mTicketWeightOfLuggage);
    }

    @Test
    public void testUpdateAddress(){
        String updatedStreet = "UpdatedStreet";
        int updatedNumber = 2;
        int updatedZipcode = 67890;
        String updatedCity = "UpdatedCity";
        String updatedCountry = "UpdatedCountry";

        apiAddress.setCity(updatedCity);
        apiAddress.setCountry(updatedCountry);
        apiAddress.setStreet(updatedStreet);
        apiAddress.setNumber(updatedNumber);
        apiAddress.setZipcode(updatedZipcode);

        assertEquals(updatedStreet, apiAddress.getStreet());
        assertEquals(updatedNumber, apiAddress.getNumber());
        assertEquals(updatedZipcode, apiAddress.getZipcode());
        assertEquals(updatedCity, apiAddress.getCity());
        assertEquals(updatedCountry, apiAddress.getCountry());
    }

    @Test
    public void testUpdateMAirline() {
        String updatedName = "UpdatedAirline";
        String updatedEmail = "updatedEmail@gmail.com";
        String updatedPhoneNumber = "+4915198765432";
        APIAddress updatedMAddress = new APIAddress(null, 0, 0, null, null);

        // Update values
        apiAirline.setName(updatedName);
        apiAirline.setAddress(updatedMAddress);
        apiAirline.setEmail(updatedEmail);
        apiAirline.setPhoneNumber(updatedPhoneNumber);

        // Assertions
        assertEquals(updatedName, apiAirline.getName());
        assertEquals(updatedMAddress, apiAirline.getAddress());
        assertEquals(updatedPhoneNumber, apiAirline.getPhoneNumber());
        assertEquals(updatedEmail, apiAirline.getEmail());
    }

    @Test
    public void testUpdateMAirplane() {
        boolean updatedIsOperable = false;
        APIAirline updatedAirline = new APIAirline(null, null, null,"+4915112345678","updatedairline@gmail.com");

        apiAirplane.setBelongingAirlineName(updatedAirline.getName());
        apiAirplane.setIsOperable(updatedIsOperable);

        assertEquals(updatedAirline.getName(), apiAirplane.getBelongingAirlineName());
        assertEquals(updatedIsOperable, apiAirplane.getIsOperable());
    }

    @Test
    public void testUpdateAirport(){
        String updatedName = "UpdatedAirport";
        String updatedCountry = "UpdatedCountry";
        String updatedCity = "UpdatedCity";
        String updatedTimezone = "UpdatedTimezone";

        departuremAirport.setCity(updatedCity);
        departuremAirport.setCountry(updatedCountry);
        departuremAirport.setTimezone(updatedTimezone);
        departuremAirport.setName(updatedName);

        assertEquals(updatedCity, departuremAirport.getCity());
        assertEquals(updatedCountry, departuremAirport.getCountry());
        assertEquals(updatedTimezone, departuremAirport.getTimezone());
        assertEquals(updatedName, departuremAirport.getName());
    }

    @Test
    public void testUpdateClient(){
        String updatedFirstName = "UpdatedClient";
        String updatedMiddleName = "UpdatedMiddleName";
        String updatedLastName = "UpdatedLastName";
        String updatedPhoneNumber = "+491519873333";
        String updatedEmail = "updatedEmail@gmail.com";
        boolean updatedIsBusinessClient = false;

        apiClient.setFirstName(updatedFirstName);
        apiClient.setMiddleNames(updatedMiddleName);
        apiClient.setLastName(updatedLastName);
        apiClient.setPhoneNumber(updatedPhoneNumber);
        apiClient.setEmail(updatedEmail);
        apiClient.setBusinessClient(updatedIsBusinessClient);

        assertEquals(updatedFirstName, apiClient.getFirstName());
        assertEquals(updatedMiddleName, apiClient.getMiddleNames());
        assertEquals(updatedLastName, apiClient.getLastName());
        assertEquals(updatedPhoneNumber, apiClient.getPhoneNumber());
        assertEquals(updatedEmail, apiClient.getEmail());
        assertEquals(updatedIsBusinessClient, apiClient.isBusinessClient());
    }

    @Test
    public void testUpdateEmployee(){

        APIAirline updatedAirline = new APIAirline(null, null, null,"+4915112345678","updatedariline@gmail.com");
        String updatedFirstName = "UpdatedEmployee";
        String updatedMiddleName = "UpdatedMiddleName";
        String updatedLastName = "UpdatedLastName";
        String updatedEmail = "updatedEmail@gmail.com";
        String updatedPhoneNumber = "+491519873333";

        apiEmployee.setAirlineName(updatedAirline.getName());
        apiEmployee.setFirstName(updatedFirstName);
        apiEmployee.setMiddleNames(updatedMiddleName);
        apiEmployee.setLastName(updatedLastName);
        apiEmployee.setEmail(updatedEmail);
        apiEmployee.setPhoneNumber(updatedPhoneNumber);

        assertEquals(updatedAirline.getName(), apiEmployee.getAirlineName());
        assertEquals(updatedFirstName, apiEmployee.getFirstName());
        assertEquals(updatedMiddleName, apiEmployee.getMiddleNames());
        assertEquals(updatedLastName, apiEmployee.getLastName());
        assertEquals(updatedEmail, apiEmployee.getEmail());
        assertEquals(updatedPhoneNumber, apiEmployee.getPhoneNumber());
    }

    @Test
    public void testUpdateFlight(){
        APIAirplane updatedAirplane = new APIAirplane(0, null,true);
        Date updatedDepartureDateTime = new Date();
        APIAirport updatedDepartureAirport = new APIAirport(null, null,null,null,null);
        Date updatedArrivalDateTime = new Date();
        APIAirport updatedArrivalAirport = new APIAirport(null, null,null,null,null);
        Date updatedBoardingTime = new Date();
        APIFlight.FlightStatus updatedFlightStatus = APIFlight.FlightStatus.landed;
        int updatedDuration = 123;
        APIEmployee updatedPilot = new APIEmployee(0,null, null,null,null,"updatedpilot@gmail.com",null,"+4915112345678", null);
        APIEmployee updatedCoPilot = new APIEmployee(0,null, null,null,null,"updatedcopilot@gmail.com",null,"+4915112345678",null);
        apiFlight.setAirplaneSerialNum(updatedAirplane.getSerialNum());
        apiFlight.setDepartureDateTime(updatedDepartureDateTime);
        apiFlight.setArrivalDateTime(updatedArrivalDateTime);
        apiFlight.setBoardingTime(updatedBoardingTime);
        apiFlight.setStatus(updatedFlightStatus);
        apiFlight.setPilot(updatedPilot.getEmployeeId());
        apiFlight.setArrivalAirport(updatedArrivalAirport.getCode());
        apiFlight.setCopilot(updatedCoPilot.getEmployeeId());
        apiFlight.setDepartureAirport(updatedDepartureAirport.getCode());
        apiFlight.setDuration(updatedDuration);

        assertEquals(updatedAirplane.getSerialNum(), apiFlight.getAirplaneSerialNum());
        assertEquals(updatedDepartureDateTime, apiFlight.getDepartureDateTime());
        assertEquals(updatedArrivalDateTime, apiFlight.getArrivalDateTime());
        assertEquals(updatedBoardingTime, apiFlight.getBoardingTime());
        assertEquals(updatedFlightStatus, apiFlight.getStatus());
        assertEquals(updatedPilot.getEmployeeId(), apiFlight.getPilot());
        assertEquals(updatedCoPilot.getEmployeeId(), apiFlight.getCopilot());
        assertEquals(updatedDepartureAirport.getCode(), apiFlight.getDepartureAirport());
        assertEquals(updatedDuration, apiFlight.getDuration());
        assertEquals(updatedArrivalAirport.getCode(), apiFlight.getArrivalAirport());
    }

    @Test
    public void testUpdateTicket(){
        APITicket.TicketStatus updatedTicketStatus = APITicket.TicketStatus.unpaid;
        APIFlight updatedFlight = new APIFlight(0,333,null,null,null,null, null,null,0,3,3);
        APIClient updatedPerson = new APIClient(0,null,null,null,null,"+4915112345678",null,"updatedperson@gmail.com",true);
        int updatedSeatNum = 100;
        int updatedPrice = 1000;

        apiTicket.setTicketStatus(updatedTicketStatus);
        apiTicket.setPersonId(updatedPerson.getClientId());
        apiTicket.setFlightNum(updatedFlight.getFlightNum());
        apiTicket.setTotalPrice(updatedPrice);
        apiTicket.setSeatNum(updatedSeatNum);

        assertEquals(updatedTicketStatus, apiTicket.getTicketStatus());
        assertEquals(updatedPerson.getClientId(), apiTicket.getPersonId());
        assertEquals(updatedFlight.getFlightNum(), apiTicket.getFlightNum());
        assertEquals(updatedPrice, apiTicket.getTotalPrice());
        assertEquals(updatedSeatNum, apiTicket.getSeatNum());
    }

    @Test
    public void testUpdatePayment(){
        String updatedCardNumber = "UpdatedCardNumber";
        String updatedExpMonth = "UpdatedExpMonth";
        String updatedExpYear = "UpdatedExpYear";
        String updatedCvc = "UpdatedCvc";

        apiPayment.setCardNumber(updatedCardNumber);
        apiPayment.setExpMonth(updatedExpMonth);
        apiPayment.setExpYear(updatedExpYear);
        apiPayment.setCvc(updatedCvc);

        assertEquals(updatedCardNumber, apiPayment.getCardNumber());
        assertEquals(updatedExpMonth, apiPayment.getExpMonth());
        assertEquals(updatedExpYear, apiPayment.getExpYear());
        assertEquals(updatedCvc, apiPayment.getCvc());
    }
}
