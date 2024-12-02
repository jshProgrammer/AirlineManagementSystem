package de.tjjf.Domain;

import de.tjjf.Domain.models.MEmployee;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Update.EmployeeUpdateImpl;
import de.tjjf.Infrastructure.persistence.entities.Employee;
import de.tjjf.Infrastructure.persistence.mapper.EmployeeMapper;

public class TestUpdateEmployee {
    public static void UpdateEmployee(MEmployee memployee) {
        Employee employee = new EmployeeMapper().toEntity(memployee);
        new EmployeeUpdateImpl(employee).run();
    }
}
