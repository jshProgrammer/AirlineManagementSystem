package de.tjjf.Infrastructure.persistence.adapter;

import de.tjjf.Domain.models.DomainAirplane;
import de.tjjf.Domain.ports.DB.DataAccess;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Create.AirplaneCreateImpl;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Delete.AirplaneDeleteImpl;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Read.AirplaneReadImpl;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Update.AirplaneUpdateImpl;
import de.tjjf.Infrastructure.persistence.mapper.AirplaneMapper;

public class MAirplaneRepositoryImpl implements DataAccess.MAirplaneRepository {
    @Override
    public DomainAirplane create(DomainAirplane entity) {
        return new AirplaneMapper().toDomain(new AirplaneCreateImpl(new AirplaneMapper().toEntity(entity)).execute().model);
    }

    @Override
    public DomainAirplane readById(Integer id) {
        return new AirplaneMapper().toDomain(new AirplaneReadImpl(id).execute().model);
    }

    @Override
    public void update(DomainAirplane entity) {
        new AirplaneUpdateImpl(new AirplaneMapper().toEntity(entity), entity.getSerialNum()).execute();
    }

    @Override
    public void delete(Integer id) {
        new AirplaneDeleteImpl(id).execute();
    }
}
