package de.tjjf.Infrastructure.persistence.DatabaseAdapter;

import de.tjjf.Domain.models.MAirplane;
import de.tjjf.Domain.ports.DB.DataAccess;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Create.AirplaneCreateImpl;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Delete.AirplaneDeleteImpl;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Read.AirplaneReadImpl;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Update.AirplaneUpdateImpl;
import de.tjjf.Infrastructure.persistence.mapper.AirplaneMapper;

public class MAirplaneRepositoryImpl implements DataAccess.MAirplaneRepository {
    @Override
    public void create(MAirplane entity) {
        new AirplaneCreateImpl(new AirplaneMapper().toEntity(entity)).execute();
    }

    @Override
    public MAirplane readById(Integer id) {
        return new AirplaneMapper().toDomain(new AirplaneReadImpl(id).execute().model);
    }

    @Override
    public void update(MAirplane entity) {
        new AirplaneUpdateImpl(new AirplaneMapper().toEntity(entity)).execute();
    }

    @Override
    public void delete(Integer id) {
        new AirplaneDeleteImpl(id).execute();
    }
}
