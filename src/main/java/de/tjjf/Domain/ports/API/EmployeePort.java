package de.tjjf.Domain.ports.API;

import de.tjjf.Domain.models.DomainEmployee;

public interface EmployeePort {
    DomainEmployee createEmployee(DomainEmployee employee);
    boolean verifyPassword(DomainEmployee employee, String password);
    DomainEmployee readEmployeeById(long id);
    void updateEmployee(DomainEmployee employee);
}