package de.tjjf.Infrastructure.persistence.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Client implements Model {
    @Id
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

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "client")
    private List<Ticket> tickets = new ArrayList<>();

    @Column(nullable=false)
    private boolean isBusinessClient;

    public Client() {}

    public Client(String firstName, String middleName, String lastName, Date dateOfBirth, String phonenumber, String address, String email, List<Ticket> tickets, boolean isBusinessClient) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.phonenumber = phonenumber;
        this.address = address;
        this.email = email;
        if(tickets != null) {this.tickets = tickets;}
        this.isBusinessClient = isBusinessClient;
    }

    public Client(Long personId, String firstName, String middleName, String lastName, Date dateOfBirth, String phonenumber, String address, String email, List<Ticket> tickets, boolean isBusinessClient) {
        this(firstName, middleName, lastName, dateOfBirth, phonenumber, address, email, tickets, isBusinessClient);
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

    public boolean isBusinessClient() {
        return isBusinessClient;
    }

    public void setBusinessClient(boolean businessClient) {
        isBusinessClient = businessClient;
    }
}
