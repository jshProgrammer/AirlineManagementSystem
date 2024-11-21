package de.tjjf.CRUDTests.BusinessLevel;

import de.tjjf.Domain.models.*;
import de.tjjf.Infrastructure.persistence.entities.Employee;
import de.tjjf.Infrastructure.persistence.entities.Flight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class CreateMModelsTest {

    //For quick and easy initialising of Airplane
    int amountOfEconomySeats = 50;
    int amountOfBusinessSeats = 25;
    int amountOfFirstClassSeats = 15;

    @Test
    public void testCreatingMAirline(){
        Date d = new Date();
        String name = "TestAirline";
        String headQuarters = "TestHeadquarters";

        MAirline mAirline = new MAirline(name , d, headQuarters);

        assertEquals(mAirline.getName(), name);
        assertEquals(mAirline.getHeadQuarters(), headQuarters);
        assertEquals(mAirline.getFoundationYear(), d);

    }


    @Test
    public void testCreatingMAirplane(){
        int serialNum = 1234;
        String manufacturer = "TestManufacturer";
        String model = "TestModel";
        int amountOfEconomySeats = 50;
        int amountOfBusinessSeats = 25;
        int amountOfFirstClassSeats = 15;
        MAirline mAirline = new MAirline();
        boolean isOperable = true;
        int maxWeightOfLuggage = 25;

        MAirplane mAirplane = new MAirplane(serialNum, manufacturer, model, amountOfEconomySeats, amountOfBusinessSeats, amountOfFirstClassSeats,  mAirline, isOperable, maxWeightOfLuggage);

        assertEquals(mAirplane.getSerialNum(), serialNum);
        assertEquals(mAirplane.getManufacturer(), manufacturer);
        assertEquals(mAirplane.getModel(), model);
        assertEquals(mAirplane.getAmountOfEconomySeats(), amountOfEconomySeats);
        assertEquals(mAirplane.getAmountOfBusinessSeats(), amountOfBusinessSeats);
        assertEquals(mAirplane.getAmountOfFirstClassSeats(), amountOfFirstClassSeats);
        assertEquals(mAirplane.getBelongingAirline(), mAirline);
        if(isOperable){
            assertTrue(mAirplane.isOperatable());
        }else{
            assertFalse(mAirplane.isOperatable());
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
    public void testCreatingFlight(){
        long flightNum = 1234;
        MAirplane mAirplane = new MAirplane(amountOfEconomySeats, amountOfBusinessSeats, amountOfFirstClassSeats);
        Date departureDateTime = new Date();
        MAirport departureAirport = new MAirport();
        Date arrivalDateTime = new Date();
        MAirport arrivalAirport = new MAirport();
        Date boardingTime = new Date();
        MFlight.FlyStatus flyStatus = MFlight.FlyStatus.landed;
        int duration = 123;
        MEmployee pilot = new MEmployee();
        MEmployee copilot = new MEmployee();

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
        MPerson person = new MPerson();
        MAirplane mAirplane = new MAirplane(amountOfEconomySeats, amountOfBusinessSeats, amountOfFirstClassSeats);
        MFlight mFlight = new MFlight(mAirplane);
        Date dateTimeOfBooking = new Date();
        int totalPrice = 300;
        int seatNum = 15;
        MTicket.SeatingClass seatingClass = MTicket.SeatingClass.Economy;
        MTicket.BookingStatus ticketStatus = MTicket.BookingStatus.Paid;
        int weightOfLuggage = 20;

        MTicket mTicket = new MTicket(ticketId, person, mFlight, dateTimeOfBooking, totalPrice, seatNum, seatingClass, ticketStatus, weightOfLuggage);

        assertEquals(mTicket.getTicketId(), ticketId);
        assertEquals(mTicket.getPerson(), person);
        assertEquals(mTicket.getFlight(), mFlight);
        assertEquals(mTicket.getDateTimeOfBooking(), dateTimeOfBooking);
        assertEquals(mTicket.getTotalPrice(), totalPrice);
        assertEquals(mTicket.getSeatNum(), seatNum);
        assertEquals(mTicket.getSeatingClass(), seatingClass);
        assertEquals(mTicket.getTicketStatus(), ticketStatus);
        assertEquals(mTicket.getWeightOfLuggage(), weightOfLuggage);
    }


}
