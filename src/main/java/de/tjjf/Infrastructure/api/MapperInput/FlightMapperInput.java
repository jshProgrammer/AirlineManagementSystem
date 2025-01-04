package de.tjjf.Infrastructure.api.MapperInput;

import de.tjjf.Infrastructure.api.InputModels.APIFlightInput;
import de.tjjf.Infrastructure.api.models.APIFlight;

public class FlightMapperInput {
    public APIFlightInput toClient(APIFlight flight){
        return new APIFlightInput(
                flight.getAirplaneSerialNum(),
                flight.getDepartureDateTime(),
                flight.getDepartureAirportCode(),
                flight.getArrivalDateTime(),
                flight.getArrivalAirportCode(),
                flight.getBoardingTime(),
                APIFlightInput.FlightStatus.valueOf(flight.getStatus().name()),
                flight.getDuration(),
                flight.getPilotId(),
                flight.getCopilotId()
        );
    }

    public APIFlight toDomain(Long flightNum, APIFlightInput flight){
        return new APIFlight(
                flightNum,
                flight.getAirplaneSerialNum(),
                flight.getDepartureDateTime(),
                flight.getDepartureAirportCode(),
                flight.getArrivalDateTime(),
                flight.getArrivalAirportCode(),
                flight.getBoardingTime(),
                APIFlight.FlightStatus.valueOf(flight.getStatus().name()),
                flight.getDuration(),
                flight.getPilotId(),
                flight.getCopilotId()
        );
    }
}