package de.tjjf.Infrastructure.mapper;

import de.tjjf.Domain.models.MEmployee;
import de.tjjf.Infrastructure.models.Employee;

public class EmployeeMapper {

    public static Employee toEntity(MEmployee mEmployee){
        return new Employee(
                mEmployee.getEmployeeId(),
                mEmployee.getPersonId(),
                mEmployee.getSalary(),
                mEmployee.getPosition(),
                mEmployee.getAirline(),
                mEmployee.getHireDate()
        );
    }

    public static MEmployee toDomain(Employee employee){
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
