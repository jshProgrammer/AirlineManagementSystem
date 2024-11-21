package de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Delete;

import de.tjjf.Infrastructure.persistence.DBOperations.AbstractOperations.AbstractDeleteOperation;
import de.tjjf.Infrastructure.persistence.entities.Employee;

public class EmployeeDeleteImpl extends AbstractDeleteOperation<Employee, Integer> {
    public EmployeeDeleteImpl(int identifier){
        super(Employee.class, identifier);
    }
}
