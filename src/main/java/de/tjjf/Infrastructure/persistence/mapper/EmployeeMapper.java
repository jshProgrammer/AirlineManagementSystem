package de.tjjf.Infrastructure.persistence.mapper;

import de.tjjf.Domain.models.MEmployee;
import de.tjjf.Domain.models.MPerson;
import de.tjjf.Domain.models.MTicket;
import de.tjjf.Infrastructure.persistence.entities.Employee;
import de.tjjf.Infrastructure.persistence.entities.Ticket;

import java.util.ArrayList;
import java.util.List;

public class EmployeeMapper extends Mapper<MEmployee, Employee>{

    public Employee toEntity(MEmployee mEmployee){
        List<Ticket> tickets = new ArrayList<>();

        for(MTicket mTicket : mEmployee.getTickets()){
            tickets.add(new TicketMapper().toEntity(mTicket));
        }

        return new Employee(
                mEmployee.getPersonId(),
                mEmployee.getFirstName(),
                mEmployee.getMiddleNames(),
                mEmployee.getLastName(),
                mEmployee.getDateOfBirth(),
                mEmployee.getPhonenumber(),
                new AddressMapper().toEntity(mEmployee.getAddress()),
                mEmployee.getEmail(),
                mEmployee.getHashedPassword(),
                tickets,
                mEmployee.getSalary(),
                mEmployee.getPosition(),
                new AirlineMapper().toEntity(mEmployee.getAirline()),
                mEmployee.getHireDate()
        );
    }

    public MEmployee toDomain(Employee employee){
        MPerson person = new PersonMapper().toDomain(employee);
        return new MEmployee(
                person.getPersonId(),
                person.getFirstName(),
                person.getMiddleNames(),
                person.getLastName(),
                person.getDateOfBirth(),
                person.getPhonenumber(),
                person.getAddress(),
                person.getEmail(),
                person.getHashedPassword(),
                employee.getSalary(),
                employee.getPosition(),
                new AirlineMapper().toDomain(employee.getAirline()),
                employee.getHireDate()
        );
    }
}
