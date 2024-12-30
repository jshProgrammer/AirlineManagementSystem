package de.tjjf.LogicTests;

import de.tjjf.Domain.UseCases.CancelCompleteFlightUseCase;
import de.tjjf.Domain.UseCases.CancelTicketUseCase;
import de.tjjf.Domain.models.*;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

//should work 23.12.24
public class CancellationTest {
    MPerson person = new MPerson(1, "Jasmin", "", "Wander", new Date(), "+4915112345678", new MAddress(null, 1234, 1234, null, null), "airlinemanagementtestmail@gmail.com", null);
    MPerson person2 = new MPerson(2, "Tom", "", "Knoblach", new Date(), "+4915112345678", new MAddress(null, 1234, 1234, null, null), "airlinemanagementtestmail@gmail.com", null);
    MAirplane airplane = new MAirplane(123456, null,  null, 100, 50, 25, null, true, 40000);
    MFlight flight = new MFlight(123456, airplane, new Date(2024, 12, 31), null, new Date(2025, 1, 1), null, new Date(2024, 21, 31), MFlight.FlightStatus.scheduled, 1000, null, null);
    MTicket ticket = new MTicket(1, person, flight, new Date(2024, 11,18), 200, 1, MTicket.SeatingClass.Economy, MTicket.TicketStatus.unpaid, 12 );
    MTicket ticket2 = new MTicket(2, person2, flight, new Date(2024, 11,18), 200, 1, MTicket.SeatingClass.Economy, MTicket.TicketStatus.unpaid, 12 );


    @Test
    public void testCancellationFromAirlineSide() {
        CancelCompleteFlightUseCase.cancelFlight(flight);
        assertEquals(flight.getTickets().size(), 2);
        assertEquals(flight.getStatus(), MFlight.FlightStatus.canceled);
        for (MTicket ticket : flight.getTickets()){
            assertEquals(ticket.getTicketStatus(), MTicket.TicketStatus.canceled);
        }
    }

    @Test
    public void testCancellationFromCustomerSide() {
        CancelTicketUseCase.cancelTicket(person2, 123456);
        assertEquals(flight.getTickets().size(), 1);
        assertEquals(ticket.getTicketStatus(), MTicket.TicketStatus.unpaid);
        assertEquals(ticket2.getTicketStatus(), MTicket.TicketStatus.canceled);
    }
}
