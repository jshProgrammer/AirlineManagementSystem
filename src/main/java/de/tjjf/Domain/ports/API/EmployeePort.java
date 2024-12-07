package de.tjjf.Domain.ports.API;

import de.tjjf.Domain.models.MEmployee;

public interface EmployeePort {
    void createEmployee(MEmployee employee);
    boolean verifyPassword(MEmployee employee, String password);
    MEmployee readEmployeeById(long id);
    MEmployee updateEmployee(MEmployee employee);
}