package de.tjjf.Infrastructure.Client.ClientOperations.APIOperations;

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

    public void updateFlight(APIFlightInput apiFlightInput) {
        execute(transformToQuery(apiFlightInput, "updateFlight"), "updateFlight", APIFlight.class);
    }

    public void cancelFlight(int flightNum) {
        String query = """
        {
            "query": "mutation {
                cancelFlight(flightNum: %d)
            }"
        }
        """.formatted(flightNum);

        execute(query, "cancelFlight", APIFlight.class);
    }

   public APIFlight readFlightByFlightNum(int flightNum){
        String query = """
                {
                    "query": "{
                        readFlightByFlightNum(flightNum: %d) {
                            flightNum
                            airplaneSerialNum
                            departureDateTime
                            departureAirportCode
                            arrivalDateTime
                            arrivalAirportCode
                            boardingTime
                            status
                            duration
                            pilotId
                            copilotId
                        }
                    }"
                }
                """.formatted(flightNum);

        return execute(query, "readFlightByFlightNum", APIFlight.class);
   }
}
