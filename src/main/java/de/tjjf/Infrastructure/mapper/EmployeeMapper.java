package de.tjjf.Infrastructure.mapper;

import de.tjjf.Domain.models.MEmployee;
import de.tjjf.Infrastructure.models.Employee;

/*
public class EmployeeMapper extends Mapper<MEmployee, Employee>{

    public Employee toEntity(MEmployee mEmployee){
        return new Employee(
                mEmployee.getEmployeeId(),
                mEmployee.getPersonId(),
                mEmployee.getSalary(),
                mEmployee.getPosition(),
                mEmployee.getAirline(),
                mEmployee.getHireDate()
        );
    }

    public MEmployee toDomain(Employee employee){
        return new MEmployee(
                employee.getEmployeeId(),
                employee.getPersonId(),
                employee.getSalary(),
                employee.getPosition(),
                employee.getAirline(),
                employee.getHireDate()
        );
    }
}
*/