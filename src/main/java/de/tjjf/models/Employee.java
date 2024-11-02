package de.tjjf.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Employee {
    @Column(nullable=false)
    @Id
    private int employeeId;

    @Column(nullable=false)
    private int personId;

    @Column(nullable=false)
    private int salary;

    @Column(nullable=false)
    private String position;

    @ManyToOne()
    @JoinColumn(name = "airline_name", referencedColumnName = "name")
    private Airline airline;

    @Column(nullable=false)
    private Date hireDate;

    public Employee() {}

    public Employee(int personId, int salary, String position, Airline airline, Date hireDate) {
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

    public Airline getAirline() {
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

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }
}
