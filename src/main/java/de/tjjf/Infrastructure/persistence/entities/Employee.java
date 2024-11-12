package de.tjjf.Infrastructure.persistence.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Employee implements Model {
    @Column(nullable=false)
    @Id
    private int employeeId;

    @OneToOne
    private Person personId;

    @Column(nullable=false)
    private int salary;

    @Column(nullable=false)
    private String position;

    @ManyToOne()
    //@JoinColumn(name = "airline_name", referencedColumnName = "name")
    private Airline airline;

    @Column(nullable=false)
    private Date hireDate;

    public Employee() {}

    public Employee(Person personId, int salary, String position, Airline airline, Date hireDate) {
        this.personId = personId;
        this.salary = salary;
        this.position = position;
        this.airline = airline;
        this.hireDate = hireDate;
    }
    public Employee(int employeeId, Person personId, int salary, String position, Airline airline, Date hireDate) {
        this.employeeId = employeeId;
        this.personId = personId;
        this.salary = salary;
        this.position = position;
        this.airline = airline;
        this.hireDate = hireDate;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public Person getPersonId() {
        return personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }
}
