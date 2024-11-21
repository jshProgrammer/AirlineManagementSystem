package de.tjjf.Infrastructure.persistence.mapper;

import de.tjjf.Domain.models.MAirline;
import de.tjjf.Domain.models.MAirplane;
import de.tjjf.Infrastructure.persistence.entities.Airline;
import de.tjjf.Infrastructure.persistence.entities.Airplane;

public class AirplaneMapper extends Mapper<MAirplane, Airplane> {

    public  Airplane toEntity(MAirplane mAirplane){
        return new Airplane(
                mAirplane.getSerialNum(),
                mAirplane.getManufacturer(),
                mAirplane.getModel(),
                mAirplane.getAmountOfEconomySeats(),
                mAirplane.getAmountOfBusinessSeats(),
                mAirplane.getAmountOfFirstClassSeats(),
                new AirlineMapper().toEntity(mAirplane.getBelongingAirline()),
                mAirplane.isOperatable()
        );
    }

    //TODO
    public MAirplane toDomain(Airplane airplane) {
        return new MAirplane(0, "", "", 0, 0, 0, null, false, 0);
    }

   /*public MAirplane toDomain(Airplane airplane){
        return new MAirplane(
                airplane.getSerialNum(),
                airplane.getManufacturer(),
                airplane.getModel(),
                airplane.getAmountOfEconomySeats(),
                airplane.getAmountOfBusinessSeats(),
                airplane.getAmountOfFirstClassSeats(),
                new AirlineMapper().toDomain(mAirplane.getBelongingAirline()),
                mAirplane.isOperatable()
        );
    }*/
}
