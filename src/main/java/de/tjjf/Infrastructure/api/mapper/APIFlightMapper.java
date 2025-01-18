package de.tjjf.Infrastructure.api.mapper;

import de.tjjf.Domain.models.MFlight;
import de.tjjf.Infrastructure.api.DateParser;
import de.tjjf.Infrastructure.api.models.APIFlight;
import de.tjjf.Adapter.APIAdapter.AirplanePortImpl;
import de.tjjf.Adapter.APIAdapter.AirportPortImpl;
import de.tjjf.Adapter.APIAdapter.EmployeePortImpl;

public class APIFlightMapper extends AbstractAPIMapper<APIFlight, MFlight> {
    @Override
    public APIFlight toAPIEntity(MFlight mFlight){
        return new APIFlight(
                mFlight.getFlightNum(),
                mFlight.getAirplane().getSerialNum(),
                mFlight.getDepartureDateTime().toString(),
                mFlight.getDepartureAirport().getCode(),
                mFlight.getArrivalDateTime().toString(),
                mFlight.getArrivalAirport().getCode(),
                mFlight.getBoardingTime().toString(),
                APIFlight.FlightStatus.valueOf(mFlight.getStatus().name()),
                mFlight.getDuration(),
                mFlight.getPilot().getPersonId(),
                mFlight.getCopilot().getPersonId()
        );
    }

    @Override
    public MFlight toDomainEntity(APIFlight apiFlight){
        return new MFlight(
                apiFlight.getFlightNum(),
                new AirplanePortImpl().readAirplaneBySerialNum(apiFlight.getAirplaneSerialNum()),
                DateParser.getDateTimeFromRFC3339(apiFlight.getDepartureDateTime()),
                new AirportPortImpl().readAirportByCode(apiFlight.getDepartureAirportCode()),
                DateParser.getDateTimeFromRFC3339(apiFlight.getArrivalDateTime()),
                new AirportPortImpl().readAirportByCode(apiFlight.getArrivalAirportCode()),
                DateParser.getDateTimeFromRFC3339(apiFlight.getBoardingTime()),
                MFlight.FlightStatus.valueOf(apiFlight.getStatus().name()),
                apiFlight.getDuration(),
                new EmployeePortImpl().readEmployeeById(apiFlight.getPilotId()),
                new EmployeePortImpl().readEmployeeById(apiFlight.getCopilotId())
        );
    }
}
