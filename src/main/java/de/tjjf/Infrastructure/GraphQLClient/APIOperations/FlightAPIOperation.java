package de.tjjf.Infrastructure.GraphQLClient.APIOperations;

import com.fasterxml.jackson.core.type.TypeReference;
import de.tjjf.Infrastructure.api.DateParser;
import de.tjjf.Infrastructure.api.InputModels.APIFlightInput;
import de.tjjf.Infrastructure.api.models.APIFlight;

import java.util.List;

public class FlightAPIOperation extends AbstractAPIOperation {

    private String transformToQuery(APIFlightInput apiFlightInput, Long flightNum, String commandName, boolean hasResult) {
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

   public List<APIFlight> getAllFlights(int pageNumber, int pageSize) {
       String query = """
            {
                "query": "{
                    getAllFlights(pageNumber: %d, pageSize: %d) {
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
            """.formatted(pageNumber, pageSize);

       return execute(query, "getAllFlights", new TypeReference<List<APIFlight>>(){});
   }
}