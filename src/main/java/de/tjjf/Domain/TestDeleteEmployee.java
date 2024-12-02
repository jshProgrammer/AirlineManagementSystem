package de.tjjf.Domain;

import de.tjjf.Domain.models.MEmployee;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Delete.EmployeeDeleteImpl;
import de.tjjf.Infrastructure.persistence.entities.Employee;
import de.tjjf.Infrastructure.persistence.mapper.EmployeeMapper;

public class TestDeleteEmployee {
    //TODO: Wirklich benötigt? Ruft nur Methode auf die man auch so nutzen könnte
    public static void deleteEmployee(long memployee) {
        new EmployeeDeleteImpl(memployee).run();
    }
}
