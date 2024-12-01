package de.tjjf.LogicTests;


import de.tjjf.Domain.Exceptions.NoSeatsAvailableException;
import de.tjjf.Domain.models.*;
import org.junit.jupiter.api.Test;


import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class SeatingTest {
    MPerson person = new MPerson(1, "Jasmin", "", "Wander", new Date(2004, 10, 14), "23233", new MAddress("test", 1, 34534,"Berlin", "germany"), "jpfennig2403@gmail.com", "fkgk rdof hhkj arwc", null);
    MAirline airline = new MAirline("TestAirline", new Date(1990), "München", new MAddress("test", 1, 34534,"Berlin", "germany"), "0160123456", "testmail");
    MAirplane airplane = new MAirplane(123, "Hersteller", "Boeing 5", 30, 15, 15, airline, true, 1000);
    MAirport depatureAirport = new MAirport("B12", "Frankturt Airport", "Germany", "Frankfurt", "UTC");
    MAirport arrivalAirport = new MAirport("ABC", "LA Airport", "USA", "LA", "UTC");
    MEmployee pilot = new MEmployee( 2, "Finn", null,"Krappitz",new Date(2003, 06, 05), "48484848484",new MAddress("TEST",23, 34533,"BErlin", "GER"), "tomKnoblach@t-online.de", "testpasword", 200, "sf", airline, new Date(2024, 10, 13) );
    MEmployee copilot = new MEmployee(3,"Joshua","","Pfennig",new Date(2007,10,14), "27359824",new MAddress("TEST",23, 34533,"BErlin", "GER"), "tomknoblach@t-online.de", "skldjflks",200,"sf", airline, new Date(2024,10,13));
    MFlight flight = new MFlight(123456, airplane, new Date(2024, 12, 31), depatureAirport, new Date(2025, 1, 1), arrivalAirport, new Date(2024, 21, 31), MFlight.FlightStatus.scheduled, 1000, pilot, copilot);



    @Test
    public void testTicketAndLuggageCreation(){
        MTicket ticket = new MTicket(1, person, flight, new Date(2024, 11,18), 200, 1, MTicket.SeatingClass.Economy, MTicket.TicketStatus.unpaid, 12 );
        assertEquals(flight.getTickets().getFirst(), ticket);
        assertEquals(ticket.getFlight().getCurrentInitialLuggageWeight(), 12);
        assertEquals(ticket.getTotalPrice(), 248);

    }

    @Test
    public void tooMuchLuggageTest(){
        MTicket ticket = new MTicket(1, person, flight, new Date(2024, 11,18), 200, 1, MTicket.SeatingClass.Economy, MTicket.TicketStatus.unpaid, 50 );
        assertEquals(ticket.getFlight().getCurrentInitialLuggageWeight(), 0);
        //Wie boolean Rückgabetyp & Message abfragen?

    }

    @Test
    public void testLuggageUpgrade(){
        MTicket ticket = new MTicket(1, person, flight, new Date(2024, 11,18), 200, 1, MTicket.SeatingClass.Economy, MTicket.TicketStatus.unpaid, 12 );
        ticket.upgradeLuggageWeight(5);
        assertEquals(ticket.getFlight().getCurrentUpgradeLuggageWeight(), 5);
        assertEquals(ticket.getFlight().getCurrentInitialLuggageWeight(), 12);
        assertEquals(ticket.getWeightOfLuggage(), 17);

    }

    @Test
    public void testSeatingUpgrade(){
        MTicket ticket = new MTicket(1, person, flight, new Date(2024, 11,18), 200, 1, MTicket.SeatingClass.Economy, MTicket.TicketStatus.unpaid, 12 );
        ticket.upgradeSeatingClass(MTicket.SeatingClass.Business);
        assertEquals(ticket.getSeatingClass(), MTicket.SeatingClass.Business);
        ticket.upgradeSeatingClass(MTicket.SeatingClass.First);
        assertEquals(ticket.getSeatingClass(), MTicket.SeatingClass.First);

    }

    @Test
    public void noSeatsLeftTest(){
        MAirplane airplane2 = new MAirplane(123, "Hersteller", "Boeing 5", 1, 1, 1, airline, true, 1000);
        MFlight flight = new MFlight(123456, airplane2, new Date(2024, 12, 31), depatureAirport, new Date(2025, 1, 1), arrivalAirport, new Date(2024, 21, 31), MFlight.FlightStatus.scheduled, 1000, pilot, copilot);

        MTicket ticket = new MTicket(1, person, flight, new Date(2024, 11,18), 200, 1, MTicket.SeatingClass.Economy, MTicket.TicketStatus.unpaid, 12 );
        try{
            MTicket ticket2 = new MTicket(2, person, flight, new Date(2024, 11,18), 200, 1, MTicket.SeatingClass.Economy, MTicket.TicketStatus.unpaid, 12 );
            fail("NoSeatsLeftException expected");
        }
        catch(NoSeatsAvailableException e){

        }


    }
}
