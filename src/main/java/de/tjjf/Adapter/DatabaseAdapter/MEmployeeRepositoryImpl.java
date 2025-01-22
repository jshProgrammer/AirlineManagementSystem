package de.tjjf.Adapter.DatabaseAdapter;

import de.tjjf.Domain.models.DomainEmployee;
import de.tjjf.Domain.ports.DB.DataAccess;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Create.EmployeeCreateImpl;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Delete.EmployeeDeleteImpl;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Read.EmployeeReadImpl;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Update.EmployeeUpdateImpl;
import de.tjjf.Infrastructure.persistence.mapper.EmployeeMapper;

public class MEmployeeRepositoryImpl implements DataAccess.MEmployeeRepository{
    @Override
    public DomainEmployee create(DomainEmployee entity) {
        return new EmployeeMapper().toDomain(new EmployeeCreateImpl(new EmployeeMapper().toEntity(entity)).execute().model);
    }

    @Override
    public DomainEmployee readById(Long id){
        return new EmployeeMapper().toDomain(new EmployeeReadImpl(id).execute().model);
    }

    @Override
    public void update(DomainEmployee entity){
        new EmployeeUpdateImpl(new EmployeeMapper().toEntity(entity), entity.getEmployeeId()).execute();
    }

    @Override
    public void delete(Long id){
        new EmployeeDeleteImpl(id).execute();
    }
}
