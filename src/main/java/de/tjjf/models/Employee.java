package de.tjjf.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Employee {
    @Id
    private int employeeId;
    private int personId;
    private int salary;
    private String position;
    private String flugGesellschaft;
    private Date hireDate;

    public Employee() {}

    public Employee(int personId, int salary, String position, String flugGesellschaft, Date hireDate) {
        this.personId = personId;
        this.salary = salary;
        this.position = position;
        this.flugGesellschaft = flugGesellschaft;
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

    public String getFlugGesellschaft() {
        return flugGesellschaft;
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

    public void setFlugGesellschaft(String flugGesellschaft) {
        this.flugGesellschaft = flugGesellschaft;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }
}
