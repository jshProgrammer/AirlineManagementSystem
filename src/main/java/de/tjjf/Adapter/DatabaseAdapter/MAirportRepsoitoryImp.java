package de.tjjf.Adapter.DatabaseAdapter;

import de.tjjf.Domain.models.MAirport;
import de.tjjf.Domain.ports.DB.DataAccess;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Create.AirportCreateImpl;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Delete.AirportDeleteImpl;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Read.AirportReadImpl;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Update.AirportUpdateImpl;
import de.tjjf.Infrastructure.persistence.mapper.AirportMapper;

public class MAirportRepsoitoryImp implements DataAccess.MAirportRepository {

    @Override
    public MAirport create(MAirport entity) {
        return new AirportMapper().toDomain(new AirportCreateImpl(new AirportMapper().toEntity(entity)).execute().model);
    }

    @Override
    public MAirport readById(String code) {
        return new AirportMapper().toDomain(new AirportReadImpl(code).execute().model);
    }

    @Override
    public void update(MAirport entity) {
        new AirportUpdateImpl(new AirportMapper().toEntity(entity), entity.getCode()).execute();

    }

    @Override
    public void delete(String code) {
        new AirportDeleteImpl(code).execute();
    }
}
