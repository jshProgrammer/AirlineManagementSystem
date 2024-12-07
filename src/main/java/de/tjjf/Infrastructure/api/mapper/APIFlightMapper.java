package de.tjjf.Infrastructure.api.mapper;

import de.tjjf.Domain.models.MFlight;
import de.tjjf.Infrastructure.api.models.APIFlight;

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
        return null;
    }
}
