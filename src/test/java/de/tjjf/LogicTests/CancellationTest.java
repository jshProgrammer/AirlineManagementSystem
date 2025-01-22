package de.tjjf.LogicTests;

import de.tjjf.Infrastructure.persistence.adapter.MClientRepositoryImpl;
import de.tjjf.Infrastructure.persistence.adapter.MEmployeeRepositoryImpl;
import de.tjjf.Infrastructure.persistence.adapter.MTicketRepositoryImpl;
import de.tjjf.Domain.UseCases.CancelTicketUseCase;
import de.tjjf.Domain.models.*;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CancellationTest {
    DomainClient person = new DomainClient(1, "Jasmin", "", "Wander", new Date(), "+4915112345678", new DomainAddress(null, 1234, 1234, null, null), "airlinemanagementtestmail@gmail.com", false);
    DomainClient person2 = new DomainClient(2, "Tom", "", "Knoblach", new Date(), "+4915112345678", new DomainAddress(null, 1234, 1234, null, null), "airlinemanagementtestmail@gmail.com", false);
    DomainAirplane airplane = new DomainAirplane(123456, "Default",  "Default", 100, 50, 25, null, true, 40000);
    DomainFlight flight = new DomainFlight(123456, airplane, new Date(2024, 12, 31), null, new Date(2025, 1, 1), null, new Date(2024, 21, 31), DomainFlight.FlightStatus.scheduled, 1000, null, null);
    DomainTicket ticket = new DomainTicket(1, person, flight, new Date(2024, 11,18), 200, 1, DomainTicket.SeatingClass.Economy, DomainTicket.TicketStatus.unpaid, 12 );
    DomainTicket ticket2 = new DomainTicket(2, person2, flight, new Date(2024, 11,18), 200, 1, DomainTicket.SeatingClass.Economy, DomainTicket.TicketStatus.unpaid, 12 );


    @Test
    public void testCancellationFromAirlineSide() {
        flight.setStatus(DomainFlight.FlightStatus.canceled);
        assertEquals(flight.getTickets().size(), 2);
        assertEquals(flight.getStatus(), DomainFlight.FlightStatus.canceled);
    }

    @Test
    public void testCancellationFromCustomerSide() {
        new CancelTicketUseCase(new MTicketRepositoryImpl(), new MClientRepositoryImpl(), new MEmployeeRepositoryImpl()).cancelTicket(person2, 123456,false);
        assertEquals(flight.getTickets().size(), 1);
        assertEquals(ticket.getTicketStatus(), DomainTicket.TicketStatus.unpaid);
        assertEquals(ticket2.getTicketStatus(), DomainTicket.TicketStatus.canceled);
    }
}
