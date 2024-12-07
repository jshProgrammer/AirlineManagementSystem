package de.tjjf.Infrastructure.persistence.DatabaseAdapter;

import de.tjjf.Domain.models.MAirline;
import de.tjjf.Domain.ports.DataAccess;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Create.AirlineCreateImpl;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Delete.AirlineDeleteImpl;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Read.AirlineReadImpl;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Update.AirlineUpdateImpl;
import de.tjjf.Infrastructure.persistence.mapper.AirlineMapper;

public class MAirlineRepositoryImpl implements DataAccess.MAirlineRepository {
    @Override
    public void create(MAirline entity) {
        new AirlineCreateImpl(new AirlineMapper().toEntity(entity)).execute();
    }

    @Override
    public MAirline readById(String s) {
        new AirlineReadImpl(s).execute();
        return new AirlineMapper().toDomain(new AirlineReadImpl(s).execute().model);
    }

    @Override
    public void update(MAirline entity) {
        new AirlineUpdateImpl(new AirlineMapper().toEntity(entity)).execute();
    }

    @Override
    public void delete(String name) {
        new AirlineDeleteImpl(name).execute();
    }
}
