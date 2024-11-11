package de.tjjf.Infrastructure.persistence.mapper;

import de.tjjf.Domain.models.MAirplane;
import de.tjjf.Infrastructure.persistence.entities.Airplane;

public class AirplaneMapper extends Mapper<MAirplane, Airplane> {

    public  Airplane toEntity(MAirplane mAirplane){
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

    public MAirplane toDomain(Airplane airplane){
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
