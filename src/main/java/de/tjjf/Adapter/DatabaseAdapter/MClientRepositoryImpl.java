package de.tjjf.Adapter.DatabaseAdapter;

import de.tjjf.Domain.models.MClient;
import de.tjjf.Domain.ports.DB.DataAccess;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Create.ClientCreateImpl;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Delete.ClientDeleteImpl;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Read.ClientReadImpl;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Update.ClientUpdateImpl;
import de.tjjf.Infrastructure.persistence.mapper.ClientMapper;

public class MClientRepositoryImpl implements DataAccess.MClientRepository {
    @Override
    public MClient create(MClient entity) {
        return new ClientMapper().toDomain(new ClientCreateImpl(new ClientMapper().toEntity(entity)).execute().model);
    }

    @Override
    public MClient readById(Long id){
        new ClientReadImpl(id).execute();
        return new ClientMapper().toDomain(new ClientReadImpl(id).execute().model);
    }

    @Override
    public void update(MClient entity){
        new ClientUpdateImpl(new ClientMapper().toEntity(entity)).execute();
    }

    @Override
    public void delete(Long id){
        new ClientDeleteImpl(id).execute();
    }


}
