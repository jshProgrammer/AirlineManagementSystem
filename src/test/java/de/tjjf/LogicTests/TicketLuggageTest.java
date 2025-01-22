package de.tjjf.LogicTests;

import de.tjjf.Domain.models.*;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

//should work 23.12.24
public class TicketLuggageTest {
    DomainAirplane mAirplane = new DomainAirplane(123123, null, null, 30, 15 , 15, null, true, 1000);
    DomainFlight mFlight = new DomainFlight(999999, mAirplane, null, null, null, null,null,null,0,null,null);
    DomainPerson mPerson = new DomainPerson(1, "Max", null,null  , new Date(), "01231231", new DomainAddress("street", 1, 92341, "Berlin", "Germany"), "airlinemanagementtestmail@gmail.com", null);

    @Test
    public void acceptableLuggageIncreasePriceTest(){
        int weightOfLuggage = 12;
        int totalPrice = 200;

        DomainTicket ticket = new DomainTicket(1, mPerson , mFlight, new Date(), totalPrice, 1, DomainTicket.SeatingClass.Economy, DomainTicket.TicketStatus.unpaid, weightOfLuggage );

        //increase price accordingly to the weight of Luggage -> see MTicket setLuggageWeight()
        totalPrice = totalPrice + (weightOfLuggage * 4);

        assertEquals(ticket.getFlight().getCurrentInitialLuggageWeight(), weightOfLuggage);
        assertEquals(ticket.getTotalPrice(), totalPrice);
    }

    @Test
    public void tooMuchInitialLuggageWeightTest(){
        assertThrows(IllegalArgumentException.class, () -> {
            new DomainTicket(1, mPerson, mFlight, new Date(), 200, 1, DomainTicket.SeatingClass.Economy, DomainTicket.TicketStatus.unpaid, 50 );
        });
    }

    @Test
    public void successfulLuggageUpgradeTest(){
        int weightOfLuggage = 12;
        int totalPrice = 200;
        DomainTicket ticket = new DomainTicket(1, mPerson, mFlight, new Date(), totalPrice, 1, DomainTicket.SeatingClass.Economy, DomainTicket.TicketStatus.unpaid, weightOfLuggage);
        int newWeight = 5;

        //Initial luggage increasing the price
        totalPrice = totalPrice + (weightOfLuggage * 4);
        //Additional luggage increasing the price
        totalPrice = totalPrice + (newWeight * 5);
        ticket.upgradeLuggageWeight(newWeight);

        assertEquals(newWeight , ticket.getFlight().getCurrentUpgradeLuggageWeight());
        assertEquals(weightOfLuggage, ticket.getFlight().getCurrentInitialLuggageWeight());
        assertEquals(newWeight + weightOfLuggage, ticket.getWeightOfLuggage() );
        assertEquals(totalPrice, ticket.getTotalPrice());
    }

    @Test
    public void unsuccessfulLuggageUpgradeTest(){
        int weightOfLuggage = 12;
        int totalPrice = 200;
        DomainTicket ticket = new DomainTicket(1, mPerson, mFlight, new Date(), totalPrice, 1, DomainTicket.SeatingClass.Economy, DomainTicket.TicketStatus.unpaid, weightOfLuggage);
        int newWeight = 1000;

        assertThrows(IllegalArgumentException.class, () -> {
           ticket.upgradeLuggageWeight(newWeight);
        });
    }
}
