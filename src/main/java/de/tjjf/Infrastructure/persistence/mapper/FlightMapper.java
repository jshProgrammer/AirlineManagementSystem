package de.tjjf.Infrastructure.persistence.mapper;


import de.tjjf.Domain.models.MFlight;
import de.tjjf.Infrastructure.persistence.entities.Flight;
import de.tjjf.Infrastructure.persistence.entities.Ticket;

public class FlightMapper extends Mapper<MFlight, Flight> {

    public Flight toEntity(MFlight mFlight){
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
                new EmployeeMapper().toEntity(mFlight.getPilot()),
                new EmployeeMapper().toEntity(mFlight.getCopilot())
        );
    }

    public MFlight toDomain(Flight flight){
        return new MFlight(
                flight.getFlightNum(),
                new AirplaneMapper().toDomain(flight.getAirplane()),
                flight.getDepartureDateTime(),
                new AirportMapper().toDomain(flight.getDepartureAirport()),
                flight.getArrivalDateTime(),
                new AirportMapper().toDomain(flight.getArrivalAirport()),
                flight.getBoardingTime(),
                MFlight.FlightStatus.valueOf(flight.getStatus()),
                flight.getDuration(),
                new EmployeeMapper().toDomain(flight.getPilot()),
                new EmployeeMapper().toDomain(flight.getCopilot())
        );
    }
}
