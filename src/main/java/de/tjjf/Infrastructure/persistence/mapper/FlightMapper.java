package de.tjjf.Infrastructure.persistence.mapper;

import de.tjjf.Domain.models.DomainFlight;
import de.tjjf.Infrastructure.persistence.entities.Flight;

public class FlightMapper extends Mapper<DomainFlight, Flight> {

    public Flight toEntity(DomainFlight mFlight){
        return new Flight(
                new AirplaneMapper().toEntity(mFlight.getAirplane()),
                mFlight.getDepartureDateTime(),
                new AirportMapper().toEntity(mFlight.getDepartureAirport()),
                mFlight.getArrivalDateTime(),
                new AirportMapper().toEntity(mFlight.getArrivalAirport()),
                mFlight.getBoardingTime(),
                mFlight.getStatus().name(),
                mFlight.getDuration(),
                new EmployeeMapper().toEntityWithId(mFlight.getPilot()),
                new EmployeeMapper().toEntityWithId(mFlight.getCopilot())
        );
    }

    public Flight toEntityWithFlightNum(DomainFlight mFlight){
        return new Flight(
                mFlight.getFlightNum(),
                new AirplaneMapper().toEntity(mFlight.getAirplane()),
                mFlight.getDepartureDateTime(),
                new AirportMapper().toEntity(mFlight.getDepartureAirport()),
                mFlight.getArrivalDateTime(),
                new AirportMapper().toEntity(mFlight.getArrivalAirport()),
                mFlight.getBoardingTime(),
                mFlight.getStatus().name(),
                mFlight.getDuration(),
                new EmployeeMapper().toEntityWithId(mFlight.getPilot()),
                new EmployeeMapper().toEntityWithId(mFlight.getCopilot())
        );
    }



    public DomainFlight toDomain(Flight flight){
        return new DomainFlight(
                flight.getFlightNum(),
                new AirplaneMapper().toDomain(flight.getAirplane()),
                flight.getDepartureDateTime(),
                new AirportMapper().toDomain(flight.getDepartureAirport()),
                flight.getArrivalDateTime(),
                new AirportMapper().toDomain(flight.getArrivalAirport()),
                flight.getBoardingTime(),
                DomainFlight.FlightStatus.valueOf(flight.getStatus()),
                flight.getDuration(),
                new EmployeeMapper().toDomain(flight.getPilot()),
                new EmployeeMapper().toDomain(flight.getCopilot())
        );
    }
}
