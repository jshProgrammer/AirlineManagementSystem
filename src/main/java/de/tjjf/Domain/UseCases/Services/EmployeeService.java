package de.tjjf.Domain.UseCases.Services;

import de.tjjf.Domain.UseCases.AuthenticationUseCase;
import de.tjjf.Domain.UseCases.AuthorizedUseCase;
import de.tjjf.Domain.models.DomainEmployee;
import de.tjjf.Domain.ports.DB.DataAccess;

public class EmployeeService extends AuthorizedUseCase {
    DataAccess.MEmployeeRepository port;

    public EmployeeService(DataAccess.MEmployeeRepository port){
        super(AuthenticationUseCase.getInstance());
        this.port = port;
    }

    public boolean verifyPassword(DomainEmployee employee, String password){
        //new CancelTicketUseCase().authorize();
        return true;
    }

    public DomainEmployee createEmployee(DomainEmployee employee){
        //new CancelTicketUseCase().authorize();
        return port.create(employee);
    }

    public DomainEmployee readById(long id){
        //new CancelTicketUseCase().authorize();
        return port.readById(id);
    }

    public void updateEmployee(DomainEmployee employee){
        //new CancelTicketUseCase().authorize();
        port.update(employee);
    }
}
