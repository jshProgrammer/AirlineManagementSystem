package de.tjjf.Infrastructure.api.adapter;

import de.tjjf.Infrastructure.persistence.adapter.MEmployeeRepositoryImpl;
import de.tjjf.Domain.UseCases.Services.EmployeeService;
import de.tjjf.Domain.models.DomainEmployee;
import de.tjjf.Domain.ports.API.EmployeePort;

public class EmployeePortImpl implements EmployeePort {
    @Override
    public DomainEmployee createEmployee(DomainEmployee employee){
        return new EmployeeService(new MEmployeeRepositoryImpl()).
                createEmployee(employee);
    }

    //10.01.2025: Gespräch mit Prof. Dr. Braun: Authorization nicht notwendig da Error Weitergabe von Resolver zu Client in GraphQL kaum umsetzbar
    @Override
    public boolean verifyPassword(DomainEmployee employee, String password) {
        return true;
    }

    @Override
    public DomainEmployee readEmployeeById(long id) {
        return new EmployeeService(new MEmployeeRepositoryImpl()).readById(id);
    }

    @Override
    public void updateEmployee(DomainEmployee employee){
        new EmployeeService(new MEmployeeRepositoryImpl()).updateEmployee(employee);
    }
}
