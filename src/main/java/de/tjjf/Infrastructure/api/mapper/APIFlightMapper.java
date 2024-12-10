package de.tjjf.Infrastructure.api.mapper;

import de.tjjf.Domain.models.MFlight;
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
                mFlight.getDepartureDateTime(),
                mFlight.getDepartureAirport().getCode(),
                mFlight.getArrivalDateTime(),
                mFlight.getArrivalAirport().getCode(),
                mFlight.getBoardingTime(),
                //TODO: enum Umwandlung noch durch mapper
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
                apiFlight.getDepartureDateTime(),
                new AirportPortImpl().readAirportByCode(apiFlight.getDepartureAirport()),
                apiFlight.getArrivalDateTime(),
                new AirportPortImpl().readAirportByCode(apiFlight.getArrivalAirport()),
                apiFlight.getBoardingTime(),
                //TODO: enum Umwandlung noch durch mapper
                MFlight.FlightStatus.valueOf(apiFlight.getStatus().name()),
                apiFlight.getDuration(),
                new EmployeePortImpl().readEmployeeById(apiFlight.getPilot()),
                new EmployeePortImpl().readEmployeeById(apiFlight.getCopilot())
        );
    }
}
