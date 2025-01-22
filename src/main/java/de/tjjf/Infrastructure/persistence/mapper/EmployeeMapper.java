package de.tjjf.Infrastructure.persistence.mapper;

import de.tjjf.Domain.models.DomainEmployee;
import de.tjjf.Domain.models.DomainPerson;
import de.tjjf.Domain.models.DomainTicket;
import de.tjjf.Infrastructure.persistence.entities.Employee;
import de.tjjf.Infrastructure.persistence.entities.Ticket;

import java.util.ArrayList;
import java.util.List;

public class EmployeeMapper extends Mapper<DomainEmployee, Employee>{

    public Employee toEntity(DomainEmployee employee) {
        return toEntity(employee, true);
    }


    public Employee toEntity(DomainEmployee mEmployee, boolean mapTickets){
        Employee employee = new Employee(
                mEmployee.getFirstName(),
                mEmployee.getMiddleNames(),
                mEmployee.getLastName(),
                mEmployee.getDateOfBirth(),
                mEmployee.getPhonenumber(),
                new AddressMapper().toEntity(mEmployee.getAddress()),
                mEmployee.getEmail(),
                null,
                mEmployee.getSalary(),
                mEmployee.getPosition(),
                new AirlineMapper().toEntity(mEmployee.getAirline()),
                mEmployee.getHireDate()
        );
        if (mapTickets) {
            List<Ticket> tickets = new ArrayList<>();
            for (DomainTicket mTicket : mEmployee.getTickets()) {
                Ticket ticket = new TicketMapper().toEntity(mTicket);
                ticket.setEmployee(employee);
                tickets.add(ticket);
            }
            employee.setTickets(tickets);
        }

        return employee;
    }

    public Employee toEntityWithId(DomainEmployee mEmployee) {
        List<Ticket> tickets = new ArrayList<>();

        for(DomainTicket mTicket : mEmployee.getTickets()){
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
                tickets,
                mEmployee.getSalary(),
                mEmployee.getPosition(),
                new AirlineMapper().toEntity(mEmployee.getAirline()),
                mEmployee.getHireDate()
        );
    }

    public Employee toEntityWithId(DomainEmployee mEmployee, boolean mapTickets) {
        Employee employee = new Employee(
                mEmployee.getPersonId(),
                mEmployee.getFirstName(),
                mEmployee.getMiddleNames(),
                mEmployee.getLastName(),
                mEmployee.getDateOfBirth(),
                mEmployee.getPhonenumber(),
                new AddressMapper().toEntity(mEmployee.getAddress()),
                mEmployee.getEmail(),
                null,
                mEmployee.getSalary(),
                mEmployee.getPosition(),
                new AirlineMapper().toEntity(mEmployee.getAirline()),
                mEmployee.getHireDate()
        );
        if (mapTickets) {
            List<Ticket> tickets = new ArrayList<>();
            for (DomainTicket mTicket : mEmployee.getTickets()) {
                Ticket ticket = new TicketMapper().toEntity(mTicket);
                ticket.setEmployee(employee);
                tickets.add(ticket);
            }
            employee.setTickets(tickets);
        }

        return employee;
    }

    public DomainEmployee toDomain(Employee employee){
        DomainPerson person = new PersonMapper().toDomain(employee);
        return new DomainEmployee(
                person.getPersonId(),
                person.getFirstName(),
                person.getMiddleNames(),
                person.getLastName(),
                person.getDateOfBirth(),
                person.getPhonenumber(),
                person.getAddress(),
                person.getEmail(),
                employee.getSalary(),
                employee.getPosition(),
                new AirlineMapper().toDomain(employee.getAirline()),
                employee.getHireDate()
        );
    }
}
