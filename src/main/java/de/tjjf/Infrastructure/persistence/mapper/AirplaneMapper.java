package de.tjjf.Infrastructure.persistence.mapper;

import de.tjjf.Domain.models.DomainAirplane;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Read.AirlineReadImpl;
import de.tjjf.Infrastructure.persistence.entities.Airplane;

public class AirplaneMapper extends Mapper<DomainAirplane, Airplane> {

    public Airplane toEntity(DomainAirplane mAirplane){
        return new Airplane(
                mAirplane.getSerialNum(),
                mAirplane.getManufacturer(),
                mAirplane.getModel(),
                mAirplane.getAmountOfEconomySeats(),
                mAirplane.getAmountOfBusinessSeats(),
                mAirplane.getAmountOfFirstClassSeats(),
                new AirlineMapper().toEntity(mAirplane.getBelongingAirline()),
                mAirplane.isOperable(),
                mAirplane.getMaxWeightOfLuggage()
        );
    }

   public DomainAirplane toDomain(Airplane airplane){
        return new DomainAirplane(
                airplane.getSerialNum(),
                airplane.getManufacturer(),
                airplane.getModel(),
                airplane.getAmountOfEconomySeats(),
                airplane.getAmountOfBusinessSeats(),
                airplane.getAmountOfFirstClassSeats(),
                new AirlineMapper().toDomain(new AirlineReadImpl(airplane.getBelongingAirline().getName()).execute().model),
                airplane.isOperable(),
                airplane.getMaxWeightOfLuggage()
        );
    }
}
