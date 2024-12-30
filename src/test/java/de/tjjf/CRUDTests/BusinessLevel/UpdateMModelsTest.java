package de.tjjf.CRUDTests.BusinessLevel;

import de.tjjf.Domain.models.*;
import org.junit.jupiter.api.*;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpdateMModelsTest {

    MAddress mAddress;
    MAirline mAirline;
    MAirplane mAirplane;
    MAirport departuremAirport;
    MAirport arrivalmAirport;
    MClient mClient;
    MEmployee mEmployee;
    MFlight mFlight;
    MPerson mPerson;
    MTicket mTicket;

    @BeforeEach
    public void beforeEach() {
        String mAddressStreet = "TestStreet";
        int mAddressNumber = 1;
        int mAddressZipCode = 12345;
        String mAddressCity = "TestCity";
        String mAddressCountry = "TestCountry";
        mAddress = new MAddress(mAddressStreet, mAddressNumber, mAddressZipCode, mAddressCity, mAddressCountry);

        String mAirlineName = "TestAirline";
        Date mAirlineDate = new Date();
        String mAirlineHeadQuarters = "TestHeadquarters";
        MAddress mAirlineMAddress = new MAddress(null, 0, 0, null, null);
        String mAirlinePhoneNumber = "+4915112345678";
        String mAirlineEmail = "testemail@gmail.com";
        mAirline = new MAirline(mAirlineName , mAirlineDate, mAirlineHeadQuarters, mAirlineMAddress, mAirlinePhoneNumber, mAirlineEmail);

        int mAirplaneSerialNum = 1234;
        String mAirplaneManufacturer = "TestManufacturer";
        String mAirplaneModel = "TestModel";
        int mAirplaneAmountOfEconomySeats = 50;
        int mAirplaneAmountOfBusinessSeats = 25;
        int mAirplaneAmountOfFirstClassSeats = 15;
        boolean mAirplaneIsOperable = true;
        int mAirplaneMaxWeightOfLuggage = 40000;
        mAirplane = new MAirplane(mAirplaneSerialNum, mAirplaneManufacturer, mAirplaneModel, mAirplaneAmountOfEconomySeats, mAirplaneAmountOfBusinessSeats, mAirplaneAmountOfFirstClassSeats,  mAirline, mAirplaneIsOperable, mAirplaneMaxWeightOfLuggage);

        String departureMAirportCode = "departureTestCode";
        String departureMAirportName = "departureTestName";
        String departureMAirportCountry = "departureTestCountry";
        String departureMAirportCity = "departureTestCity";
        String departureMAirportTimezone = "departureTestTimezone";
        departuremAirport = new MAirport(departureMAirportCode, departureMAirportName,departureMAirportCountry, departureMAirportCity, departureMAirportTimezone);

        String arrivalMAirportCode = "arrivalTestCode";
        String arrivalMAirportName = "arrivalTestName";
        String arrivalMAirportCountry = "arrivalTestCountry";
        String arrivalMAirportCity = "arrivalTestCity";
        String arrivalMAirportTimezone = "arrivalTestTimezone";
        arrivalmAirport = new MAirport(arrivalMAirportCode, arrivalMAirportName,arrivalMAirportCountry, arrivalMAirportCity, arrivalMAirportTimezone);

        long mClientPersonId = 9999999;
        String mClientFirstName = "TestClientFirstName";
        String mClientMiddleNames = "TestClientMiddleNames";
        String mClientLastName = "TestClientLastName";
        Date mClientDateOfBirth = new Date();
        String mClientPhoneNumber = "+4915112345678";
        MAddress mClientMAddress = new MAddress(null, 0, 0, null, null);
        String mClientEmail = "testemail@gmail.com";
        boolean mClientIsBusinessClient = true;
        mClient = new MClient(mClientPersonId, mClientFirstName, mClientMiddleNames, mClientLastName, mClientDateOfBirth,  mClientPhoneNumber, mClientMAddress, mClientEmail, mClientIsBusinessClient);

        long mEmployeePersonId = 9999999;
        String mEmployeeFirstName = "TestEmployeetFirstName";
        String mEmployeeMiddleNames = "TestEmployeeMiddleNames";
        String mEmployeeLastName = "TestEmployeeLastName";
        Date mEmployeeDateOfBirth = new Date();
        String mEmployeePhoneNumber = "+4915112345678";
        MAddress mEmployeeMAddress = new MAddress(null, 0, 0, null, null);
        String mEmployeeEmail = "testemail@gmail.com";
        int mEmployeeSalary = 100;
        String mEmployeePosition = "TestPosition";
        MAirline mEmployeeMAirline = new MAirline(null, null, null, null ,"+4915112345678","memployeeairline@gmail.com");
        Date mEmployeeHireDate = new Date();
        mEmployee = new MEmployee(mEmployeePersonId, mEmployeeFirstName, mEmployeeMiddleNames, mEmployeeLastName, mEmployeeDateOfBirth,  mEmployeePhoneNumber, mEmployeeMAddress, mEmployeeEmail, mEmployeeSalary, mEmployeePosition,mEmployeeMAirline,mEmployeeHireDate);

        long mFLightFlightNum = 1234;
        Date mAirplaneDepartureDateTime = new Date();
        Date mAirplaneArrivalDateTime = new Date();
        Date mAirplaneBoardingTime = new Date();
        MFlight.FlightStatus mAirplaneFlightStatus = MFlight.FlightStatus.landed;
        int mAirplaneDuration = 123;
        MEmployee mAirplanePilot = new MEmployee(0, null, null, null, null, "+4915112345678",null, "mairlinepilot@gmail.com", 0, null, null, null);
        MEmployee mAirplaneCopilot = new MEmployee(0, null, null, null, null, "+4915112345678",null, "mairlinecopilot@gmail.com",  0, null, null, null);
        mFlight = new MFlight(mFLightFlightNum, mAirplane, mAirplaneDepartureDateTime, departuremAirport, mAirplaneArrivalDateTime, arrivalmAirport, mAirplaneBoardingTime, mAirplaneFlightStatus, mAirplaneDuration, mAirplanePilot, mAirplaneCopilot);

        long mPersonPersonId = 9999999;
        String mPersonFirstName = "TestEmployeetFirstName";
        String mPersonMiddleNames = "TestEmployeeMiddleNames";
        String mPersonLastName = "TestEmployeeLastName";
        Date mPersonDateOfBirth = new Date();
        String mPersonPhoneNumber = "+4915112345678";
        MAddress mPersonMAddress = new MAddress(null, 0, 0, null, null);
        String mPersonEmail = "testemail@gmail.com";
        String mPersonPassword = "testpassword";
        mPerson = new MPerson(mPersonPersonId, mPersonFirstName, mPersonMiddleNames, mPersonLastName,mPersonDateOfBirth,mPersonPhoneNumber,mPersonMAddress, mPersonEmail, null );

        int mTicketTicketId = 1234;
        MPerson mTicketPerson = new MPerson(0,null,null,null,null,"+4915112345678",null,"mticketperson@gmail.com", null);
        Date mTicketDateTimeOfBooking = new Date();
        int mTicketTotalPrice = 300;
        int mTicketSeatNum = 15;
        MTicket.SeatingClass mTicketSeatingClass = MTicket.SeatingClass.Economy;
        MTicket.TicketStatus mTicketTicketStatus = MTicket.TicketStatus.paid;
        int mTicketWeightOfLuggage = 20;
        mTicket = new MTicket(mTicketTicketId, mTicketPerson, mFlight, mTicketDateTimeOfBooking, mTicketTotalPrice, mTicketSeatNum, mTicketSeatingClass, mTicketTicketStatus, mTicketWeightOfLuggage);
    }

    @Test
    public void testUpdateAddress(){
        String updatedStreet = "UpdatedStreet";
        int updatedNumber = 2;
        int updatedZipcode = 67890;
        String updatedCity = "UpdatedCity";
        String updatedCountry = "UpdatedCountry";

        mAddress.setCity(updatedCity);
        mAddress.setCountry(updatedCountry);
        mAddress.setStreet(updatedStreet);
        mAddress.setNumber(updatedNumber);
        mAddress.setZipcode(updatedZipcode);

        assertEquals(mAddress.getStreet(), updatedStreet);
        assertEquals(mAddress.getNumber(), updatedNumber);
        assertEquals(mAddress.getZipcode(), updatedZipcode);
        assertEquals(mAddress.getCity(), updatedCity);
        assertEquals(mAddress.getCountry(), updatedCountry);
    }

    @Test
    public void testUpdateMAirline() {
        String updatedName = "UpdatedAirline";
        String updatedHeadquarters = "UpdatedHeadquarters";
        String updatedEmail = "updatedEmail@gmail.com";
        String updatedPhoneNumber = "+4915198765432";
        MAddress updatedMAddress = new MAddress(null, 0, 0, null, null);

        // Update values
        mAirline.setName(updatedName);
        mAirline.setHeadQuarters(updatedHeadquarters);
        mAirline.setAddress(updatedMAddress);
        mAirline.setEmail(updatedEmail);
        mAirline.setPhoneNumber(updatedPhoneNumber);

        // Assertions
        assertEquals(mAirline.getName(), updatedName);
        assertEquals(mAirline.getHeadQuarters(), updatedHeadquarters);
        assertEquals(mAirline.getAddress(), updatedMAddress);
        assertEquals(mAirline.getPhoneNumber(), updatedPhoneNumber);
        assertEquals(mAirline.getEmail(), updatedEmail);
    }

    @Test
    public void testUpdateMAirplane() {
        boolean updatedIsOperable = false;
        MAirline updatedAirline = new MAirline(null, null, null, null ,"+4915112345678","updatedairline@gmail.com");

        mAirplane.setBelongingAirline(updatedAirline);
        mAirplane.setOperable(updatedIsOperable);

        assertEquals(mAirplane.getBelongingAirline(), updatedAirline);
        assertEquals(mAirplane.isOperable(), updatedIsOperable);
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

        assertEquals(departuremAirport.getCity(), updatedCity);
        assertEquals(departuremAirport.getCountry(), updatedCountry);
        assertEquals(departuremAirport.getTimezone(), updatedTimezone);
        assertEquals(departuremAirport.getName(), updatedName);
    }

    @Test
    public void testUpdateClient(){
        boolean updatedIsBusinessClient = false;

        mClient.setBusinessClient(updatedIsBusinessClient);

        assertEquals(mClient.isBusinessClient(), updatedIsBusinessClient);
    }

    @Test
    public void testUpdateEmployee(){
        int updatedSalary = 200;
        String updatedPosition = "UpdatedPosition";
        MAirline updatedAirline = new MAirline(null, null, null, null ,"+4915112345678","updatedariline@gmail.com");
        Date updatedHireDate= new Date();

        mEmployee.setHireDate(updatedHireDate);
        mEmployee.setSalary(updatedSalary);
        mEmployee.setPosition(updatedPosition);
        mEmployee.setAirline(updatedAirline);

        assertEquals(mEmployee.getHireDate(), updatedHireDate);
        assertEquals(mEmployee.getSalary(), updatedSalary);
        assertEquals(mEmployee.getPosition(), updatedPosition);
        assertEquals(mEmployee.getAirline(), updatedAirline);
    }

    @Test
    public void testUpdateFlight(){
        MAirplane updatedAirplane = new MAirplane(0, null,null,0,0,0,null,true,0);
        Date updatedDepartureDateTime = new Date();
        MAirport updatedDepartureAirport = new MAirport(null, null,null,null,null);
        Date updatedArrivalDateTime = new Date();
        MAirport updatedArrivalAirport = new MAirport(null, null,null,null,null);
        Date updatedBoardingTime = new Date();
        MFlight.FlightStatus updatedFlightStatus = MFlight.FlightStatus.landed;
        int updatedDuration = 123;
        MEmployee updatedPilot = new MEmployee(0,null, null,null,null,"+4915112345678",null,"updatedpilot@gmail.com",0,null,null,null);
        MEmployee updatedCoPilot = new MEmployee(0,null, null,null,null,"+4915112345678",null,"updatedcopilot@gmail.com",0,null,null,null);
        mFlight.setAirplane(updatedAirplane);
        mFlight.setDepartureDateTime(updatedDepartureDateTime);
        mFlight.setArrivalDateTime(updatedArrivalDateTime);
        mFlight.setBoardingTime(updatedBoardingTime);
        mFlight.setStatus(updatedFlightStatus);
        mFlight.setPilot(updatedPilot);
        mFlight.setArrivalAirport(updatedArrivalAirport);
        mFlight.setCopilot(updatedCoPilot);
        mFlight.setDepartureAirport(updatedDepartureAirport);
        mFlight.setDuration(updatedDuration);

        assertEquals(mFlight.getAirplane(), updatedAirplane);
        assertEquals(mFlight.getDepartureDateTime(), updatedDepartureDateTime);
        assertEquals(mFlight.getArrivalDateTime(), updatedArrivalDateTime);
        assertEquals(mFlight.getBoardingTime(), updatedBoardingTime);
        assertEquals(mFlight.getStatus(), updatedFlightStatus);
        assertEquals(mFlight.getPilot(), updatedPilot);
        assertEquals(mFlight.getCopilot(), updatedCoPilot);
        assertEquals(mFlight.getDepartureAirport(), updatedDepartureAirport);
        assertEquals(mFlight.getDuration(), updatedDuration);
        assertEquals(mFlight.getArrivalAirport(), updatedArrivalAirport);
    }

    @Test
    public void testUpdatePerson(){
        String updatedFirstName = "UpdatedFirstName";
        String updatedMiddleName = "UpdatedMiddleName";
        String updatedLastName = "UpdatedLastName";
        Date updatedDateOfBirth = new Date();
        String updatedPhoneNumber = "+49151987654321";
        String updatedEmail = "UpdatedEmail";
        MAddress updatedAdress = new MAddress(null,0,0,null,null);

        mPerson.setFirstName(updatedFirstName);
        mPerson.setLastName(updatedLastName);
        mPerson.setDateOfBirth(updatedDateOfBirth);
        mPerson.setMiddleNames(updatedMiddleName);
        mPerson.setEmail(updatedEmail);
        mPerson.setPhonenumber(updatedPhoneNumber);
        mPerson.setAddress(updatedAdress);

        assertEquals(mPerson.getFirstName(), updatedFirstName);
        assertEquals(mPerson.getLastName(), updatedLastName);
        assertEquals(mPerson.getDateOfBirth(), updatedDateOfBirth);
        assertEquals(mPerson.getMiddleNames(), updatedMiddleName);
        assertEquals(mPerson.getEmail(), updatedEmail);
        assertEquals(mPerson.getPhonenumber(), updatedPhoneNumber);
        assertEquals(mPerson.getAddress(), updatedAdress);
    }

    @Test
    public void testUpdateTicket(){
        MTicket.TicketStatus updatedTicketStatus = MTicket.TicketStatus.unpaid;
        MFlight updatedFlight = new MFlight(0,null,null,null,null,null, null,null,0,null,null);
        MPerson updatedPerson = new MPerson(0,null,null,null,null,"+4915112345678",null,"updatedperson@gmail.com", null);
        int updatedSeatNum = 100;
        int updatedPrice = 1000;

        mTicket.setTicketStatus(updatedTicketStatus);
        mTicket.setPerson(updatedPerson);
        mTicket.setFlightNum(updatedFlight);
        mTicket.setTotalPrice(updatedPrice);
        mTicket.setSeatNum(updatedSeatNum);

        assertEquals(mTicket.getTicketStatus(), updatedTicketStatus);
        assertEquals(mTicket.getPerson(), updatedPerson);
        assertEquals(mTicket.getFlight(), updatedFlight);
        assertEquals(mTicket.getTotalPrice(), updatedPrice);
        assertEquals(mTicket.getSeatNum(), updatedSeatNum);
    }
}
