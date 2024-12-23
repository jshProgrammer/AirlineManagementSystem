package de.tjjf.LogicTests;


import de.tjjf.Domain.Exceptions.NoSeatsAvailableException;
import de.tjjf.Domain.models.*;
import org.junit.jupiter.api.Test;


import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class SeatingTest {
    MPerson person = new MPerson(1, "Jasmin", "", "Wander", new Date(), "+4915112345678", new MAddress(null, 1, 34534,null, null), "jpfennig2403@gmail.com", "fkgk rdof hhkj arwc", null);

    @Test
    public void successfulSeatingClassUpgradeTest(){
        MAirplane airplane = new MAirplane(123, null, null, 30, 15, 15, null, true, 1000);
        MFlight flight = new MFlight(123456, airplane, new Date(), null, new Date(), null, new Date(), MFlight.FlightStatus.scheduled, 1000, null, null);

        MTicket ticket = new MTicket(1, person, flight, new Date(), 200, 1, MTicket.SeatingClass.Economy, MTicket.TicketStatus.unpaid, 1 );

        ticket.upgradeSeatingClass(MTicket.SeatingClass.Business);
        assertEquals(ticket.getSeatingClass(), MTicket.SeatingClass.Business);

        ticket.upgradeSeatingClass(MTicket.SeatingClass.First);
        assertEquals(ticket.getSeatingClass(), MTicket.SeatingClass.First);

    }

    @Test
    public void unsuccessfulSeatingClassUpgradeTest(){
        MAirplane airplane2 = new MAirplane(123, null, null, 1, 1, 1, null, true, 1000);
        MFlight flight = new MFlight(123456, airplane2, new Date(), null, new Date(), null, new Date(), MFlight.FlightStatus.scheduled, 1000, null, null);

        MTicket ticket = new MTicket(1, person, flight, new Date(), 200, 1, MTicket.SeatingClass.Economy, MTicket.TicketStatus.unpaid, 1);
        assertThrows(NoSeatsAvailableException.class, () -> {
                new MTicket(2, person, flight, new Date(), 200, 1, MTicket.SeatingClass.Economy, MTicket.TicketStatus.unpaid, 0 );
        });

        ticket.upgradeSeatingClass(MTicket.SeatingClass.Business);
        assertThrows(NoSeatsAvailableException.class, () -> {
            new MTicket(2, person, flight, new Date(), 200, 1, MTicket.SeatingClass.Business, MTicket.TicketStatus.unpaid, 0 );
        });

        ticket.upgradeSeatingClass(MTicket.SeatingClass.First);
        assertThrows(NoSeatsAvailableException.class, () -> {
            new MTicket(2, person, flight, new Date(), 200, 1, MTicket.SeatingClass.First, MTicket.TicketStatus.unpaid, 0 );
        });



    }
}
