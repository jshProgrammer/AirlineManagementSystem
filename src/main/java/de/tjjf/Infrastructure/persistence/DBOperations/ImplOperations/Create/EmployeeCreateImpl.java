package de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Create;

import de.tjjf.Infrastructure.persistence.DBOperations.AbstractOperations.AbstractCreateOperation;
import de.tjjf.Infrastructure.persistence.entities.Employee;

public class EmployeeCreateImpl extends AbstractCreateOperation<Employee> {
    public EmployeeCreateImpl(Employee modelToPersist){
        super(modelToPersist);
    }
}
