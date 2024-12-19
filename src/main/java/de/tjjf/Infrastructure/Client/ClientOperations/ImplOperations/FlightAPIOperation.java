package de.tjjf.Infrastructure.Client.ClientOperations.ImplOperations;

import de.tjjf.Infrastructure.Client.ClientOperations.AbstractOperations.AbstractAPIOperation;
import de.tjjf.Infrastructure.api.InputModels.APIAirlineInput;
import de.tjjf.Infrastructure.api.InputModels.APIFlightInput;
import de.tjjf.Infrastructure.api.models.APIFlight;

public class FlightAPIOperation extends AbstractAPIOperation {

    private String transformToQuery(APIFlightInput apiFlightInput, String commandName) {
        //TODO: wie enums in query einfügen?!
        String query = """
        {
            "query": "mutation {
                %s (flight: {
                    flightNum: %d,
                    airplaneSerialNum: %d,
                    departureDateTime: \\"%s\\",
                    departureAirportCode: \\"%s\\",
                    arrivalDateTime: \\"%s\\",
                    arrivalAirportCode: \\"%s\\",
                    boardingTime: \\"%s\\",
                    status: \\"%s\\",
                    duration: %d,
                    pilotId: %d,
                    copilotId: %d
                })
            }"
        }
        """.formatted(
                commandName,
                apiFlightInput.getFlightNum(),
                apiFlightInput.getAirplaneSerialNum(),
                apiFlightInput.getDepartureDateTime(),
                apiFlightInput.getDepartureAirport(),
                apiFlightInput.getArrivalDateTime(),
                apiFlightInput.getArrivalAirport(),
                apiFlightInput.getBoardingTime(),
                apiFlightInput.getStatus(),
                apiFlightInput.getDuration(),
                apiFlightInput.getPilot(),
                apiFlightInput.getCopilot()
        );

        return query;

    }

    //TODO: hier vermutlich noch Probleme wegen Datetime statt Date
    public void createFlight(APIFlightInput apiFlightInput) {
        execute(transformToQuery(apiFlightInput, "createFlight"), "createFlight", APIFlight.class);
    }

    //TODO: hier noch weiter machen
    public void updateFlight(APIFlightInput apiFlightInput) {

    }

    //TODO: reicht hier nicht auch nur flightnum?!
    public void cancelFlight(APIFlightInput apiFlightInput) {

    }

   public APIFlight readFlightByFlightNum(int flightNum){
        return null;
   }
}
