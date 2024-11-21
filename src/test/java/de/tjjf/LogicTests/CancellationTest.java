package de.tjjf.LogicTests;

import de.tjjf.Domain.models.*;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CancellationTest {
    MPerson person = new MPerson(1, "Jasmin", "", "Wander", new Date(2004, 10, 14), "23233", new MAdress("Teststraße", 1, 12345, "Teststadt", "Deutschland"), "airlinemanagementtestmail@gmail.com", "fkgk rdof hhkj arwc");
    MPerson person2 = new MPerson(2, "Tom", "", "Knoblach", new Date(2004, 10, 14), "23233", new MAdress("Teststraße", 1, 12345, "Teststadt", "Deutschland"), "airlinemanagementtestmail@gmail.com", "fkgk rdof hhkj arwc");
    MAirline airline = new MAirline("TestAirline", new Date(1990), "München", new MAdress("Teststraße", 1, 12345, "Teststadt", "Deutschland"), "016012345", "airlinemanagementtestmail@gmail.com");
    MAirplane airplane = new MAirplane(123, "Hersteller", "Boeing 5", 30, 15, 15, airline, true, 1000);
    MAirport depatureAirport = new MAirport("B12", "Frankturt Airport", "Germany", "Frankfurt", "UTC");
    MAirport arrivalAirport = new MAirport("ABC", "LA Airport", "USA", "LA", "UTC");
    MEmployee pilot = new MEmployee(2, 5000, "pilot", airline, new Date(2020));
    MEmployee copilot = new MEmployee(3, 4500, "copilot", airline, new Date(2021));
    MFlight flight = new MFlight(123456, airplane, new Date(2024, 12, 31), depatureAirport, new Date(2025, 1, 1), arrivalAirport, new Date(2024, 21, 31), MFlight.FlyStatus.scheduled, 1000, pilot, copilot);
    MTicket ticket = new MTicket(1, person, flight, new Date(2024, 11,18), 200, 1, MTicket.SeatingClass.Economy, MTicket.BookingStatus.Unpaid, 12 );
    MTicket ticket2 = new MTicket(2, person2, flight, new Date(2024, 11,18), 200, 1, MTicket.SeatingClass.Economy, MTicket.BookingStatus.Unpaid, 12 );


    @Test
    public void testCancellationFromAirlineSide() {
        flight.cancelFlight();
        assertEquals(flight.getTickets().size(), 2);
        assertEquals(flight.getStatus(), MFlight.FlyStatus.canceled);
        for (MTicket ticket3 : flight.getTickets()){
            assertEquals(ticket3.getTicketStatus(), MTicket.BookingStatus.Canceled);
        }
    }

    @Test
    public void testCancellationFromCustomerSide() {
        person2.cancelFlight(123456);
        assertEquals(flight.getTickets().size(), 1);
        assertEquals(ticket.getTicketStatus(), MTicket.BookingStatus.Unpaid);
        assertEquals(ticket2.getTicketStatus(), MTicket.BookingStatus.Canceled);
    }
}
