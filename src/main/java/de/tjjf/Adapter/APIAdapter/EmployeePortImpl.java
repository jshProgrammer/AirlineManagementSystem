package de.tjjf.Adapter.APIAdapter;

import de.tjjf.Adapter.DatabaseAdapter.MAirlineRepositoryImpl;
import de.tjjf.Adapter.DatabaseAdapter.MEmployeeRepositoryImpl;
import de.tjjf.Domain.UseCases.Services.AirlineService;
import de.tjjf.Domain.UseCases.Services.EmployeeService;
import de.tjjf.Domain.models.MEmployee;
import de.tjjf.Domain.ports.API.EmployeePort;

public class EmployeePortImpl implements EmployeePort {
    @Override
    public MEmployee createEmployee(MEmployee employee){
        return new EmployeeService(new MEmployeeRepositoryImpl()).
                createEmployee(employee);
    }

    //TODO: implement authentication here
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
