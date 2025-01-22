package de.tjjf.LogicTests;


import de.tjjf.Domain.Exceptions.NoSeatsAvailableException;
import de.tjjf.Domain.models.*;
import org.junit.jupiter.api.Test;


import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class SeatingTest {
    DomainPerson person = new DomainPerson(1, "Jasmin", "", "Wander", new Date(), "+4915112345678", new DomainAddress(null, 1, 34534,null, null), "airlinemanagementtestmail@gmail.com", null);

    @Test
    public void successfulSeatingClassUpgradeTest(){
        DomainAirplane airplane = new DomainAirplane(123, null, null, 30, 15, 15, null, true, 1000);
        DomainFlight flight = new DomainFlight(123456, airplane, new Date(), null, new Date(), null, new Date(), DomainFlight.FlightStatus.scheduled, 1000, null, null);

        DomainTicket ticket = new DomainTicket(1, person, flight, new Date(), 200, 1, DomainTicket.SeatingClass.Economy, DomainTicket.TicketStatus.unpaid, 1 );

        ticket.upgradeSeatingClass(DomainTicket.SeatingClass.Business);
        assertEquals(ticket.getSeatingClass(), DomainTicket.SeatingClass.Business);

        ticket.upgradeSeatingClass(DomainTicket.SeatingClass.First);
        assertEquals(ticket.getSeatingClass(), DomainTicket.SeatingClass.First);

    }

    @Test
    public void unsuccessfulSeatingClassUpgradeTest(){
        DomainAirplane airplane2 = new DomainAirplane(123, null, null, 1, 1, 1, null, true, 1000);
        DomainFlight flight = new DomainFlight(123456, airplane2, new Date(), null, new Date(), null, new Date(), DomainFlight.FlightStatus.scheduled, 1000, null, null);

        DomainTicket ticket = new DomainTicket(1, person, flight, new Date(), 200, 1, DomainTicket.SeatingClass.Economy, DomainTicket.TicketStatus.unpaid, 1);
        assertThrows(NoSeatsAvailableException.class, () -> {
                new DomainTicket(2, person, flight, new Date(), 200, 1, DomainTicket.SeatingClass.Economy, DomainTicket.TicketStatus.unpaid, 0 );
        });

        ticket.upgradeSeatingClass(DomainTicket.SeatingClass.Business);
        assertThrows(NoSeatsAvailableException.class, () -> {
            new DomainTicket(2, person, flight, new Date(), 200, 1, DomainTicket.SeatingClass.Business, DomainTicket.TicketStatus.unpaid, 0 );
        });

        ticket.upgradeSeatingClass(DomainTicket.SeatingClass.First);
        assertThrows(NoSeatsAvailableException.class, () -> {
            new DomainTicket(2, person, flight, new Date(), 200, 1, DomainTicket.SeatingClass.First, DomainTicket.TicketStatus.unpaid, 0 );
        });



    }
}
