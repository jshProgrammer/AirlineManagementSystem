package de.tjjf.Infrastructure.persistence.DatabaseAdapter;

import de.tjjf.Domain.models.MEmployee;
import de.tjjf.Domain.ports.DataAccess;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Create.EmployeeCreateImpl;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Delete.EmployeeDeleteImpl;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Read.EmployeeReadImpl;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Update.EmployeeUpdateImpl;
import de.tjjf.Infrastructure.persistence.mapper.EmployeeMapper;

public class MEmployeeRepositoryImpl implements DataAccess.MEmployeeRepository{
    @Override
    public void create(MEmployee entity) {
        new EmployeeCreateImpl(new EmployeeMapper().toEntity(entity)).execute();
    }

    @Override
    public MEmployee readById(Long id){
        new EmployeeReadImpl(id).execute();
        return new EmployeeMapper().toDomain(new EmployeeReadImpl(id).execute().model);
    }

    @Override
    public void update(MEmployee entity){
        new EmployeeUpdateImpl(new EmployeeMapper().toEntity(entity)).execute();
    }

    @Override
    public void delete(Long id){
        new EmployeeDeleteImpl(id).execute();
    }
}
