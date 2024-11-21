package de.tjjf.LogicTests;


import de.tjjf.Domain.Exceptions.NoSeatsLeftException;
import de.tjjf.Domain.models.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class SeatingTest {
    MPerson person = new MPerson(1, "Jasmin", "", "Wander", new Date(2004, 10, 14), "23233", "München", "jpfennig2403@gmail.com", "fkgk rdof hhkj arwc");
    MAirline airline = new MAirline("TestAirline", new Date(1990), "München");
    MAirplane airplane = new MAirplane(123, "Hersteller", "Boeing 5", 30, 15, 15, airline, true, 1000);
    MAirport depatureAirport = new MAirport("B12", "Frankturt Airport", "Germany", "Frankfurt", "UTC");
    MAirport arrivalAirport = new MAirport("ABC", "LA Airport", "USA", "LA", "UTC");
    MEmployee pilot = new MEmployee(2, 5000, "pilot", airline, new Date(2020));
    MEmployee copilot = new MEmployee(3, 4500, "copilot", airline, new Date(2021));
    MFlight flight = new MFlight(123456, airplane, new Date(2024, 12, 31), depatureAirport, new Date(2025, 1, 1), arrivalAirport, new Date(2024, 21, 31), MFlight.FlyStatus.scheduled, 1000, pilot, copilot);



    @Test
    public void testTicketAndLuggageCreation(){
        MTicket mTicket = new MTicket(1, person, flight, new Date(2024, 11,18), 200, 1, MTicket.SeatingClass.Economy, MTicket.BookingStatus.Unpaid, 12 );
        assertEquals(flight.getTickets().getFirst(), mTicket);
        assertEquals(mTicket.getFlight().getCurrentInitialLuggageWeight(), 12);
        assertEquals(mTicket.getTotalPrice(), 248);

    }

    @Test
    public void tooMuchLuggageTest(){
        MTicket mTicket = new MTicket(1, person, flight, new Date(2024, 11,18), 200, 1, MTicket.SeatingClass.Economy, MTicket.BookingStatus.Unpaid, 50 );
        assertEquals(mTicket.getFlight().getCurrentInitialLuggageWeight(), 0);
        //Wie boolean Rückgabetyp & Message abfragen?

    }

    @Test
    public void testLuggageUpgrade(){
        MTicket mTicket = new MTicket(1, person, flight, new Date(2024, 11,18), 200, 1, MTicket.SeatingClass.Economy, MTicket.BookingStatus.Unpaid, 12 );
        mTicket.upgradeLuggageWeight(5);
        assertEquals(mTicket.getFlight().getCurrentUpgradeLuggageWeight(), 5);
        assertEquals(mTicket.getFlight().getCurrentInitialLuggageWeight(), 12);
        assertEquals(mTicket.getWeightOfLuggage(), 17);

    }

    @Test
    public void testSeatingUpgrade(){
        MTicket mTicket = new MTicket(1, person, flight, new Date(2024, 11,18), 200, 1, MTicket.SeatingClass.Economy, MTicket.BookingStatus.Unpaid, 12 );
        mTicket.upgradeSeatingClass(MTicket.SeatingClass.Business);
        assertEquals(mTicket.getSeatingClass(), MTicket.SeatingClass.Business);
        mTicket.upgradeSeatingClass(MTicket.SeatingClass.First);
        assertEquals(mTicket.getSeatingClass(), MTicket.SeatingClass.First);

    }

    @Test
    public void noSeatsLeftTest(){
        MAirplane airplane2 = new MAirplane(123, "Hersteller", "Boeing 5", 1, 1, 1, airline, true, 1000);
        MFlight flight = new MFlight(123456, airplane2, new Date(2024, 12, 31), depatureAirport, new Date(2025, 1, 1), arrivalAirport, new Date(2024, 21, 31), MFlight.FlyStatus.scheduled, 1000, pilot, copilot);

        MTicket mTicket = new MTicket(1, person, flight, new Date(2024, 11,18), 200, 1, MTicket.SeatingClass.Economy, MTicket.BookingStatus.Unpaid, 12 );
        try{
            MTicket mTicket2 = new MTicket(2, person, flight, new Date(2024, 11,18), 200, 1, MTicket.SeatingClass.Economy, MTicket.BookingStatus.Unpaid, 12 );
            fail("NoSeatsLeftException expected");
        }
        catch(NoSeatsLeftException e){

        }


    }
}
