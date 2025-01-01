package de.tjjf.Infrastructure.Client.ClientOperations.APIOperations;

import de.tjjf.Infrastructure.api.DateParser;
import de.tjjf.Infrastructure.api.InputModels.APIFlightInput;
import de.tjjf.Infrastructure.api.models.APIFlight;

public class FlightAPIOperation extends AbstractAPIOperation {

    private String transformToQuery(APIFlightInput apiFlightInput, Long flightNum, String commandName, boolean hasResult) {
        //TODO: wie enums in query einfügen?!
        System.out.println("TEST.X " + DateParser.getDateTimeFromDBInRFC3339(apiFlightInput.getDepartureDateTime()));
        String query = """
        {
            "query": "mutation {
                %s (%s flight: {
                    airplaneSerialNum: %d,
                    departureDateTime: \\"%s\\",
                    departureAirportCode: \\"%s\\",
                    arrivalDateTime: \\"%s\\",
                    arrivalAirportCode: \\"%s\\",
                    boardingTime: \\"%s\\",
                    status: %s,
                    duration: %d,
                    pilotId: %d,
                    copilotId: %d
                }) %s
            }"
        }
        """.formatted(
                commandName,
                //TODO: brauchen wir nicht getDateTime...
                (flightNum == 0L) ? "" : "flightNum: %d,".formatted(flightNum),
                apiFlightInput.getAirplaneSerialNum(),
                DateParser.getDateTimeFromDBInRFC3339(apiFlightInput.getDepartureDateTime()),
                apiFlightInput.getDepartureAirportCode(),
                DateParser.getDateTimeFromDBInRFC3339(apiFlightInput.getArrivalDateTime()),
                apiFlightInput.getArrivalAirportCode(),
                DateParser.getDateTimeFromDBInRFC3339(apiFlightInput.getBoardingTime()),
                apiFlightInput.getStatus(),
                apiFlightInput.getDuration(),
                apiFlightInput.getPilotId(),
                apiFlightInput.getCopilotId(),
                (hasResult) ? "{flightNum airplaneSerialNum departureDateTime departureAirportCode arrivalDateTime arrivalAirportCode boardingTime status duration pilotId copilotId}" : ""
        );

        return query;

    }

    //TODO: hier vermutlich noch Probleme wegen Datetime statt Date
    public APIFlight createFlight(APIFlightInput apiFlightInput) {
        return execute(transformToQuery(apiFlightInput, 0L, "createFlight", true), "createFlight", APIFlight.class);
    }

    public void updateFlight(long flightNum, APIFlightInput apiFlightInput) {
        execute(transformToQuery(apiFlightInput, flightNum, "updateFlight", false), "updateFlight", APIFlight.class);
    }

    public void cancelFlight(long flightNum) {
        String query = """
        {
            "query": "mutation {
                cancelFlight(flightNum: %d)
            }"
        }
        """.formatted(flightNum);

        execute(query, "cancelFlight", APIFlight.class);
    }

   public APIFlight readFlightByFlightNum(long flightNum){
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