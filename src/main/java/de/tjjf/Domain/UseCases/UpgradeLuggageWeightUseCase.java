package de.tjjf.Domain.UseCases;

import de.tjjf.Domain.models.MTicket;
/*
public class UpgradeLuggageWeightUseCase {
    public void upgradeLuggageWeight(MTicket ticket, int newWeight) throws IllegalArgumentException {
        //Use only 25% of maximum luggage weight for luggage upgrade, the rest is reserved for standard bookings
        //Simplification: Added weight cannot be removed from booking anymore
        if((ticket.getFlight().getAirplane().getMaxWeightOfLuggage() * 0.25) >= ticket.getFlight().getCurrentUpgradeLuggageWeight() + newWeight ){

            ticket.weightOfLuggage = this.weightOfLuggage + newWeight;
            ticket.getFlight().addCurrentUpgradeLuggageWeight(ticket.getFlight().getCurrentUpgradeLuggageWeight() + newWeight);

            //Increasing the total price in addition to be able to bring more luggage
            ticket.setTotalPrice(ticket.getTotalPrice() + (newWeight * 5));
        }else{
            throw new IllegalArgumentException("Not enough available luggage weight. Only " + (ticket.getFlight().getAirplane().getMaxWeightOfLuggage() * 0.25 - ticket.getFlight().getCurrentUpgradeLuggageWeight()) + "kg upgradeable luggageweight available");
        }

    }
}*/
