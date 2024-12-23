package de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Delete;

import de.tjjf.Infrastructure.persistence.DBOperations.AbstractOperations.AbstractDeleteOperation;
import de.tjjf.Infrastructure.persistence.entities.Employee;

public class EmployeeDeleteImpl extends AbstractDeleteOperation<Employee, Long> {
    public EmployeeDeleteImpl(Long identifier){
        super(Employee.class, identifier);
    }
}
