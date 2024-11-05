package de.tjjf.Infrastructure.mapper;

import de.tjjf.Domain.models.MAirplane;
import de.tjjf.Infrastructure.models.Airplane;

public class AirplaneMapper {

    public static Airplane toEntity(MAirplane mAirplane){
        return new Airplane(
                mAirplane.getSerialNum(),
                mAirplane.getManufacturer(),
                mAirplane.getModel(),
                mAirplane.getAmoutOfEconomySeats(),
                mAirplane.getAmoutOfBusinessSeats(),
                mAirplane.getAmoutOfFirstClassSeats(),
                new AirlineMapper().toEntity(mAirplane.getBelongingAirline()),
                mAirplane.isOperatable()
        );
    }

    public static MAirplane toDomain(Airplane airplane){
        return new MAirplane(
                airplane.getSerialNum(),
                airplane.getManufacturer(),
                airplane.getModel(),
                airplane.getAmoutOfEconomySeats(),
                airplane.getAmoutOfBusinessSeats(),
                airplane.getAmoutOfFirstClassSeats(),
                new AirlineMapper().toDomain(airplane.getBelongingAirline()),
                airplane.isOperatable()
        );
    }
}
