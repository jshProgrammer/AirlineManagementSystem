package de.tjjf.Domain.UseCases.Services;

import de.tjjf.Domain.models.MEmployee;
import de.tjjf.Domain.ports.DB.DataAccess;

public class EmployeeService {
    DataAccess.MEmployeeRepository port;

    public EmployeeService(DataAccess.MEmployeeRepository port){
        this.port = port;
    }

    //TODO: noch richtig implementieren
    public boolean verifyPassword(MEmployee employee, String password){
        return true;
    }

    public void createEmployee(MEmployee employee){
        port.create(employee);
    }

    public MEmployee readById(long id){
        return port.readById(id);
    }

    public void updateEmployee(MEmployee employee){
        port.update(employee);
    }
}
