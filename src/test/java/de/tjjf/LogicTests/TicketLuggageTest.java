package de.tjjf.LogicTests;

import de.tjjf.Domain.models.*;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

//should work 23.12.24
public class TicketLuggageTest {
    MAirplane mAirplane = new MAirplane(123123, null, null, 30, 15 , 15, null, true, 1000);
    MFlight mFlight = new MFlight(999999, mAirplane, null, null, null, null,null,null,0,null,null);

    @Test
    public void acceptableLuggageIncreasePriceTest(){
        int weightOfLuggage = 12;
        int totalPrice = 200;
        MPerson mPerson = new MPerson(1, "Max", null,null  , new Date(), "01231231", new MAddress("street", 1, 92341, "Berlin", "Germany"), "test@test.de", "passwd", null);
        MTicket ticket = new MTicket(1, mPerson , mFlight, new Date(), totalPrice, 1, MTicket.SeatingClass.Economy, MTicket.TicketStatus.unpaid, weightOfLuggage );

        //increase price accordingly to the weight of Luggage -> see MTicket setLuggageWeight()
        totalPrice = totalPrice + (weightOfLuggage * 4);

        assertEquals(ticket.getFlight().getCurrentInitialLuggageWeight(), weightOfLuggage);
        assertEquals(ticket.getTotalPrice(), totalPrice);
    }

    @Test
    public void tooMuchInitialLuggageWeightTest(){
        assertThrows(IllegalArgumentException.class, () -> {
            new MTicket(1, null, mFlight, new Date(), 200, 1, MTicket.SeatingClass.Economy, MTicket.TicketStatus.unpaid, 50 );
        });
    }

    @Test
    public void successfulLuggageUpgradeTest(){
        int weightOfLuggage = 12;
        int totalPrice = 200;
        MTicket ticket = new MTicket(1, null, mFlight, new Date(), totalPrice, 1, MTicket.SeatingClass.Economy, MTicket.TicketStatus.unpaid, weightOfLuggage);
        int newWeight = 5;

        totalPrice = totalPrice + (newWeight * 5);
        ticket.upgradeLuggageWeight(newWeight);

        assertEquals(ticket.getFlight().getCurrentUpgradeLuggageWeight(), 5);
        assertEquals(ticket.getFlight().getCurrentInitialLuggageWeight(), 12);
        assertEquals(ticket.getWeightOfLuggage(), newWeight + weightOfLuggage);
        assertEquals(ticket.getTotalPrice(), totalPrice);
    }

    @Test
    public void unsuccessfulLuggageUpgradeTest(){
        int weightOfLuggage = 12;
        int totalPrice = 200;
        MTicket ticket = new MTicket(1, null, mFlight, new Date(), totalPrice, 1, MTicket.SeatingClass.Economy, MTicket.TicketStatus.unpaid, weightOfLuggage);
        int newWeight = 50;

        assertThrows(IllegalArgumentException.class, () -> {
           ticket.upgradeLuggageWeight(newWeight);
        });
    }
}
