package de.tjjf.Infrastructure.persistence.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Employee implements Model {

    @Id
    @Column(nullable=false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long personId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = true)
    private String middleName;

    @Column(nullable = false)
    private  String lastName;

    @Column(nullable = false)
    private Date dateOfBirth;

    @Column(nullable = false)
    private String phonenumber;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String email;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "employee")
    //@JoinColumn(name = "personId", referencedColumnName = "personId")
    private List<Ticket> tickets = new ArrayList<>();

    @Column(nullable=false)
    private int salary;

    @Column(nullable=false)
    private String position;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "airline_name", referencedColumnName = "name")
    private Airline airline;

    @Column(nullable=false)
    private Date hireDate;

    public Employee() {}

    public Employee(String firstName, String middleName, String lastName, Date dateOfBirth, String phonenumber, String address, String email, List<Ticket> tickets, int salary, String position, Airline airline, Date hireDate) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.phonenumber = phonenumber;
        this.address = address;
        this.email = email;
        this.tickets = tickets;
        this.salary = salary;
        this.position = position;
        this.airline = airline;
        this.hireDate = hireDate;
    }

    public Employee(long personId, String firstName, String middleName, String lastName, Date dateOfBirth, String phonenumber, String address, String email, List<Ticket> tickets, int salary, String position, Airline airline, Date hireDate) {
        this(firstName, middleName, lastName, dateOfBirth, phonenumber, address, email, tickets, salary, position, airline, hireDate);
        this.personId = personId;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
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
