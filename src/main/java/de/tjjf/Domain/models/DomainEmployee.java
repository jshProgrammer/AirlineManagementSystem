package de.tjjf.Domain.models;

import java.util.Date;

public class DomainEmployee extends DomainPerson implements DomainModel {

    private long employeeId;

    private int salary;

    private String position;

    private DomainAirline airline;

    private Date hireDate;

    public DomainEmployee(long personId, String firstName, String middleNames, String lastName, Date dateOfBirth, String phonenumber, DomainAddress address, String email, int salary, String position, DomainAirline airline, Date hireDate) {
        super(personId, firstName, middleNames, lastName, dateOfBirth, phonenumber, address, email, null);
        this.employeeId = personId;
        this.salary = salary;
        this.position = position;
        this.airline = airline;
        this.hireDate = hireDate;
    }


    public int getSalary() {
        return salary;
    }

    public String getPosition() {
        return position;
    }

    public DomainAirline getAirline() {
        return airline;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setAirline(DomainAirline airline) {
        this.airline = airline;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
}
