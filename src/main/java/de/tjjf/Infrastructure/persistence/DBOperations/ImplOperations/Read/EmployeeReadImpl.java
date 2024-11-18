package de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Read;

import de.tjjf.Infrastructure.persistence.DBOperations.AbstractOperations.AbstractReadOperation;
import de.tjjf.Infrastructure.persistence.entities.Employee;

public class EmployeeReadImpl extends AbstractReadOperation<Employee, Integer> {
    public EmployeeReadImpl(Class<Employee> type, int identifier){
        super(type, identifier);
    }
}
