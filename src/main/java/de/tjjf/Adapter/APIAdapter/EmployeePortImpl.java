package de.tjjf.Adapter.APIAdapter;

import de.tjjf.Domain.models.MEmployee;
import de.tjjf.Domain.ports.API.EmployeePort;

public class EmployeePortImpl implements EmployeePort {
    @Override
    public void createEmployee(MEmployee employee){

    }

    @Override
    public boolean verifyPassword(MEmployee employee, String password) {
        return true;
    }

    @Override
    public MEmployee readEmployeeById(long id) {
        return null;
    }

    @Override
    public void updateEmployee(MEmployee employee){

    }
}
