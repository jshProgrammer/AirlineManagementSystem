package de.tjjf.CRUDTests.BusinessLevel;

import de.tjjf.Domain.models.*;
import org.junit.jupiter.api.*;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpdateMModelsTest {

    @BeforeEach
    public void beforeEach() {
        Date d = new Date();
        String mAirlineName = "TestAirline";
        String headQuarters = "TestHeadquarters";
        MAirline mAirline = new MAirline(mAirlineName , d, headQuarters);

        int serialNum = 1234;
        String manufacturer = "TestManufacturer";
        String model = "TestModel";
        int amountOfEconomySeats = 50;
        int amountOfBusinessSeats = 25;
        int amountOfFirstClassSeats = 15;
        boolean isOperable = true;
        int maxWeightOfLuggage = 25;
        MAirplane mAirplane = new MAirplane(serialNum, manufacturer, model, amountOfEconomySeats, amountOfBusinessSeats, amountOfFirstClassSeats,  mAirline, isOperable, maxWeightOfLuggage);

        String departureMAirportCode = "departureTestCode";
        String departureMAirportName = "departureTestName";
        String departureMAirportCountry = "departureTestCountry";
        String departureMAirportCity = "departureTestCity";
        String departureMAirportTimezone = "departureTestTimezone";
        MAirport departureMAirport = new MAirport(departureMAirportCode, departureMAirportName,departureMAirportCountry, departureMAirportCity, departureMAirportTimezone);

        String arrivalMAirportCode = "arrivalTestCode";
        String arrivalMAirportName = "arrivalTestName";
        String arrivalMAirportCountry = "arrivalTestCountry";
        String arrivalMAirportCity = "arrivalTestCity";
        String arrivalMAirportTimezone = "arrivalTestTimezone";
        MAirport arrivalmAirport = new MAirport(arrivalMAirportCode, arrivalMAirportName,arrivalMAirportCountry, arrivalMAirportCity, arrivalMAirportTimezone);

        long flightNum = 1234;
        Date departureDateTime = new Date();
        Date arrivalDateTime = new Date();
        Date boardingTime = new Date();
        MFlight.FlyStatus flyStatus = MFlight.FlyStatus.landed;
        int duration = 123;
        MEmployee pilot = new MEmployee();
        MEmployee copilot = new MEmployee();
        MFlight mFlight = new MFlight(flightNum, mAirplane, departureDateTime, departureMAirport, arrivalDateTime, arrivalmAirport, boardingTime, flyStatus, duration, pilot, copilot);


        int ticketId = 1234;
        MPerson person = new MPerson();
        Date dateTimeOfBooking = new Date();
        int totalPrice = 300;
        int seatNum = 15;
        MTicket.SeatingClass seatingClass = MTicket.SeatingClass.Economy;
        MTicket.BookingStatus ticketStatus = MTicket.BookingStatus.Paid;
        int weightOfLuggage = 20;
        MTicket mTicket = new MTicket(ticketId, person, mFlight, dateTimeOfBooking, totalPrice, seatNum, seatingClass, ticketStatus, weightOfLuggage);
    }

    @Test
    public void testUpdateMAirline() {
        Date newFoundationYear = new Date();
        String newName = "UpdatedAirline";
        String newHeadquarters = "UpdatedHeadquarters";

        // Update values
        mAirline.setName(newName);
        mAirline.setFoundationYear(newFoundationYear);
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
