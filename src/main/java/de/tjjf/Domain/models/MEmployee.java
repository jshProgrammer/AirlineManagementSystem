package de.tjjf.Domain.models;

import java.util.Date;

public class MEmployee {
    private int employeeId;

    private int personId;

    private int salary;

    private String position;

    private MAirline airline;

    private Date hireDate;

    public MEmployee(int personId, int salary, String position, MAirline airline, Date hireDate) {
        this.personId = personId;
        this.salary = salary;
        this.position = position;
        this.airline = airline;
        this.hireDate = hireDate;
    }
    public MEmployee(int employeeId, int personId, int salary, String position, MAirline airline, Date hireDate) {
        this.employeeId = employeeId;
        this.personId = personId;
        this.salary = salary;
        this.position = position;
        this.airline = airline;
        this.hireDate = hireDate;
    }

    public int getPersonId() {
        return personId;
    }

    public int getSalary() {
        return salary;
    }

    public String getPosition() {
        return position;
    }

    public MAirline getAirline() {
        return airline;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setAirline(MAirline airline) {
        this.airline = airline;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
}
