package de.tjjf.LogicTests;

import de.tjjf.Domain.models.*;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CancellationTest {
    MPerson person = new MPerson(1, "Jasmin", "", "Wander", new Date(2004, 10, 14), "23233", new MAddress("Teststraße", 1, 12345, "Teststadt", "Deutschland"), "airlinemanagementtestmail@gmail.com", "fkgk rdof hhkj arwc");
    MPerson person2 = new MPerson(2, "Tom", "", "Knoblach", new Date(2004, 10, 14), "23233", new MAddress("Teststraße", 1, 12345, "Teststadt", "Deutschland"), "airlinemanagementtestmail@gmail.com", "fkgk rdof hhkj arwc");
    MAirline airline = new MAirline("TestAirline", new Date(1990), "München", new MAddress("Teststraße", 1, 12345, "Teststadt", "Deutschland"), "016012345", "airlinemanagementtestmail@gmail.com");
    MAirplane airplane = new MAirplane(123, "Hersteller", "Boeing 5", 30, 15, 15, airline, true, 1000);
    MAirport depatureAirport = new MAirport("B12", "Frankturt Airport", "Germany", "Frankfurt", "UTC");
    MAirport arrivalAirport = new MAirport("ABC", "LA Airport", "USA", "LA", "UTC");
    MEmployee pilot = new MEmployee( 2, 5000, "pilot", airline, new Date(2020));
    MEmployee copilot = new MEmployee(3,"TET","","TED",new Date(2007,10,14), "27359824",new MAddress("TEST",23, 34533,"BErlin", "GER"), "tomknoblach@t-online.de", "skldjflks",200,"sf", airline, new Date(2024,10,13));
    MFlight flight = new MFlight(123456, airplane, new Date(2024, 12, 31), depatureAirport, new Date(2025, 1, 1), arrivalAirport, new Date(2024, 21, 31), MFlight.FlightStatus.scheduled, 1000, pilot, copilot);
    MTicket ticket = new MTicket(1, person, flight, new Date(2024, 11,18), 200, 1, MTicket.SeatingClass.Economy, MTicket.TicketStatus.unpaid, 12 );
    MTicket ticket2 = new MTicket(2, person2, flight, new Date(2024, 11,18), 200, 1, MTicket.SeatingClass.Economy, MTicket.TicketStatus.unpaid, 12 );


    @Test
    public void testCancellationFromAirlineSide() {
        flight.cancelFlight();
        assertEquals(flight.getTickets().size(), 2);
        assertEquals(flight.getStatus(), MFlight.FlightStatus.canceled);
        for (MTicket ticket3 : flight.getTickets()){
            assertEquals(ticket3.getTicketStatus(), MTicket.TicketStatus.canceled);
        }
    }

    @Test
    public void testCancellationFromCustomerSide() {
        person2.cancelFlight(123456);
        assertEquals(flight.getTickets().size(), 1);
        assertEquals(ticket.getTicketStatus(), MTicket.TicketStatus.unpaid);
        assertEquals(ticket2.getTicketStatus(), MTicket.TicketStatus.canceled);
    }
}
