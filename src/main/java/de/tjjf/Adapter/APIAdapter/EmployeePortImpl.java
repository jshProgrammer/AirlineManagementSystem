package de.tjjf.Adapter.APIAdapter;

import de.tjjf.Adapter.DatabaseAdapter.MEmployeeRepositoryImpl;
import de.tjjf.Domain.UseCases.Services.EmployeeService;
import de.tjjf.Domain.models.MEmployee;
import de.tjjf.Domain.ports.API.EmployeePort;

public class EmployeePortImpl implements EmployeePort {
    @Override
    public MEmployee createEmployee(MEmployee employee){
        return new EmployeeService(new MEmployeeRepositoryImpl()).
                createEmployee(employee);
    }

    //10.01.2025: Gespräch mit Prof. Dr. Braun: Authorization nicht notwendig da Error Weitergabe von Resolver zu Client in GraphQL kaum umsetzbar
    @Override
    public boolean verifyPassword(MEmployee employee, String password) {
        return true;
    }

    @Override
    public MEmployee readEmployeeById(long id) {
        return new EmployeeService(new MEmployeeRepositoryImpl()).readById(id);
    }

    @Override
    public void updateEmployee(MEmployee employee){
        new EmployeeService(new MEmployeeRepositoryImpl()).updateEmployee(employee);
    }
}
