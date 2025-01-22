package de.tjjf.Infrastructure.api.mapper;

import de.tjjf.Domain.models.DomainFlight;
import de.tjjf.Infrastructure.api.DateParser;
import de.tjjf.Infrastructure.api.models.APIFlight;
import de.tjjf.Infrastructure.api.adapter.AirplanePortImpl;
import de.tjjf.Infrastructure.api.adapter.AirportPortImpl;
import de.tjjf.Infrastructure.api.adapter.EmployeePortImpl;

public class APIFlightMapper extends AbstractAPIMapper<APIFlight, DomainFlight> {
    @Override
    public APIFlight toAPIEntity(DomainFlight mFlight){
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
    public DomainFlight toDomainEntity(APIFlight apiFlight){
        return new DomainFlight(
                apiFlight.getFlightNum(),
                new AirplanePortImpl().readAirplaneBySerialNum(apiFlight.getAirplaneSerialNum()),
                DateParser.getDateTimeFromRFC3339(apiFlight.getDepartureDateTime()),
                new AirportPortImpl().readAirportByCode(apiFlight.getDepartureAirportCode()),
                DateParser.getDateTimeFromRFC3339(apiFlight.getArrivalDateTime()),
                new AirportPortImpl().readAirportByCode(apiFlight.getArrivalAirportCode()),
                DateParser.getDateTimeFromRFC3339(apiFlight.getBoardingTime()),
                DomainFlight.FlightStatus.valueOf(apiFlight.getStatus().name()),
                apiFlight.getDuration(),
                new EmployeePortImpl().readEmployeeById(apiFlight.getPilotId()),
                new EmployeePortImpl().readEmployeeById(apiFlight.getCopilotId())
        );
    }
}
