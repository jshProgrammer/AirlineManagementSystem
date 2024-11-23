package de.tjjf.Domain.models;

import java.util.Date;

public class MEmployee extends MPerson implements MModel {
    private long employeeId;

    private int salary;

    private String position;

    private MAirline airline;

    private Date hireDate;

    public MEmployee(long personId, String firstName, String middleNames, String lastName, Date dateOfBirth, String phonenumber, MAddress address, String email, String password, int salary, String position, MAirline airline, Date hireDate) {
        super(personId, firstName, middleNames, lastName, dateOfBirth, phonenumber, address, email, password);
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

    public MAirline getAirline() {
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

    public void setAirline(MAirline airline) {
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
