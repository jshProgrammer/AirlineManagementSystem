package de.tjjf.Infrastructure.persistence.adapter;

import de.tjjf.Domain.models.DomainAirline;
import de.tjjf.Domain.ports.DB.DataAccess;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Create.AirlineCreateImpl;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Delete.AirlineDeleteImpl;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Read.AirlineReadImpl;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Update.AirlineUpdateImpl;
import de.tjjf.Infrastructure.persistence.mapper.AirlineMapper;

public class MAirlineRepositoryImpl implements DataAccess.MAirlineRepository {
    @Override
   public DomainAirline create(DomainAirline entity) {
         return new AirlineMapper().toDomain(new AirlineCreateImpl(new AirlineMapper().toEntity(entity)).execute().model);
    }

    @Override
    public DomainAirline readById(String s) {
        new AirlineReadImpl(s).execute();
        return new AirlineMapper().toDomain(new AirlineReadImpl(s).execute().model);
    }

    @Override
    public void update(DomainAirline entity) {
        new AirlineUpdateImpl(new AirlineMapper().toEntity(entity), entity.getName()).execute();
    }

    @Override
    public void delete(String name) {
        new AirlineDeleteImpl(name).execute();
    }
}
