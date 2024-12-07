package de.tjjf.Domain.UseCases;

import de.tjjf.Domain.models.MFlight;

import java.util.ArrayList;
import java.util.List;

public class ShowAlternativeFlightsUseCase {
    //TODO
    public static List<MFlight> showAlternativeFlights(int flightNum) {
        List<MFlight> alternativeFlights = new ArrayList<>();

        // Flight originalFlight = ;

        //TODO: hier müsste ich ja auf Datenbank zugreifen?!
        List<MFlight> allFlights = new ArrayList<>();

        // search for flights that have the same destination and departure
        for(MFlight alternativeFlight : allFlights) {

        }

        return  alternativeFlights;
    }
}
