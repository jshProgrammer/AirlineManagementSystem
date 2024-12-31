package de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Update;

import de.tjjf.Infrastructure.persistence.DBOperations.AbstractOperations.AbstractUpdateOperation;
import de.tjjf.Infrastructure.persistence.entities.Employee;

public class EmployeeUpdateImpl extends AbstractUpdateOperation<Employee, Long> {
    public EmployeeUpdateImpl(Employee modelToPersist, Long personId){
        super(modelToPersist, personId);
    }
}
