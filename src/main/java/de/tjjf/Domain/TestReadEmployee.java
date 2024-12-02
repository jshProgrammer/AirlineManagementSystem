package de.tjjf.Domain;

import de.tjjf.Domain.models.MEmployee;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Read.EmployeeReadImpl;
import de.tjjf.Infrastructure.persistence.mapper.EmployeeMapper;

public class TestReadEmployee {
    public static MEmployee ReadEmployee(long id) {
        MEmployee employee = new EmployeeMapper().toDomain(new EmployeeReadImpl(id).run().model);
        return employee;
    }
}
