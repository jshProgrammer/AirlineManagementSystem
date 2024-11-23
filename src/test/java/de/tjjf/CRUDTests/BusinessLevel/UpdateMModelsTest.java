package de.tjjf.CRUDTests.BusinessLevel;

import de.tjjf.Domain.models.*;
import org.junit.jupiter.api.*;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpdateMModelsTest {

    MAddress mAddress;
    MAirline mAirline;
    MAirplane mAirplane;
    MAirport departureMAirport;
    MAirport arrivalmAirport;
    MClient mClient;
    MEmployee mEmployee;
    MFlight mFlight;
    MPerson mPerson;
    MTicket mTicket;

    @BeforeEach
    public void beforeEach() {
        String mAirlineName = "TestAirline";
        Date mAirlineDate = new Date();
        String mAirlineHeadQuarters = "TestHeadquarters";
        MAddress mAirlineMAddress = new MAddress(null, 0, 0, null, null);
        String mAirlinePhoneNumber = "1234567890";
        String mAirlineEmail = "testemail@gmail.com";
        mAirline = new MAirline(mAirlineName , mAirlineDate, mAirlineHeadQuarters, mAirlineMAddress, mAirlinePhoneNumber, mAirlineEmail);

        int mAirplaneSerialNum = 1234;
        String mAirplaneManufacturer = "TestManufacturer";
        String mAirplaneModel = "TestModel";
        int mAirplaneAmountOfEconomySeats = 50;
        int mAirplaneAmountOfBusinessSeats = 25;
        int mAirplaneAmountOfFirstClassSeats = 15;
        boolean mAirplaneIsOperable = true;
        int mAirplaneMaxWeightOfLuggage = 25;
        mAirplane = new MAirplane(mAirplaneSerialNum, mAirplaneManufacturer, mAirplaneModel, mAirplaneAmountOfEconomySeats, mAirplaneAmountOfBusinessSeats, mAirplaneAmountOfFirstClassSeats,  mAirline, mAirplaneIsOperable, mAirplaneMaxWeightOfLuggage);

        String departureMAirportCode = "departureTestCode";
        String departureMAirportName = "departureTestName";
        String departureMAirportCountry = "departureTestCountry";
        String departureMAirportCity = "departureTestCity";
        String departureMAirportTimezone = "departureTestTimezone";
        departureMAirport = new MAirport(departureMAirportCode, departureMAirportName,departureMAirportCountry, departureMAirportCity, departureMAirportTimezone);

        String arrivalMAirportCode = "arrivalTestCode";
        String arrivalMAirportName = "arrivalTestName";
        String arrivalMAirportCountry = "arrivalTestCountry";
        String arrivalMAirportCity = "arrivalTestCity";
        String arrivalMAirportTimezone = "arrivalTestTimezone";
        arrivalmAirport = new MAirport(arrivalMAirportCode, arrivalMAirportName,arrivalMAirportCountry, arrivalMAirportCity, arrivalMAirportTimezone);

        long mFLightFlightNum = 1234;
        Date mAirplaneDepartureDateTime = new Date();
        Date mAirplaneArrivalDateTime = new Date();
        Date mAirplaneBoardingTime = new Date();
        MFlight.FlightStatus mAirplaneFlightStatus = MFlight.FlightStatus.landed;
        int mAirplaneDuration = 123;
        MEmployee mAirplanePilot = new MEmployee(0,null,null,null,null,null,null,null,null,0,null,null,null);
        MEmployee mAirplaneCopilot = new MEmployee(0,null,null,null,null,null,null,null,null,0,null,null,null);
        mFlight = new MFlight(mFLightFlightNum, mAirplane, mAirplaneDepartureDateTime, departureMAirport, mAirplaneArrivalDateTime, arrivalmAirport, mAirplaneBoardingTime, mAirplaneFlightStatus, mAirplaneDuration, mAirplanePilot, mAirplaneCopilot);


        int mTicketTicketId = 1234;
        MPerson mTicketPerson = new MPerson(0,null,null,null,null,null,null,null,null);
        Date mTicketDateTimeOfBooking = new Date();
        int mTicketTotalPrice = 300;
        int mTicketSeatNum = 15;
        MTicket.SeatingClass mTicketSeatingClass = MTicket.SeatingClass.Economy;
        MTicket.TicketStatus mTicketTicketStatus = MTicket.TicketStatus.paid;
        int mTicketWeightOfLuggage = 20;
        mTicket = new MTicket(mTicketTicketId, mTicketPerson, mFlight, mTicketDateTimeOfBooking, mTicketTotalPrice, mTicketSeatNum, mTicketSeatingClass, mTicketTicketStatus, mTicketWeightOfLuggage);
    }

    @Test
    public void testUpdateMAirline() {
        Date newFoundationYear = new Date();
        String newName = "UpdatedAirline";
        String newHeadquarters = "UpdatedHeadquarters";

        // Update values
        mAirline.setName(newName);
        mAirline.setHeadQuarters(newHeadquarters);

        // Assertions
        assertEquals(mAirline.getName(), newName);
        assertEquals(mAirline.getFoundationYear(), newFoundationYear);
        assertEquals(mAirline.getHeadQuarters(), newHeadquarters);
    }

    @Test
    public void testUpdateMAirplane() {
        int newSerialNum = 5678;
        String newManufacturer = "UpdatedManufacturer";
        String newModel = "UpdatedModel";
        boolean newOperatableStatus = false;
        int newMaxWeightOfLuggage = 50;

        // Update values
        mAirplane.setSerialNum(newSerialNum);
        mAirplane.setManufacturer(newManufacturer);
        mAirplane.setModel(newModel);
        mAirplane.setOperatable(newOperatableStatus);
        mAirplane.setMaxWeightOfLuggage(newMaxWeightOfLuggage);

        // Assertions
        assertEquals(mAirplane.getSerialNum(), newSerialNum);
        assertEquals(mAirplane.getManufacturer(), newManufacturer);
        assertEquals(mAirplane.getModel(), newModel);
        assertEquals(mAirplane.isOperatable(), newOperatableStatus);
        assertEquals(mAirplane.getMaxWeightOfLuggage(), newMaxWeightOfLuggage);
    }


}
