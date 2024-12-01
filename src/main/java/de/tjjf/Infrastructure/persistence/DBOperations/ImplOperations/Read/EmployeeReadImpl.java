package de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Read;

import de.tjjf.Infrastructure.persistence.DBOperations.AbstractOperations.AbstractReadOperation;
import de.tjjf.Infrastructure.persistence.entities.Employee;

public class EmployeeReadImpl extends AbstractReadOperation<Employee, Long> {
    public EmployeeReadImpl(long identifier){
        super(Employee.class, identifier);
    }
}
