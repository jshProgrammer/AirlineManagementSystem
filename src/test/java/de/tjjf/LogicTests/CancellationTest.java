package de.tjjf.LogicTests;

import de.tjjf.Adapter.DatabaseAdapter.MClientRepositoryImpl;
import de.tjjf.Adapter.DatabaseAdapter.MEmployeeRepositoryImpl;
import de.tjjf.Adapter.DatabaseAdapter.MTicketRepositoryImpl;
import de.tjjf.Domain.EmailSender;
import de.tjjf.Domain.UseCases.CancelCompleteFlightUseCase;
import de.tjjf.Domain.UseCases.CancelTicketUseCase;
import de.tjjf.Domain.models.*;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CancellationTest {
    MClient person = new MClient(1, "Jasmin", "", "Wander", new Date(), "+4915112345678", new MAddress(null, 1234, 1234, null, null), "airlinemanagementtestmail@gmail.com", false);
    MClient person2 = new MClient(2, "Tom", "", "Knoblach", new Date(), "+4915112345678", new MAddress(null, 1234, 1234, null, null), "airlinemanagementtestmail@gmail.com", false);
    MAirplane airplane = new MAirplane(123456, "Default",  "Default", 100, 50, 25, null, true, 40000);
    MFlight flight = new MFlight(123456, airplane, new Date(2024, 12, 31), null, new Date(2025, 1, 1), null, new Date(2024, 21, 31), MFlight.FlightStatus.scheduled, 1000, null, null);
    MTicket ticket = new MTicket(1, person, flight, new Date(2024, 11,18), 200, 1, MTicket.SeatingClass.Economy, MTicket.TicketStatus.unpaid, 12 );
    MTicket ticket2 = new MTicket(2, person2, flight, new Date(2024, 11,18), 200, 1, MTicket.SeatingClass.Economy, MTicket.TicketStatus.unpaid, 12 );


    @Test
    public void testCancellationFromAirlineSide() {
        flight.setStatus(MFlight.FlightStatus.canceled);
        assertEquals(flight.getTickets().size(), 2);
        assertEquals(flight.getStatus(), MFlight.FlightStatus.canceled);
    }

    @Test
    public void testCancellationFromCustomerSide() {
        new CancelTicketUseCase(new MTicketRepositoryImpl(), new MClientRepositoryImpl(), new MEmployeeRepositoryImpl()).cancelTicket(person2, 123456,false);
        assertEquals(flight.getTickets().size(), 1);
        assertEquals(ticket.getTicketStatus(), MTicket.TicketStatus.unpaid);
        assertEquals(ticket2.getTicketStatus(), MTicket.TicketStatus.canceled);
    }
}
